package com.dicero.diceroller.service.settlement;

import com.dicero.diceroller.common.bean.extension.CommonDefinedException;
import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.dal.mysql.repository.ClearingOrderInnerPORepository;
import com.dicero.diceroller.dal.mysql.repository.ClearingOrderOuterPORepository;
import com.dicero.diceroller.dal.mysql.repository.SettlementCarrierPORepository;
import com.dicero.diceroller.dal.mysql.repository.TradeOrderPORepository;
import com.dicero.diceroller.domain.enums.*;
import com.dicero.diceroller.domain.model.*;
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.bean.ClearAccount;
import com.dicero.diceroller.service.bean.InnerClearingEntity;
import com.dicero.diceroller.service.bean.OuterClearingEntity;
import com.dicero.diceroller.service.dpm.DpmAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
@Slf4j
public abstract  class AbstractSettlementStrategy extends BaseService {
    @Autowired DpmAccountService dpmAccountService;
    @Autowired SettlementOrderService settlementOrderService;
    @Autowired TradeOrderPORepository tradeOrderPORepository;
    @Autowired SettlementCarrierPORepository settlementCarrierPORepository;
    @Autowired ClearingOrderInnerPORepository clearingOrderInnerPORepository;
    @Autowired ClearingOrderOuterPORepository clearingOrderOuterPORepository;


    protected abstract List<ClearingOrderInnerPO> createClearOrderInner(SettlementCarrierPO settlementCarrierPO, TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums);

    protected abstract ClearingOrderOuterPO createClearOrderOuter(SettlementCarrierPO settlementCarrierPO, TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums);

    @Transactional(rollbackFor = Exception.class)
    public void settlement(SettlementOrderPO settlementOrderPO, TradeModeEnums tradeModeEnums){
        log.info("基础结算策略 settlement #参数{}, {}", settlementOrderPO, tradeModeEnums);
        TradeOrderPO tradeOrderPO = tradeOrderPORepository.findByTradeVoucherNo(settlementOrderPO.getPaymentSeqNo());

        SettlementCarrierPO innerSettlementCarrierPO = settlementOrderService.createSettlementCarrier(settlementOrderPO, PaymentTypeEnums.B, SettlementTypeEnums.I);
        List<ClearingOrderInnerPO> clearingOrderInnerPOList = createClearOrderInner(innerSettlementCarrierPO, tradeOrderPO, tradeModeEnums);
        clearingOrderInnerPORepository.save(clearingOrderInnerPOList);

        // NOTE: 内场清分结算
        boolean result = dpmAccountService.changeBalance(clearingOrderInnerPOList);
        if(result) innerSettlementCarrierPO.setStatus(SettlementStatusEnums.S.name());
        else innerSettlementCarrierPO.setStatus(SettlementStatusEnums.F.name());
        log.info("innerSettlementCarrierPO 数据{}" , innerSettlementCarrierPO);
        settlementCarrierPORepository.updateStatusById(innerSettlementCarrierPO.getId(), innerSettlementCarrierPO.getStatus());

        // NOTE: 外场清分结算
        SettlementCarrierPO outerSettlementCarrierPO = settlementOrderService.createSettlementCarrier(settlementOrderPO, PaymentTypeEnums.B, SettlementTypeEnums.O);
        ClearingOrderOuterPO clearingOrderOuterPO = createClearOrderOuter(outerSettlementCarrierPO, tradeOrderPO, tradeModeEnums);
        if(clearingOrderOuterPORepository.save(clearingOrderOuterPO) == null){
            throw CommonDefinedException.SYSTEM_ERROR("创建 外场清分失败, 数据{}" + clearingOrderInnerPOList);
        }

        result = dpmAccountService.changeBalance(clearingOrderOuterPO, tradeOrderPO.getTradeVoucherNo());
        if(result) outerSettlementCarrierPO.setStatus(SettlementStatusEnums.S.name());
        else outerSettlementCarrierPO.setStatus(SettlementStatusEnums.F.name());
        settlementCarrierPORepository.updateStatusById(outerSettlementCarrierPO.getId(), outerSettlementCarrierPO.getStatus());
    }

    public void buildInnerClearing(List<ClearingOrderInnerPO> clearingOrderInnerPOList, InnerClearingEntity innerClearingEntity) {
        BigDecimal amt = new BigDecimal("0.00000001");
        String paymentSeqNo = innerClearingEntity.getSettlementCarrierPO().getPaymentSeqNo();
        String clearingCode = "1";
        String sessionId = RandomUtil.randomUuid("CI");

        ClearAccount drClearAccount = innerClearingEntity.getDrClearAccount();
        ClearAccount crClearAccount = innerClearingEntity.getCrClearAccount();

        // NOTE 内场-借方
        ClearingOrderInnerPO drClearingOrderInnerPO = new ClearingOrderInnerPO();
        drClearingOrderInnerPO.setSessionId(sessionId);
        drClearingOrderInnerPO.setPaymentSeqNo(paymentSeqNo);
        drClearingOrderInnerPO.setClearingCode(clearingCode);
        drClearingOrderInnerPO.setPartyRole(PartyRoleEnums.PAYEE.getValue());
        drClearingOrderInnerPO.setPartyId(PartyIdEnums.INNER_MEMBER.getValue());
        drClearingOrderInnerPO.setAccountNo(drClearAccount.getAccountNo());
        drClearingOrderInnerPO.setAmt(amt);
        drClearingOrderInnerPO.setDrcr(DRCREnums.DR.name());
        drClearingOrderInnerPO.setCreateTime(now);
        drClearingOrderInnerPO.setUpdateTime(now);
        clearingOrderInnerPOList.add(drClearingOrderInnerPO);

        // NOTE 内场-贷方
        ClearingOrderInnerPO crClearingOrderInnerPO = new ClearingOrderInnerPO();
        crClearingOrderInnerPO.setSessionId(sessionId);
        crClearingOrderInnerPO.setPaymentSeqNo(paymentSeqNo);
        crClearingOrderInnerPO.setClearingCode(clearingCode);
        crClearingOrderInnerPO.setPartyRole(PartyRoleEnums.PAYER.getValue());
        crClearingOrderInnerPO.setPartyId(PartyIdEnums.INNER_MEMBER.getValue());
        crClearingOrderInnerPO.setAccountNo(crClearAccount.getAccountNo());
        crClearingOrderInnerPO.setAmt(amt);
        crClearingOrderInnerPO.setDrcr(DRCREnums.CR.name());
        crClearingOrderInnerPO.setCreateTime(now);
        crClearingOrderInnerPO.setUpdateTime(now);
        clearingOrderInnerPOList.add(crClearingOrderInnerPO);
    }

    public void buildOuterClearing(ClearingOrderOuterPO clearingOrderOuterPO, OuterClearingEntity outerClearingEntity) {
        BigDecimal amt = new BigDecimal("0.00000001");
        String sessionId = RandomUtil.randomUuid("CO");
        String clearingCode = "";

        clearingOrderOuterPO.setSessionId(sessionId);
        clearingOrderOuterPO.setAccountNo(outerClearingEntity.getClearAccount().getAccountNo());
        clearingOrderOuterPO.setPartyId(PartyIdEnums.OUTER_MEMBER.getValue());
        clearingOrderOuterPO.setPartyRole(outerClearingEntity.getPartyRoleEnums().getValue());
        clearingOrderOuterPO.setAmt(amt);
        clearingOrderOuterPO.setClearingCode(clearingCode);
        clearingOrderOuterPO.setCreateTime(now);
        clearingOrderOuterPO.setUpdateTime(now);
    }

}

package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.dal.mysql.repository.TradeOrderPORepository;
import com.dicero.diceroller.domain.enums.*;
import com.dicero.diceroller.domain.model.*;
import com.dicero.diceroller.service.bean.ClearAccount;
import com.dicero.diceroller.service.bean.InnerClearingEntity;
import com.dicero.diceroller.service.bean.OuterClearingEntity;
import com.dicero.diceroller.service.dpm.DpmAccountService;
import com.dicero.diceroller.service.settlement.AbstractSettlementStrategy;
import com.dicero.diceroller.service.settlement.ControlSettlementService;
import com.dicero.diceroller.service.settlement.SettlementOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
@Service
public abstract class ControlSettlementServiceImpl  extends AbstractSettlementStrategy implements ControlSettlementService {
    @Autowired DpmAccountService dpmAccountService;
    @Autowired SettlementOrderService settlementOrderService;
    @Autowired TradeOrderPORepository tradeOrderPORepository;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void settlement(SettlementOrderPO settlementOrderPO, TradeModeEnums tradeModeEnums){

        TradeOrderPO tradeOrderPO = tradeOrderPORepository.findByTradeVoucherNo(settlementOrderPO.getPaymentSeqNo());

        SettlementCarrierPO innerSettlementCarrierPO = settlementOrderService.createSettlementCarrier(settlementOrderPO, PaymentTypeEnums.B, SettlementTypeEnums.I);
        List<ClearingOrderInnerPO> clearingOrderInnerPOList = createClearOrderInner(innerSettlementCarrierPO, tradeOrderPO, tradeModeEnums);
        boolean result = dpmAccountService.changeBalance(clearingOrderInnerPOList);
        if(result) innerSettlementCarrierPO.setStatus(SettlementStatusEnums.S.name());
        else innerSettlementCarrierPO.setStatus(SettlementStatusEnums.F.name());


        SettlementCarrierPO outerSettlementCarrierPO = settlementOrderService.createSettlementCarrier(settlementOrderPO, PaymentTypeEnums.B, SettlementTypeEnums.O);
        ClearingOrderOuterPO clearingOrderOuterPO = createClearOrderOuter(outerSettlementCarrierPO, tradeOrderPO, tradeModeEnums);
        result = dpmAccountService.changeBalance(clearingOrderOuterPO);
        if(result) outerSettlementCarrierPO.setStatus(SettlementStatusEnums.S.name());
        else outerSettlementCarrierPO.setStatus(SettlementStatusEnums.F.name());
    }

    @Override
    public void buildInnerClearing(List<ClearingOrderInnerPO> clearingOrderInnerPOList, InnerClearingEntity innerClearingEntity) {
        BigDecimal amt = new BigDecimal("0.00000001");
        String paymentSeqNo = innerClearingEntity.getSettlementCarrierPO().getPaymentSeqNo();
        String clearingCode = "";
        String sessionId = "";

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

    @Override
    public void buildOuterClearing(ClearingOrderOuterPO clearingOrderOuterPO, OuterClearingEntity outerClearingEntity) {
        BigDecimal amt = new BigDecimal("0.00000001");
        String sessionId = "";
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

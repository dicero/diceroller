package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.common.bean.extension.CommonDefinedException;
import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.dal.mysql.repository.SettlementCarrierPORepository;
import com.dicero.diceroller.dal.mysql.repository.SettlementOrderPORepository;
import com.dicero.diceroller.domain.enums.PaymentTypeEnums;
import com.dicero.diceroller.domain.enums.SettlementStatusEnums;
import com.dicero.diceroller.domain.enums.SettlementTypeEnums;
import com.dicero.diceroller.domain.model.SettlementCarrierPO;
import com.dicero.diceroller.domain.model.SettlementOrderPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.settlement.SettlementOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
@Service
public class SettlementOrderServiceImpl extends BaseService implements SettlementOrderService {
    @Autowired SettlementCarrierPORepository settlementCarrierPORepository;
    @Autowired SettlementOrderPORepository settlementOrderPORepository;

    @Override
    public SettlementCarrierPO createSettlementCarrier(SettlementOrderPO settlementOrderPO, PaymentTypeEnums paymentTypeEnums, SettlementTypeEnums settlementTypeEnums) {
        SettlementCarrierPO settlementCarrierPO = new SettlementCarrierPO();
        settlementCarrierPO.setRequestNo(settlementOrderPO.getSessionId() + "-" + RandomUtil.randomSecond());
        settlementCarrierPO.setPaymentSeqNo(settlementOrderPO.getPaymentSeqNo());
        settlementCarrierPO.setPaymentType(paymentTypeEnums);
        settlementCarrierPO.setSettlementType(settlementTypeEnums);
        settlementCarrierPO.setStatus(SettlementStatusEnums.W);
        settlementCarrierPO.setSummary("" + settlementTypeEnums.getDesc());
        settlementCarrierPO.setCreateTime(now());
        settlementCarrierPO.setUpdateTime(now());
        settlementCarrierPO = settlementCarrierPORepository.save(settlementCarrierPO);
        if(settlementCarrierPO == null ) {
            throw CommonDefinedException.SYSTEM_ERROR("创建 清结算载体失败: "+ settlementCarrierPO);
        }
        return settlementCarrierPO;
    }

    @Override
    public SettlementOrderPO createSettlementOrder(TradeOrderPO tradeOrderPO) {
        SettlementOrderPO settlementOrderPO = new SettlementOrderPO();
        settlementOrderPO.setSessionId(RandomUtil.randomUuid("SId"));
        settlementOrderPO.setPaymentSeqNo(tradeOrderPO.getTradeVoucherNo());
        settlementOrderPO.setStatus(SettlementStatusEnums.W);
        settlementOrderPO.setCreateTime(now());
        settlementOrderPO.setUpdateTime(now());
        return settlementOrderPORepository.save(settlementOrderPO);
    }
}

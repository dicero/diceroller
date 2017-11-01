package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.domain.enums.*;
import com.dicero.diceroller.domain.model.SettlementCarrierPO;
import com.dicero.diceroller.domain.model.SettlementOrderPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.settlement.SettlementOrderService;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
@Service
public class SettlementOrderServiceImpl extends BaseService implements SettlementOrderService {

    @Override
    public SettlementCarrierPO createSettlementCarrier(SettlementOrderPO settlementOrderPO, PaymentTypeEnums paymentTypeEnums, SettlementTypeEnums settlementTypeEnums) {
        SettlementCarrierPO settlementCarrierPO = new SettlementCarrierPO();
        settlementCarrierPO.setRequestNo(settlementOrderPO.getSessionId() + "-" + RandomUtil.randomSecond());
        settlementCarrierPO.setPaymentSeqNo(settlementOrderPO.getPaymentSeqNo());
        settlementCarrierPO.setPaymentType(paymentTypeEnums.name());
        settlementCarrierPO.setSettlementType(SettlementTypeEnums.I.name());
        settlementCarrierPO.setStatus(SettlementStatusEnums.W.name());
        settlementCarrierPO.setSummary("");
        settlementCarrierPO.setCreateTime(now);
        settlementCarrierPO.setUpdateTime(now);
        return settlementCarrierPO;
    }

    @Override
    public void createSettlementOrder(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        SettlementOrderPO settlementOrderPO = new SettlementOrderPO();
        settlementOrderPO.setSessionId("");
        settlementOrderPO.setPaymentSeqNo("");
        settlementOrderPO.setClearingCode("");
        settlementOrderPO.setStatus("");
        settlementOrderPO.setCreateTime(now);
        settlementOrderPO.setUpdateTime(now);

    }
}

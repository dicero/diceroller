package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.domain.enums.DRCREnums;
import com.dicero.diceroller.domain.enums.PaymentTypeEnums;
import com.dicero.diceroller.domain.enums.SettlementStatusEnums;
import com.dicero.diceroller.domain.enums.TradeModeEnums;
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
    public void createSettlementCarrier(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        SettlementCarrierPO settlementCarrierPO = new SettlementCarrierPO();
        settlementCarrierPO.setRequestNo(RandomUtil.randomUuid("SO"));
        settlementCarrierPO.setPaymentSeqNo(tradeOrderPO.getTradeVoucherNo());
        settlementCarrierPO.setPaymentType(PaymentTypeEnums.I.name());
        settlementCarrierPO.setSettlementType("");
        settlementCarrierPO.setStatus(SettlementStatusEnums.W.name());
        settlementCarrierPO.setSummary("");
        settlementCarrierPO.setCreateTime(now);
        settlementCarrierPO.setUpdateTime(now);

    }

    @Override
    public void createSettlementOrder(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        SettlementOrderPO settlementOrderPO = new SettlementOrderPO();
        settlementOrderPO.setSessionId("");
        settlementOrderPO.setPaymentSeqNo("");
        settlementOrderPO.setPartyId("");
        settlementOrderPO.setPartyRole("");
        settlementOrderPO.setAccountNo("");
        settlementOrderPO.setAmount(null);
        settlementOrderPO.setDrcr(DRCREnums.CR.name());
        settlementOrderPO.setClearingCode("");
        settlementOrderPO.setCreateTime(now);
        settlementOrderPO.setUpdateTime(now);

    }
}

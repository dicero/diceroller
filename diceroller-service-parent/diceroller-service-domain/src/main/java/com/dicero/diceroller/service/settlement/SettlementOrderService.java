package com.dicero.diceroller.service.settlement;

import com.dicero.diceroller.domain.enums.PaymentTypeEnums;
import com.dicero.diceroller.domain.enums.SettlementTypeEnums;
import com.dicero.diceroller.domain.model.SettlementCarrierPO;
import com.dicero.diceroller.domain.model.SettlementOrderPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public interface SettlementOrderService {

    SettlementCarrierPO createSettlementCarrier(SettlementOrderPO settlementOrderPO, PaymentTypeEnums paymentTypeEnums , SettlementTypeEnums settlementTypeEnums);

    SettlementOrderPO createSettlementOrder(TradeOrderPO tradeOrderPO);
}

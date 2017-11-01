package com.dicero.diceroller.service.settlement;

import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.TradeOrderPO;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public interface SettlementOrderService {

    void createSettlementCarrier(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums);
    void createSettlementOrder(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums);
}

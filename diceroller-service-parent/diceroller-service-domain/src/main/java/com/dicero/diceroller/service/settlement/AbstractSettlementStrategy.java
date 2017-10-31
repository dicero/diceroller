package com.dicero.diceroller.service.settlement;

import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.TradeOrderPO;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public interface AbstractSettlementStrategy {
    void createClearOrderInner(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums);

    void createClearOrderOuter(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums);
}

package com.dicero.diceroller.service.settlement;

import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.*;
import com.dicero.diceroller.service.BaseService;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public abstract  class AbstractSettlementStrategy extends BaseService {
    public void settlement(SettlementOrderPO settlementOrderPO, TradeModeEnums tradeModeEnums){ }
    public abstract List<ClearingOrderInnerPO> createClearOrderInner(SettlementCarrierPO settlementCarrierPO, TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums);

    public abstract ClearingOrderOuterPO createClearOrderOuter(SettlementCarrierPO settlementCarrierPO, TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums);

}

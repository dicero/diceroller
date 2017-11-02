package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import com.dicero.diceroller.domain.model.ClearingOrderOuterPO;
import com.dicero.diceroller.domain.model.SettlementCarrierPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.service.settlement.AbstractSettlementStrategy;
import com.dicero.diceroller.service.settlement.InterfaceSettlementService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/2
 */
@Service("rechargeSettlementStrategy")
public class RechargeSettlementStrategy extends AbstractSettlementStrategy implements InterfaceSettlementService {

    @Override
    protected List<ClearingOrderInnerPO> createClearOrderInner(SettlementCarrierPO settlementCarrierPO, TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        return null;
    }

    @Override
    protected ClearingOrderOuterPO createClearOrderOuter(SettlementCarrierPO settlementCarrierPO, TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        return null;
    }
}

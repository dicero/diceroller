package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.domain.enums.InnerAccountEnums;
import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.service.bean.ClearAccount;
import com.dicero.diceroller.service.settlement.AbstractSettlementStrategy;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
@Service
public class PaymentSettlementStrategy extends ControlSettlementServiceImpl implements AbstractSettlementStrategy {

    @Override
    public void createClearOrderInner(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SUCCESS)) {
            super.buildInnerClearing(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT), new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_TRADE_BIT));
        }
    }

    @Override
    public void createClearOrderOuter(TradeOrderPO tradeOrderPO,  TradeModeEnums tradeModeEnums) {
        if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SUCCESS)) {
            super.buildOuterClearing(new ClearAccount(tradeOrderPO.getBuyerAccountNo()));
        }
    }
}

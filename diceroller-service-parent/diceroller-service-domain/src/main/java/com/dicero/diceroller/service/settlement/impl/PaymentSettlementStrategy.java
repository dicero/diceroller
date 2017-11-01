package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.domain.enums.InnerAccountEnums;
import com.dicero.diceroller.domain.enums.PartyRoleEnums;
import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import com.dicero.diceroller.domain.model.ClearingOrderOuterPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.service.bean.ClearAccount;
import com.dicero.diceroller.service.dpm.DpmAccountService;
import com.dicero.diceroller.service.settlement.AbstractSettlementStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
@Service
public class PaymentSettlementStrategy extends ControlSettlementServiceImpl implements AbstractSettlementStrategy {

    @Autowired DpmAccountService dpmAccountService;

    @Override
    public void createClearOrderInner(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        List<ClearingOrderInnerPO> clearingOrderInnerPOList = new ArrayList<>();

        if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SUCCESS)) {
            super.buildInnerClearing(clearingOrderInnerPOList, new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT), new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_TRADE_BIT));

        }

        else if(tradeModeEnums.equals(TradeModeEnums.PAYMENT_SETTLEMENT)){
            super.buildInnerClearing(clearingOrderInnerPOList, new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_TRADE_BIT), new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT));

        }

        dpmAccountService.changeBalance(clearingOrderInnerPOList);
    }

    @Override
    public void createClearOrderOuter(TradeOrderPO tradeOrderPO,  TradeModeEnums tradeModeEnums) {
        ClearingOrderOuterPO clearingOrderOuterPO = new ClearingOrderOuterPO();

        if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SUCCESS)) {
            super.buildOuterClearing(clearingOrderOuterPO, new ClearAccount(tradeOrderPO.getBuyerAccountNo()), PartyRoleEnums.PAYEE);
        }

        else if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SETTLEMENT)) {
            super.buildOuterClearing(clearingOrderOuterPO, new ClearAccount(tradeOrderPO.getSellerAccountNo()), PartyRoleEnums.PAYER);
        }

        dpmAccountService.changeBalance(clearingOrderOuterPO);
    }
}

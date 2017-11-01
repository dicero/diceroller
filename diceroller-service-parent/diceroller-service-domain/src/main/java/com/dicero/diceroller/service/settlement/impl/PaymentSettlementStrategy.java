package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.domain.enums.InnerAccountEnums;
import com.dicero.diceroller.domain.enums.PartyRoleEnums;
import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import com.dicero.diceroller.domain.model.ClearingOrderOuterPO;
import com.dicero.diceroller.domain.model.SettlementCarrierPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.service.bean.ClearAccount;
import com.dicero.diceroller.service.bean.InnerClearingEntity;
import com.dicero.diceroller.service.bean.OuterClearingEntity;
import com.dicero.diceroller.service.settlement.AbstractSettlementService;
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
public class PaymentSettlementStrategy extends ControlSettlementServiceImpl implements AbstractSettlementService {

    @Override
    public List<ClearingOrderInnerPO> createClearOrderInner(SettlementCarrierPO settlementCarrierPO,  TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        List<ClearingOrderInnerPO> clearingOrderInnerPOList = new ArrayList<>();

        if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SUCCESS)) {
            InnerClearingEntity innerClearingEntity = new InnerClearingEntity();
            innerClearingEntity.setDrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT));
            innerClearingEntity.setCrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_TRADE_BIT));
            innerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildInnerClearing(clearingOrderInnerPOList, innerClearingEntity);

        }

        else if(tradeModeEnums.equals(TradeModeEnums.PAYMENT_SETTLEMENT)){
            InnerClearingEntity innerClearingEntity = new InnerClearingEntity();
            innerClearingEntity.setDrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_TRADE_BIT));
            innerClearingEntity.setCrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT));
            innerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildInnerClearing(clearingOrderInnerPOList, innerClearingEntity);

        }

        return clearingOrderInnerPOList;
    }

    @Override
    public ClearingOrderOuterPO createClearOrderOuter(SettlementCarrierPO settlementCarrierPO,  TradeOrderPO tradeOrderPO,  TradeModeEnums tradeModeEnums) {
        ClearingOrderOuterPO clearingOrderOuterPO = new ClearingOrderOuterPO();

        if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SUCCESS)) {
            OuterClearingEntity outerClearingEntity = new OuterClearingEntity();
            outerClearingEntity.setClearAccount(new ClearAccount(tradeOrderPO.getBuyerAccountNo()));
            outerClearingEntity.setPartyRoleEnums(PartyRoleEnums.PAYEE);
            outerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildOuterClearing(clearingOrderOuterPO,  outerClearingEntity);
        }

        else if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SETTLEMENT)) {
            OuterClearingEntity outerClearingEntity = new OuterClearingEntity();
            outerClearingEntity.setClearAccount(new ClearAccount(tradeOrderPO.getSellerAccountNo()));
            outerClearingEntity.setPartyRoleEnums(PartyRoleEnums.PAYER);
            outerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildOuterClearing(clearingOrderOuterPO, outerClearingEntity);
        }

        return clearingOrderOuterPO;
    }
}

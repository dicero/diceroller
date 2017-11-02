package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.common.bean.extension.CommonDefinedException;
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
import com.dicero.diceroller.service.settlement.AbstractSettlementStrategy;
import com.dicero.diceroller.service.settlement.InterfaceSettlementService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
@Service("paymentSettlementStrategy")
public class PaymentSettlementStrategy extends AbstractSettlementStrategy implements InterfaceSettlementService {

    @Override
    public List<ClearingOrderInnerPO> createClearOrderInner(SettlementCarrierPO settlementCarrierPO,  TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        List<ClearingOrderInnerPO> clearingOrderInnerPOList = new ArrayList<>();

        // NOTE: 支付成功
        if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SUCCESS)) {
            InnerClearingEntity innerClearingEntity = new InnerClearingEntity();
            innerClearingEntity.setDrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT));
            innerClearingEntity.setCrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_TRADE_BIT));
            innerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildInnerClearing(clearingOrderInnerPOList, innerClearingEntity);

        }

        // NOTE: 支付结算 + 支付撤销 + 支付失败
        else if(tradeModeEnums.equals(TradeModeEnums.PAYMENT_SETTLEMENT)
                || tradeModeEnums.equals(TradeModeEnums.PAYMENT_CANCEL)
                || tradeModeEnums.equals(TradeModeEnums.PAYMENT_FAIL)){
            InnerClearingEntity innerClearingEntity = new InnerClearingEntity();
            innerClearingEntity.setDrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_TRADE_BIT));
            innerClearingEntity.setCrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT));
            innerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildInnerClearing(clearingOrderInnerPOList, innerClearingEntity);

        }

        else {
            throw CommonDefinedException.SYSTEM_ERROR("支付-错误的指令" + tradeModeEnums);
        }

        return clearingOrderInnerPOList;
    }

    @Override
    public ClearingOrderOuterPO createClearOrderOuter(SettlementCarrierPO settlementCarrierPO,  TradeOrderPO tradeOrderPO,  TradeModeEnums tradeModeEnums) {
        ClearingOrderOuterPO clearingOrderOuterPO = new ClearingOrderOuterPO();

        // NOTE: 支付成功
        if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SUCCESS)) {
            OuterClearingEntity outerClearingEntity = new OuterClearingEntity();
            outerClearingEntity.setClearAccount(new ClearAccount(tradeOrderPO.getBuyerAccountNo()));
            outerClearingEntity.setPartyRoleEnums(PartyRoleEnums.PAYEE);
            outerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildOuterClearing(clearingOrderOuterPO,  outerClearingEntity);
        }

        // NOTE: 支付结算 + 支付撤销
        else if(tradeModeEnums.equals(TradeModeEnums.PAYMENT_SETTLEMENT)
                || tradeModeEnums.equals(TradeModeEnums.PAYMENT_CANCEL)
                || tradeModeEnums.equals(TradeModeEnums.PAYMENT_FAIL)){
            OuterClearingEntity outerClearingEntity = new OuterClearingEntity();
            outerClearingEntity.setClearAccount(new ClearAccount(tradeOrderPO.getSellerAccountNo()));
            outerClearingEntity.setPartyRoleEnums(PartyRoleEnums.PAYER);
            outerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildOuterClearing(clearingOrderOuterPO, outerClearingEntity);
        }

        else {
            throw CommonDefinedException.SYSTEM_ERROR("支付-错误的指令" + tradeModeEnums);
        }


        return clearingOrderOuterPO;
    }
}

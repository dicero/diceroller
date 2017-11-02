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
 * @version 2017/11/3
 */
@Service("withdrawSettlementStrategy")
public class WithdrawSettlementStrategy extends AbstractSettlementStrategy implements InterfaceSettlementService {
    @Override
    protected List<ClearingOrderInnerPO> createClearOrderInner(SettlementCarrierPO settlementCarrierPO, TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        List<ClearingOrderInnerPO> clearingOrderInnerPOList = new ArrayList<>();

        // NOTE: 出款申请
        if (tradeModeEnums.equals(TradeModeEnums.FUND_OUT_APPLY)) {
            InnerClearingEntity innerClearingEntity = new InnerClearingEntity();
            innerClearingEntity.setDrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT));
            innerClearingEntity.setCrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_OUT_BIT));
            innerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildInnerClearing(clearingOrderInnerPOList, innerClearingEntity);

        }

        // NOTE:  出款驳回
        else if(tradeModeEnums.equals(TradeModeEnums.FUND_OUT_REFUSE)){
            InnerClearingEntity innerClearingEntity = new InnerClearingEntity();
            innerClearingEntity.setDrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_OUT_BIT));
            innerClearingEntity.setCrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT));
            innerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildInnerClearing(clearingOrderInnerPOList, innerClearingEntity);

        }

        // NOTE:  出款成功
        else if(tradeModeEnums.equals(TradeModeEnums.FUND_OUT_SUCCESS)){
            InnerClearingEntity innerClearingEntity = new InnerClearingEntity();
            innerClearingEntity.setDrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_OUT_BIT));
            innerClearingEntity.setCrClearAccount(new ClearAccount(InnerAccountEnums.CLEARING_FUND_OUT_BIT));
            innerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildInnerClearing(clearingOrderInnerPOList, innerClearingEntity);

        }

        // NOTE:  出款失败
        else if(tradeModeEnums.equals(TradeModeEnums.FUND_OUT_FAIL)){
            InnerClearingEntity innerClearingEntity = new InnerClearingEntity();
            innerClearingEntity.setDrClearAccount(new ClearAccount(InnerAccountEnums.CLEARING_FUND_OUT_BIT));
            innerClearingEntity.setCrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT));
            innerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildInnerClearing(clearingOrderInnerPOList, innerClearingEntity);

        }

        // NOTE:  出款结转
        else if(tradeModeEnums.equals(TradeModeEnums.FUND_OUT_CLEAR)){
            InnerClearingEntity innerClearingEntity = new InnerClearingEntity();
            innerClearingEntity.setDrClearAccount(new ClearAccount(InnerAccountEnums.CLEARING_FUND_OUT_BIT));
            innerClearingEntity.setCrClearAccount(new ClearAccount(InnerAccountEnums.BANK_BIT));
            innerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildInnerClearing(clearingOrderInnerPOList, innerClearingEntity);

        }

        else {
            throw CommonDefinedException.SYSTEM_ERROR("出款-错误的指令" + tradeModeEnums);
        }

        return clearingOrderInnerPOList;
    }

    @Override
    protected ClearingOrderOuterPO createClearOrderOuter(SettlementCarrierPO settlementCarrierPO, TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        ClearingOrderOuterPO clearingOrderOuterPO = new ClearingOrderOuterPO();

        // NOTE: 出款申请
        if (tradeModeEnums.equals(TradeModeEnums.FUND_OUT_APPLY)) {
            OuterClearingEntity outerClearingEntity = new OuterClearingEntity();
            outerClearingEntity.setClearAccount(new ClearAccount(tradeOrderPO.getBuyerAccountNo()));
            outerClearingEntity.setPartyRoleEnums(PartyRoleEnums.PAYEE);
            outerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildOuterClearing(clearingOrderOuterPO,  outerClearingEntity);
        }

        // NOTE: 出款驳回 + 出款失败
        else if(tradeModeEnums.equals(TradeModeEnums.FUND_OUT_REFUSE)
                || tradeModeEnums.equals(TradeModeEnums.FUND_OUT_FAIL)){
            OuterClearingEntity outerClearingEntity = new OuterClearingEntity();
            outerClearingEntity.setClearAccount(new ClearAccount(tradeOrderPO.getBuyerAccountNo()));
            outerClearingEntity.setPartyRoleEnums(PartyRoleEnums.PAYER);
            outerClearingEntity.setSettlementCarrierPO(settlementCarrierPO);
            super.buildOuterClearing(clearingOrderOuterPO, outerClearingEntity);
        }

        // NOTE: 出款成功 + 出款结转, 外场不做清分
        else if(tradeModeEnums.equals(TradeModeEnums.FUND_OUT_SUCCESS)
                || tradeModeEnums.equals(TradeModeEnums.FUND_OUT_CLEAR)){
            return null;
        }

        else {
            throw CommonDefinedException.SYSTEM_ERROR("出款-错误的指令" + tradeModeEnums);
        }


        return clearingOrderOuterPO;
    }
}

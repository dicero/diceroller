package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.common.bean.extension.CommonDefinedException;
import com.dicero.diceroller.domain.enums.InnerAccountEnums;
import com.dicero.diceroller.domain.enums.PartyRoleEnums;
import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import com.dicero.diceroller.domain.model.ClearingOrderOuterPO;
import com.dicero.diceroller.domain.model.SettlementOrderPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.service.bean.ClearAccount;
import com.dicero.diceroller.service.bean.InnerClearingEntity;
import com.dicero.diceroller.service.bean.OuterClearingEntity;
import com.dicero.diceroller.service.callback.WithdrawSettlementStatusCallback;
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
    public void settlement(SettlementOrderPO settlementOrderPO, TradeModeEnums tradeModeEnums) {
        super.settlement(settlementOrderPO, tradeModeEnums, new WithdrawSettlementStatusCallback());
    }


    @Override
    protected List<ClearingOrderInnerPO> createClearOrderInner(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        List<ClearingOrderInnerPO> clearingOrderInnerPOList = new ArrayList<>();

        // NOTE: 出款申请
        if (tradeModeEnums.equals(TradeModeEnums.FUND_OUT_APPLY)) {
            super.buildInnerClearing(
                    clearingOrderInnerPOList,
                    new InnerClearingEntity()
                            .buildDrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT))
                            .buildCrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_OUT_BIT))
                            .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                            .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);
        }

        // NOTE:  出款驳回
        else if(tradeModeEnums.equals(TradeModeEnums.FUND_OUT_REFUSE)){
            super.buildInnerClearing(
                    clearingOrderInnerPOList,
                    new InnerClearingEntity()
                            .buildDrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_OUT_BIT))
                            .buildCrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT))
                            .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                            .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);

        }

        // NOTE:  出款成功
        else if(tradeModeEnums.equals(TradeModeEnums.FUND_OUT_SUCCESS)){
            super.buildInnerClearing(
                    clearingOrderInnerPOList,
                    new InnerClearingEntity()
                            .buildDrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_OUT_BIT))
                            .buildCrClearAccount(new ClearAccount(InnerAccountEnums.CLEARING_FUND_OUT_BIT))
                            .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                            .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);

        }

        // NOTE:  出款失败
        else if(tradeModeEnums.equals(TradeModeEnums.FUND_OUT_FAIL)){
            super.buildInnerClearing(
                    clearingOrderInnerPOList,
                    new InnerClearingEntity()
                            .buildDrClearAccount(new ClearAccount(InnerAccountEnums.CLEARING_FUND_OUT_BIT))
                            .buildCrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT))
                            .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                            .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);
        }

        // NOTE:  出款结转
        else if(tradeModeEnums.equals(TradeModeEnums.FUND_OUT_CLEAR)){
            super.buildInnerClearing(
                    clearingOrderInnerPOList,
                    new InnerClearingEntity()
                            .buildDrClearAccount(new ClearAccount(InnerAccountEnums.CLEARING_FUND_OUT_BIT))
                            .buildCrClearAccount(new ClearAccount(InnerAccountEnums.BANK_BIT))
                            .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                            .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);
        }

        else {
            throw CommonDefinedException.SYSTEM_ERROR("出款-错误的指令" + tradeModeEnums);
        }

        return clearingOrderInnerPOList;
    }

    @Override
    protected ClearingOrderOuterPO createClearOrderOuter(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        ClearingOrderOuterPO clearingOrderOuterPO = new ClearingOrderOuterPO();

        // NOTE: 出款申请t
        if (tradeModeEnums.equals(TradeModeEnums.FUND_OUT_APPLY)) {
            super.buildOuterClearing(
                    clearingOrderOuterPO,
                    new OuterClearingEntity()
                            .buildClearAccount(new ClearAccount(tradeOrderPO.getBuyerAccountNo()))
                            .buildPartyRoleEnums(PartyRoleEnums.PAYEE)
                            .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                            .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);
        }

        // NOTE: 出款驳回 + 出款失败
        else if(tradeModeEnums.equals(TradeModeEnums.FUND_OUT_REFUSE)
                || tradeModeEnums.equals(TradeModeEnums.FUND_OUT_FAIL)){
            super.buildOuterClearing(
                    clearingOrderOuterPO,
                    new OuterClearingEntity()
                            .buildClearAccount(new ClearAccount(tradeOrderPO.getBuyerAccountNo()))
                            .buildPartyRoleEnums(PartyRoleEnums.PAYER)
                            .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                            .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);
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

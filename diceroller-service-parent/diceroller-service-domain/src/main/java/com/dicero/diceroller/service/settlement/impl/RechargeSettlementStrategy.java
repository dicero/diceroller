package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.common.bean.extension.CommonDefinedException;
import com.dicero.diceroller.domain.enums.InnerAccountEnums;
import com.dicero.diceroller.domain.enums.PartyRoleEnums;
import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import com.dicero.diceroller.domain.model.ClearingOrderOuterPO;
import com.dicero.diceroller.domain.model.TradeOrderPO;
import com.dicero.diceroller.service.bean.ClearAccount;
import com.dicero.diceroller.service.bean.InnerClearingEntity;
import com.dicero.diceroller.service.bean.OuterClearingEntity;
import com.dicero.diceroller.service.settlement.AbstractSettlementStrategy;
import com.dicero.diceroller.service.settlement.InterfaceSettlementService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/2
 */
@Slf4j
@Service("rechargeSettlementStrategy")
public class RechargeSettlementStrategy extends AbstractSettlementStrategy implements InterfaceSettlementService {

    @Override
    protected List<ClearingOrderInnerPO> createClearOrderInner(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        log.info("执行内部清分指令[{}],数据{}",tradeModeEnums.name(), tradeOrderPO.getTradeSrcVoucherNo());
        List<ClearingOrderInnerPO> clearingOrderInnerPOList = new ArrayList<>();

        // NOTE: 入款成功
        if (tradeModeEnums.equals(TradeModeEnums.FUND_IN_SUCCESS)) {
            super.buildInnerClearing(
                    clearingOrderInnerPOList,
                    new InnerClearingEntity()
                            .buildDrClearAccount(new ClearAccount(InnerAccountEnums.CLEARING_FUND_IN_BIT))
                            .buildCrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_IN_BIT))
                            .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                            .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);

        }

        // NOTE: 入款结算
        else if (tradeModeEnums.equals(TradeModeEnums.FUND_IN_SETTLEMENT)) {
            super.buildInnerClearing(
                    clearingOrderInnerPOList,
                    new InnerClearingEntity()
                            .buildDrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_IN_BIT))
                            .buildCrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT))
                            .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                            .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);
        }

        // NOTE: 入款撤销
        else if (tradeModeEnums.equals(TradeModeEnums.FUND_IN_CANCEL)) {
            super.buildInnerClearing(
                    clearingOrderInnerPOList,
                    new InnerClearingEntity()
                            .buildDrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_IN_BIT))
                            .buildCrClearAccount(new ClearAccount(InnerAccountEnums.CLEARING_FUND_IN_BIT))
                            .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                            .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);
        }

        // NOTE: 入款结转
        else if (tradeModeEnums.equals(TradeModeEnums.FUND_IN_CLEAR)) {
            super.buildInnerClearing(
                    clearingOrderInnerPOList,
                    new InnerClearingEntity()
                            .buildDrClearAccount(new ClearAccount(InnerAccountEnums.BANK_BIT))
                            .buildCrClearAccount(new ClearAccount(InnerAccountEnums.CLEARING_FUND_IN_BIT))
                            .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                            .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);
        }

        else {
            throw CommonDefinedException.SYSTEM_ERROR("支付-错误的指令" + tradeModeEnums);
        }

        return clearingOrderInnerPOList;

    }

    @Override
    protected ClearingOrderOuterPO createClearOrderOuter(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        log.info("执行外部清分指令[{}],数据{}",tradeModeEnums.name(), tradeOrderPO.getTradeSrcVoucherNo());
        ClearingOrderOuterPO clearingOrderOuterPO = new ClearingOrderOuterPO();

        // NOTE: 入款成功
        if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SETTLEMENT)) {
            super.buildOuterClearing(
                    clearingOrderOuterPO,
                    new OuterClearingEntity()
                            .buildClearAccount(new ClearAccount(tradeOrderPO.getBuyerAccountNo()))
                            .buildPartyRoleEnums(PartyRoleEnums.PAYER)
                            .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                            .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);
        } else if (tradeModeEnums.equals(TradeModeEnums.FUND_IN_SUCCESS)
                || tradeModeEnums.equals(TradeModeEnums.FUND_IN_CANCEL)
                || tradeModeEnums.equals(TradeModeEnums.FUND_IN_CLEAR)) {
            return null;
        }

        else {
            throw CommonDefinedException.SYSTEM_ERROR("支付-错误的指令" + tradeModeEnums);
        }

        return clearingOrderOuterPO;

    }
}

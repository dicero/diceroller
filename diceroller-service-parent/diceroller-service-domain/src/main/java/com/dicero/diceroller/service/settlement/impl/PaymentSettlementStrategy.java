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
 * @version 2017/10/31
 */
@Slf4j
@Service("paymentSettlementStrategy")
public class PaymentSettlementStrategy extends AbstractSettlementStrategy implements InterfaceSettlementService {

    @Override
    public List<ClearingOrderInnerPO> createClearOrderInner(TradeOrderPO tradeOrderPO, TradeModeEnums tradeModeEnums) {
        log.info("执行内部清分指令[{}],数据{}",tradeModeEnums.name(), tradeOrderPO.getTradeSrcVoucherNo());
        List<ClearingOrderInnerPO> clearingOrderInnerPOList = new ArrayList<>();

        // NOTE: 支付成功
        if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SUCCESS)) {
            super.buildInnerClearing(
                    clearingOrderInnerPOList,
                    new InnerClearingEntity()
                        .buildDrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT))
                        .buildCrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_TRADE_BIT))
                        .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                        .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);

        }

        // NOTE: 支付结算 + 支付撤销 + 支付失败
        else if(tradeModeEnums.equals(TradeModeEnums.PAYMENT_SETTLEMENT)
                || tradeModeEnums.equals(TradeModeEnums.PAYMENT_CANCEL)
                || tradeModeEnums.equals(TradeModeEnums.PAYMENT_FAIL)){
            super.buildInnerClearing(
                    clearingOrderInnerPOList,
                    new InnerClearingEntity()
                        .buildDrClearAccount(new ClearAccount(InnerAccountEnums.SETTLEMENT_FUND_TRADE_BIT))
                        .buildCrClearAccount(new ClearAccount(InnerAccountEnums.PERSONAL_FUND_BIT))
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
    public ClearingOrderOuterPO createClearOrderOuter( TradeOrderPO tradeOrderPO,  TradeModeEnums tradeModeEnums) {
        log.info("执行外部清分指令[{}],数据{}",tradeModeEnums.name(), tradeOrderPO.getTradeSrcVoucherNo());
        ClearingOrderOuterPO clearingOrderOuterPO = new ClearingOrderOuterPO();

        // NOTE: 支付成功
        if (tradeModeEnums.equals(TradeModeEnums.PAYMENT_SUCCESS)) {
            super.buildOuterClearing(
                    clearingOrderOuterPO,
                    new OuterClearingEntity()
                        .buildClearAccount(new ClearAccount(tradeOrderPO.getBuyerAccountNo()))
                        .buildPartyRoleEnums(PartyRoleEnums.PAYEE)
                        .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                        .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);
        }

        // NOTE: 支付结算 + 支付撤销
        else if(tradeModeEnums.equals(TradeModeEnums.PAYMENT_SETTLEMENT)
                || tradeModeEnums.equals(TradeModeEnums.PAYMENT_CANCEL)
                || tradeModeEnums.equals(TradeModeEnums.PAYMENT_FAIL)){
            super.buildOuterClearing(
                    clearingOrderOuterPO,
                    new OuterClearingEntity()
                        .buildClearAccount(new ClearAccount(tradeOrderPO.getSellerAccountNo()))
                        .buildPartyRoleEnums(PartyRoleEnums.PAYER)
                        .buildPaymentSeqNo(tradeOrderPO.getTradeVoucherNo())
                        .buildAmt(tradeOrderPO.getTradeAmount()),
                    tradeModeEnums);
        }

        else {
            throw CommonDefinedException.SYSTEM_ERROR("支付-错误的指令" + tradeModeEnums);
        }


        return clearingOrderOuterPO;
    }
}

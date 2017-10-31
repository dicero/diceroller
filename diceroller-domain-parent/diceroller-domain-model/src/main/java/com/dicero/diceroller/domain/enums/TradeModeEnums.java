package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public enum TradeModeEnums {

    // NOTE: 支付成功
    PAYMENT_SUCCESS(),
    // NOTE: 支付结算
    PAYMENT_SETTLEMENT(),
    // NOTE: 支付撤销
    PAYMENT_CANCEL(),
    // NOTE: 支付失败
    PAYMENT_FAIL(),
    // NOTE: 入款成功
    FUND_IN_SUCCESS(),
    // NOTE: 入款结算
    FUND_IN_SETTLEMENT(),
    // NOTE: 入款撤销
    FUND_IN_CANCEL(),
    // NOTE: 入款结转
    FUND_IN_CLEAR(),
    // NOTE: 出款申请
    FUND_OUT_APPLY(),
    // NOTE: 出款驳回
    FUND_OUT_REFUSE(),
    // NOTE: 出款成功
    FUND_OUT_SUCCESS(),
    // NOTE: 出款失败
    FUND_OUT_FAIL(),
    // NOTE: 出款结转
    FUND_OUT_CLEAR();
}

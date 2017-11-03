package com.dicero.diceroller.domain.enums;

import com.dicero.diceroller.common.bean.extension.CommonDefinedException;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public enum TradeModeEnums {

    // NOTE: 支付成功
    PAYMENT_SUCCESS("1001"),
    // NOTE: 支付结算
    PAYMENT_SETTLEMENT("1002"),
    // NOTE: 支付撤销
    PAYMENT_CANCEL("1003"),
    // NOTE: 支付失败
    PAYMENT_FAIL("1004"),
    // NOTE: 入款成功
    FUND_IN_SUCCESS("2001"),
    // NOTE: 入款结算
    FUND_IN_SETTLEMENT("2002"),
    // NOTE: 入款撤销
    FUND_IN_CANCEL("2003"),
    // NOTE: 入款结转
    FUND_IN_CLEAR("2004"),
    // NOTE: 出款申请
    FUND_OUT_APPLY("3001"),
    // NOTE: 出款驳回
    FUND_OUT_REFUSE("3002"),
    // NOTE: 出款成功
    FUND_OUT_SUCCESS("3003"),
    // NOTE: 出款失败
    FUND_OUT_FAIL("3004"),
    // NOTE: 出款结转
    FUND_OUT_CLEAR("3005");

    private String clearingCode;

    TradeModeEnums(String clearingCode) {
        this.clearingCode = clearingCode;
    }

    public String getClearingCode() {
        return clearingCode;
    }

    public String getServiceName(){
        if( getClearingCode().startsWith("1") ){
            return "paymentSettlementStrategy";
        } else if(getClearingCode().startsWith("2")){
            return "rechargeSettlementStrategy";
        } else if(getClearingCode().startsWith("3")){
            return "withdrawSettlementStrategy";
        }

        throw CommonDefinedException.SYSTEM_NO_SUCH_SERVICE("");
    }
}

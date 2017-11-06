package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 * I-入款,O-出款,T-转账,R-退款到卡,F-退票,B-退款到账户
 * @author znz
 * @version 2017/10/31
 */
public enum PaymentTypeEnums {
    // NOTE: I-入款
    I("入款"),
    // NOTE: O-出款
    O("出款"),
    // NOTE: T-转账
    T("转账"),
    // NOTE: R-退款到卡
    R("退款到卡"),
    // NOTE: F-退票
    F("退票"),
    // NOTE: B-退款到账户
    B("退款到账户");

    private String desc;

    PaymentTypeEnums(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

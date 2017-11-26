package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/26
 */
public enum  TradeTypeEnums {
    R("充值"),

    W("提现"),

    FI("收入"),

    FO("支出");

    private String desc;

    TradeTypeEnums(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}

package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public enum TradeStatusEnums {

    // NOTE: 初始化
    INIT("init"),

    // NOTE: 成功
    SUCCESS("success"),

    // NOTE: 失败
    FAIL("fail");

    private String value;

    TradeStatusEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

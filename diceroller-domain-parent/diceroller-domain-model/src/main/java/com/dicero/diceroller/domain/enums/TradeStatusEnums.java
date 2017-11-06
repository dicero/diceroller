package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public enum TradeStatusEnums {

    // NOTE: 初始化
    INIT("init", "初始化"),

    // NOTE: 成功
    SUCCESS("success", "成功"),

    // NOTE: 失败
    FAIL("fail", "失败");

    private String value;
    private String desc;

    TradeStatusEnums(String value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

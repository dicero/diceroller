package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/26
 */
public enum  EffectiveEnums {
    INIT(0, "预效"),

    TRUE(1, "有效"),

    FALSE(2, "无效");

    private int value;
    private String desc;

    EffectiveEnums(int value, String desc) {
        this.value = value;
        this.desc = desc;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

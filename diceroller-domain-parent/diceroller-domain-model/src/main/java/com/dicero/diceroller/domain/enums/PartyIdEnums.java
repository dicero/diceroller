package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 * 参与方OuterMember-外部户,InnerMember-内部户
 * @author znz
 * @version 2017/10/31
 */
public enum PartyIdEnums {
    // NOTE: 外部户
    OUTER_MEMBER("OuterMember"),

    // NOTE: 内部户
    INNER_MEMBER("InnerMember");

    private String value;

    PartyIdEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}

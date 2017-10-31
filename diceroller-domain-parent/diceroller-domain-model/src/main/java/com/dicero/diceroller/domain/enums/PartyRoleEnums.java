package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 * 参与角色payee-付款方,payer-收款方
 * @author znz
 * @version 2017/10/31
 */
public enum PartyRoleEnums {
    // NOTE: 付款方
    PAYEE("payee"),
    // NOTE: 收款方
    PAYER("payer");

    private String value;

    PartyRoleEnums(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}

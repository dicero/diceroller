package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 * 参与角色payee-付款方,payer-收款方
 * @author znz
 * @version 2017/10/31
 */
public enum PartyRoleEnums {
    // NOTE: 付款方
    PAYEE("付款方"),
    // NOTE: 收款方
    PAYER("收款方");

    private String desc;

    PartyRoleEnums(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

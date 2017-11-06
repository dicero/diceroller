package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 * 状态：W-待结算；P-结算中；S-结算成功；F-结算失败；
 * @author znz
 * @version 2017/10/31
 */
public enum SettlementStatusEnums {
    // NOTE: W-待结算
    W("待结算"),
    // NOTE: P-结算中
    P("结算中"),
    // NOTE: S-结算成功
    S("结算成功"),
    // NOTE: R-驳回
    R("驳回"),
    // NOTE: F-结算失败
    F("结算失败"),
    // NOTE: C-转存中
    C("转存中"),
    // NOTE: E-转存成功
    E("转存成功");

    private String desc;


    SettlementStatusEnums(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

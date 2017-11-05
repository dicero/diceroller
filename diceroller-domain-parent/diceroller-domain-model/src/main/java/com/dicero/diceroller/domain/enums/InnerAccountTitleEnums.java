package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/5
 */
public enum  InnerAccountTitleEnums {
    LEVEL_BANK("1001", "存款"),
    LEVEL_CTL("1002", "管理费"),
    LEVEL_FEE("1003", "手续费"),
    LEVEL_PERSONAL("2001", "客户资金"),
    LEVEL_COMPANY("2008", "公司自有资金"),
    LEVEL_SETTLEMENT_FUND_IN("2020", "其他应付款-入款-结算过渡户"),
    LEVEL_SETTLEMENT_FUND_OUT("2021", "其他应付款-出款-结算过渡户"),
    LEVEL_SETTLEMENT_FUND_TRADE("2023", "其他应付款-交易-结算过渡户"),
    LEVEL_CLEARING("4001", "待清算  ");

    private String titleNo;
    private String desc;

    InnerAccountTitleEnums(String titleNo, String desc) {
        this.titleNo = titleNo;
        this.desc = desc;
    }

    public String getTitleNo() {
        return titleNo;
    }

    public void setTitleNo(String titleNo) {
        this.titleNo = titleNo;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

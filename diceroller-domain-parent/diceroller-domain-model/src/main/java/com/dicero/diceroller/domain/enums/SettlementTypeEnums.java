package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 * 结算类型,I:内场,O:外场
 * @author znz
 * @version 2017/10/31
 */
public enum  SettlementTypeEnums {
    // NOTE: I:内场
    I("内场结算"),
    // NOTE: O:外场
    O("外场结算");

    private String desc;

    SettlementTypeEnums(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }
}

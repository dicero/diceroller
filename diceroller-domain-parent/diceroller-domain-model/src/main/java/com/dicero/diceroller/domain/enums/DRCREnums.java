package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public enum DRCREnums {

    // NOTE: 借
    DR("借记"),

    // NOTE: 贷
    CR("贷记");

    private String desc;

    DRCREnums(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

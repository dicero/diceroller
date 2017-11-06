package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/7
 */
public enum  FundTypeEnums {
    FO("支出", "-"),

    FI("收入", "+");

    private String desc;
    private String sign;

    FundTypeEnums(String desc,String sign) {
        this.desc = desc;
        this.sign = sign;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }
}

package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/6
 */
public enum NoTypeEnums {
    PAYMENT_SEQ_NO("支付流水号"),
    REQUEST_NO("外部订单请求号"),
    VOUCHER_NO("支付凭证号");

    private String desc;

    NoTypeEnums(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}

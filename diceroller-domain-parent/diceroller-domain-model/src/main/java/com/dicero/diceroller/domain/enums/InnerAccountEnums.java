package com.dicero.diceroller.domain.enums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public enum InnerAccountEnums {

    // NOTE: 存款-比特币
    BANK_BIT("1001001"),
    BANK_ETH("1001002"), //  以太坊

    // NOTE: 管理-比特币
    CTL_BIT("1002001"),

    // NOTE: 客户资金-比特币
    PERSONAL_FUND_BIT("2001001"),

    // NOTE: 公司自有资金-备付金-比特币
    COMPANY_FUND_BIT("2008001"),

    // NOTE: 结算过渡户-入款-比特币
    SETTLEMENT_FUND_IN_BIT("2020001"),
    // NOTE: 结算过渡户-出款-比特币
    SETTLEMENT_FUND_OUT_BIT("2021001"),
    // NOTE: 结算过渡户-退款-比特币
    SETTLEMENT_FUND_REFUND_BIT("2022001"),
    // NOTE: 结算过渡户-交易-比特币
    SETTLEMENT_FUND_TRADE_BIT("2023001"),

    // NOTE: 待清算-入款待清算-比特币
    CLEARING_FUND_IN_BIT("4001101"),
    // NOTE: 待清算-出款待清算-比特币
    CLEARING_FUND_OUT_BIT("4001102");

    private String accountNo;

    InnerAccountEnums(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return accountNo;
    }
}

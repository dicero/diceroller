package com.dicero.diceroller.service.tss;

import java.math.BigDecimal;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/29
 */
public interface TssOrderService {

    // NOTE: 支付单
    void storePaymentOrder();

    // NOTE: 充值单
    void storeRechargeOrder();

    // NOTE: 提现单
    boolean storeWithdrawOrder(String requestNo, Integer memberId, String username, BigDecimal amt, String address);

    // NOTE: 赠送单
    void storePresentOrder();
}

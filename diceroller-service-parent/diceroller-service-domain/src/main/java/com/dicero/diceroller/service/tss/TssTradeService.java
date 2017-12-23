package com.dicero.diceroller.service.tss;

import com.dicero.diceroller.domain.model.TradeAccessPO;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/29
 */
public interface TssTradeService {

    void trade();

    boolean safeAccess(String accessToken);

    // NOTE: 判断是否可以访问
    boolean queryAccess(Integer memberId);

    // NOTE: 判断是否可以访问, 并开始设置下次不可访问
    boolean judgeAccess(Integer memberId);

    // NOTE: 重置访问
    boolean resetAccess(Integer memberId);

    TradeAccessPO createAccessTrade(Integer memberId);
}

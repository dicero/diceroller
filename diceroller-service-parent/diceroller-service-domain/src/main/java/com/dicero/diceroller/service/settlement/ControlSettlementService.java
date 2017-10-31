package com.dicero.diceroller.service.settlement;

import com.dicero.diceroller.service.bean.ClearAccount;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public interface ControlSettlementService {
    void buildInnerClearing(ClearAccount drClearAccount, ClearAccount crClearAccount);
    void buildOuterClearing(ClearAccount clearAccount);
}

package com.dicero.diceroller.service.settlement;

import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import com.dicero.diceroller.domain.model.ClearingOrderOuterPO;
import com.dicero.diceroller.service.bean.ClearAccount;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public interface ControlSettlementService {
    void buildInnerClearing(List<ClearingOrderInnerPO> clearingOrderInnerPOList, ClearAccount drClearAccount, ClearAccount crClearAccount);
    void buildOuterClearing(ClearingOrderOuterPO clearingOrderOuterPO, ClearAccount clearAccount);
}

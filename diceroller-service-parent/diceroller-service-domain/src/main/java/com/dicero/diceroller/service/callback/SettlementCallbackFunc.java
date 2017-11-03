package com.dicero.diceroller.service.callback;

import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.SettlementOrderPO;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/3
 */
public interface SettlementCallbackFunc<Boolean> {
    Boolean runInBack(SettlementOrderPO settlementOrderPO, TradeModeEnums tradeModeEnums);
}

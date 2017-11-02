package com.dicero.diceroller.service.settlement;

import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.SettlementOrderPO;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/1
 */
public interface InterfaceSettlementService {
    void settlement(SettlementOrderPO settlementOrderPO, TradeModeEnums tradeModeEnums);
}

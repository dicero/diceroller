package com.dicero.diceroller.service.settlement;

import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.SettlementOrderPO;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public interface ControlSettlementService {
    void control(SettlementOrderPO settlementOrderPO, TradeModeEnums tradeModeEnums);
}

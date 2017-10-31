package com.dicero.diceroller.service.settlement;

import com.dicero.diceroller.domain.enums.TradeModeEnums;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
public interface SettlementOrderService {

    void createSettlementCarrier(TradeModeEnums tradeModeEnums);
}

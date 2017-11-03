package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.SettlementOrderPO;
import com.dicero.diceroller.service.bean.SpringUtils;
import com.dicero.diceroller.service.settlement.ControlSettlementService;
import com.dicero.diceroller.service.settlement.InterfaceSettlementService;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
@Service
public class ControlSettlementServiceImpl implements ControlSettlementService {

    @Override
    public void control(SettlementOrderPO settlementOrderPO, TradeModeEnums tradeModeEnums) {
        InterfaceSettlementService interfaceSettlementService = SpringUtils.getBean(tradeModeEnums.getServiceName());
        interfaceSettlementService.settlement(settlementOrderPO, tradeModeEnums);
    }
}

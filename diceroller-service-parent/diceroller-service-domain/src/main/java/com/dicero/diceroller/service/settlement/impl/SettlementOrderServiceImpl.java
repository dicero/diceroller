package com.dicero.diceroller.service.settlement.impl;

import com.dicero.diceroller.domain.enums.PaymentTypeEnums;
import com.dicero.diceroller.domain.enums.SettlementStatusEnums;
import com.dicero.diceroller.domain.enums.TradeModeEnums;
import com.dicero.diceroller.domain.model.SettlementCarrierPO;
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.settlement.SettlementOrderService;
import org.springframework.stereotype.Service;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/31
 */
@Service
public class SettlementOrderServiceImpl extends BaseService implements SettlementOrderService {

    @Override
    public void createSettlementCarrier(TradeModeEnums tradeModeEnums) {
        SettlementCarrierPO settlementCarrierPO = new SettlementCarrierPO();
        settlementCarrierPO.setRequestNo("");
        settlementCarrierPO.setPaymentSeqNo("");
        settlementCarrierPO.setPaymentType(PaymentTypeEnums.I.name());
        settlementCarrierPO.setSettlementType("");
        settlementCarrierPO.setStatus(SettlementStatusEnums.W.name());
        settlementCarrierPO.setSummary("");



    }
}

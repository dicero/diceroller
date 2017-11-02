package com.dicero.diceroller.service.dpm;

import com.dicero.diceroller.domain.enums.PartyIdEnums;
import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import com.dicero.diceroller.domain.model.ClearingOrderOuterPO;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;


/**
 * <p>账户储值</p>
 *
 * @author znz
 * @version 2017/10/29
 */
public interface DpmAccountService {

    BigDecimal queryBalanceByAccountNo(PartyIdEnums partyIdEnums,  String accountNo);

    @Transactional
    boolean changeBalance(List<ClearingOrderInnerPO> clearingOrderInnerPOList);

    @Transactional
    boolean changeBalance(ClearingOrderOuterPO clearingOrderOuterPO, String paymentSeqNo);

}

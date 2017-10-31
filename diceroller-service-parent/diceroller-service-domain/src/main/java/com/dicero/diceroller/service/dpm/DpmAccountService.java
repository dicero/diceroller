package com.dicero.diceroller.service.dpm;

import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import com.dicero.diceroller.domain.model.ClearingOrderOuterPO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * <p>账户储值</p>
 *
 * @author znz
 * @version 2017/10/29
 */
public interface DpmAccountService {

    @Transactional
    void changeBalance(List<ClearingOrderInnerPO> clearingOrderInnerPOList);

    @Transactional
    void changeBalance(ClearingOrderOuterPO clearingOrderOuterPO);

}

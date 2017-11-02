package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.dal.mysql.repository.SettlementCarrierPORepository;
import com.dicero.diceroller.domain.enums.DRCREnums;
import com.dicero.diceroller.domain.enums.PartyIdEnums;
import com.dicero.diceroller.domain.enums.PartyRoleEnums;
import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class SettlementCarrierPORepositoryTest extends TestBase {
    @Autowired
    SettlementCarrierPORepository SettlementCarrierPORepository;

    @Test
    public void findByIdTest() {
        // SettlementCarrierPO record = SettlementCarrierPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }


}

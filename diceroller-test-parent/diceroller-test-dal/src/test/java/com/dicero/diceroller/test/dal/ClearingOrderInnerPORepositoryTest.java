package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.dal.mysql.repository.ClearingOrderInnerPORepository;
import com.dicero.diceroller.domain.enums.DRCREnums;
import com.dicero.diceroller.domain.enums.PartyIdEnums;
import com.dicero.diceroller.domain.enums.PartyRoleEnums;
import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import org.junit.Assert;
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
public class ClearingOrderInnerPORepositoryTest extends TestBase {
    @Autowired
    ClearingOrderInnerPORepository ClearingOrderInnerPORepository;

    @Test
    public void findByIdTest() {
        // ClearingOrderInnerPO record = ClearingOrderInnerPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

}

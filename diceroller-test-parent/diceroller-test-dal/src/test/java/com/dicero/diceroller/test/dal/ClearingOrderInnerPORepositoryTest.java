package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.ClearingOrderInnerPORepository;
import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import org.junit.Test;

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

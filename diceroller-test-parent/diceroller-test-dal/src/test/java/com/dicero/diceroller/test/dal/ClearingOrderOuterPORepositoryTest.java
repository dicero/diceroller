package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.ClearingOrderOuterPORepository;
import com.dicero.diceroller.domain.model.ClearingOrderOuterPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class ClearingOrderOuterPORepositoryTest extends TestBase {
    @Autowired
    ClearingOrderOuterPORepository ClearingOrderOuterPORepository;

    @Test
    public void findByIdTest() {
        // ClearingOrderOuterPO record = ClearingOrderOuterPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }
}

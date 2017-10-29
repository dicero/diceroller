package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.RechargeOrderPORepository;
import com.dicero.diceroller.domain.model.RechargeOrderPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class RechargeOrderPORepositoryTest extends TestBase {
    @Autowired
    RechargeOrderPORepository RechargeOrderPORepository;

    @Test
    public void findByIdTest() {
        // RechargeOrderPO record = RechargeOrderPOrepository.findById(1);
        //  println(record);
        // Assert.assertNotNull(record);
    }
}

package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.PaymentPartyPORepository;
import com.dicero.diceroller.domain.model.PaymentPartyPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PaymentPartyPORepositoryTest extends TestBase {
    @Autowired
    PaymentPartyPORepository PaymentPartyPORepository;

    @Test
    public void findByIdTest() {
        // PaymentPartyPO record = PaymentPartyPOrepository.findById(1);
        //  println(record);
        // Assert.assertNotNull(record);
    }
}

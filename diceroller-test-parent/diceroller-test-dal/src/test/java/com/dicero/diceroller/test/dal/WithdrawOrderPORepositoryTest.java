package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.WithdrawOrderPORepository;
import com.dicero.diceroller.domain.model.WithdrawOrderPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class WithdrawOrderPORepositoryTest extends TestBase {
    @Autowired
    WithdrawOrderPORepository WithdrawOrderPORepository;

    @Test
    public void findByIdTest() {
        // WithdrawOrderPO record = WithdrawOrderPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void saveTest() {
         WithdrawOrderPO record = new WithdrawOrderPO();
         record.setMemberId(1231312321);
         record.setPaymentSeqNo("dddd");
         record.setAddress("dddddd");
        record = WithdrawOrderPORepository.save(record);
         println(record);
         Assert.assertNotNull(record);
    }
}

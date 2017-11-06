package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.dal.mysql.repository.InnerAccountDetailPORepository;
import com.dicero.diceroller.domain.model.InnerAccountDetailPO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class InnerAccountDetailPORepositoryTest extends TestBase {
    @Autowired
    InnerAccountDetailPORepository InnerAccountDetailPORepository;

    @Test
    public void findByIdTest() {
        // InnerAccountDetailPO record = InnerAccountDetailPOrepository.findById(1);
        //  println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void findAllByPaymentSeqNoTest() {
         List<InnerAccountDetailPO> recordList = InnerAccountDetailPORepository.findAllByPaymentSeqNo("P0001711040018250SEQ0375221");
          println(recordList);
         Assert.assertNotNull(recordList);
    }
}

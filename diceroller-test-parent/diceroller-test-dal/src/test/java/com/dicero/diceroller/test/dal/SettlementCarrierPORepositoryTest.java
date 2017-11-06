package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.dal.mysql.repository.SettlementCarrierPORepository;
import com.dicero.diceroller.domain.model.SettlementCarrierPO;
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
public class SettlementCarrierPORepositoryTest extends TestBase {
    @Autowired
    SettlementCarrierPORepository SettlementCarrierPORepository;

    @Test
    public void findByIdTest() {
        // SettlementCarrierPO record = SettlementCarrierPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void findAllByPaymentSeqNoTest() {
         List<SettlementCarrierPO> recordList = SettlementCarrierPORepository.findAllByPaymentSeqNo("P0001711040018250SEQ0375221");
         println(recordList);
         Assert.assertNotNull(recordList);
    }


}

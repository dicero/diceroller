package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.SettlementCarrierPORepository;
import com.dicero.diceroller.domain.model.SettlementCarrierPO;
import org.junit.Test;

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

package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.SettlementOrderPORepository;
import com.dicero.diceroller.domain.model.SettlementOrderPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class SettlementOrderPORepositoryTest extends TestBase {
    @Autowired
    SettlementOrderPORepository SettlementOrderPORepository;

    @Test
    public void findByIdTest() {
        // SettlementOrderPO record = SettlementOrderPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }
}

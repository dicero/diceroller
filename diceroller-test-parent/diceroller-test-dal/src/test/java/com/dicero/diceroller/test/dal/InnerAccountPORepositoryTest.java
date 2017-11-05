package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.dal.mysql.repository.InnerAccountPORepository;
import com.dicero.diceroller.domain.enums.InnerAccountEnums;
import com.dicero.diceroller.domain.model.InnerAccountPO;
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
public class InnerAccountPORepositoryTest extends TestBase {
    @Autowired
    InnerAccountPORepository InnerAccountPORepository;

    @Test
    public void findByIdTest() {
        // InnerAccountPO record = InnerAccountPOrepository.findById(1);
        //  println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void findAllTest() {
        List<InnerAccountPO> recordList = InnerAccountPORepository.findAll();
        println(recordList);
        Assert.assertNotNull(recordList);
    }

    @Test
    public void findByAccountNoTest() {
         InnerAccountPO record = InnerAccountPORepository.findByAccountNo(InnerAccountEnums.PERSONAL_FUND_BIT.getAccountNo());
          println(record);
         Assert.assertNotNull(record);
    }
}

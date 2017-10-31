package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.domain.enums.OuterAccountEnums;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.OuterAccountSubsetPORepository;
import com.dicero.diceroller.domain.model.OuterAccountSubsetPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class OuterAccountSubsetPORepositoryTest extends TestBase {
    @Autowired
    OuterAccountSubsetPORepository OuterAccountSubsetPORepository;

    @Test
    public void findByIdTest() {
        // OuterAccountSubsetPO record = OuterAccountSubsetPOrepository.findById(1);
        //  println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void findByAccountNoTest() {
         OuterAccountSubsetPO record = OuterAccountSubsetPORepository.findByAccountNo(OuterAccountEnums.get201Account("2000000000"));
          println(record);
         Assert.assertNotNull(record);
    }
}

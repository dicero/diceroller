package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.PersonalBillPORepository;
import com.dicero.diceroller.domain.model.PersonalBillPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PersonalBillPORepositoryTest extends TestBase {
    @Autowired
    PersonalBillPORepository PersonalBillPORepository;

    @Test
    public void findByIdTest() {
        // PersonalBillPO record = PersonalBillPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }
}

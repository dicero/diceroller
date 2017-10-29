package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.PersonalStakePORepository;
import com.dicero.diceroller.domain.model.PersonalStakePO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PersonalStakePORepositoryTest extends TestBase {
    @Autowired
    PersonalStakePORepository PersonalStakePORepository;

    @Test
    public void findByIdTest() {
        // PersonalStakePO record = PersonalStakePOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }
}

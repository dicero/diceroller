package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.PersonalInfoPORepository;
import com.dicero.diceroller.domain.model.PersonalInfoPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PersonalInfoPORepositoryTest extends TestBase {
    @Autowired
    PersonalInfoPORepository PersonalInfoPORepository;

    @Test
    public void findByIdTest() {
        // PersonalInfoPO record = PersonalInfoPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }
}

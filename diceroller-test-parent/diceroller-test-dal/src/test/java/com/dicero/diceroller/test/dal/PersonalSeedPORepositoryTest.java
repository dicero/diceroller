package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.PersonalSeedPORepository;
import com.dicero.diceroller.domain.model.PersonalSeedPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PersonalSeedPORepositoryTest extends TestBase {
    @Autowired
    PersonalSeedPORepository PersonalSeedPORepository;

    @Test
    public void findByIdTest() {
        // PersonalSeedPO record = PersonalSeedPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }
}

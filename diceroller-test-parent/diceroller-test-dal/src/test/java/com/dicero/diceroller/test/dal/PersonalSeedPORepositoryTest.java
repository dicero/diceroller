package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.dal.mysql.repository.PersonalInfoPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalSeedPORepository;
import com.dicero.diceroller.domain.model.PersonalInfoPO;
import com.dicero.diceroller.domain.model.PersonalSeedPO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

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

    @Test
    public void saveTest() {
        PersonalSeedPO record = new PersonalSeedPO();
        record.setMemberId(2000000000);
        record.setSeed("2222223333334444445555666");
        record.setDefaultUse(1);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        record = PersonalSeedPORepository.save(record);
        println(record);
        Assert.assertNotNull(record);
    }
}

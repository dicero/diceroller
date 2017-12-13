package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.PersonalAdvisePORepository;
import com.dicero.diceroller.domain.model.PersonalAdvisePO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PersonalAdvisePORepositoryTest extends TestBase {
    @Autowired
    PersonalAdvisePORepository PersonalAdvisePORepository;

    @Test
    public void findByIdTest() {
        // PersonalAdvisePO record = PersonalAdvisePOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void saveTest() {
        PersonalAdvisePO record = new PersonalAdvisePO();
        record.setContent("");
        record.setReaded(0);
        record.setEmail("112223@gmail.com");
        record.setMemberId(111222);
        record.setCreateTime(now);
        record.setUpdateTime(now);
        record = PersonalAdvisePORepository.save(record);
         println(record);
         Assert.assertNotNull(record);
    }
}

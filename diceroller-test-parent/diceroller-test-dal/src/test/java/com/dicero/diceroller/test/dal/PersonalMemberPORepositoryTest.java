package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.PersonalMemberPORepository;
import com.dicero.diceroller.domain.model.PersonalMemberPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PersonalMemberPORepositoryTest extends TestBase {
    @Autowired
    PersonalMemberPORepository PersonalMemberPORepository;

    @Test
    public void findByIdTest() {
        // PersonalMemberPO record = PersonalMemberPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }
}

package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.PersonalStakeHistoryPORepository;
import com.dicero.diceroller.domain.model.PersonalStakeHistoryPO;
import org.junit.Test;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class PersonalStakeHistoryPORepositoryTest extends TestBase {
    @Autowired
    PersonalStakeHistoryPORepository PersonalStakeHistoryPORepository;

    @Test
    public void findByIdTest() {
        // PersonalStakeHistoryPO record = PersonalStakeHistoryPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }
}

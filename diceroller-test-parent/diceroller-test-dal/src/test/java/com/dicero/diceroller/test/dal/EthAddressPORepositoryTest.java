package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.dal.mysql.repository.EthAddressPORepository;
import com.dicero.diceroller.domain.model.EthAddressPO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/25
 */
public class EthAddressPORepositoryTest extends TestBase {
    @Autowired
    EthAddressPORepository EthAddressPORepository;

    @Test
    public void findByHasUseTest() {
         List<EthAddressPO> record = EthAddressPORepository.findByHasUse(0, new PageRequest(0, 1, new Sort(Sort.Direction.ASC, new String[] { "id" })  ));
         println(record);
         Assert.assertNotNull(record);
    }

    @Test
    public void findByIdTest() {
        // EthAddressPO record = EthAddressPOrepository.findById(1);
        // println(record);
        // Assert.assertNotNull(record);
    }

    @Test
    public void updateHasUseByIdTest() {
         int row = EthAddressPORepository.updateHasUseById(1, 1);
         println(row);
         Assert.assertNotNull(row);
    }
}

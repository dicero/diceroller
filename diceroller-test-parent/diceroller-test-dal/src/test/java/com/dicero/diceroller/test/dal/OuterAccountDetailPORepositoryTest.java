package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import com.dicero.diceroller.dal.mysql.repository.OuterAccountDetailPORepository;
import com.dicero.diceroller.domain.model.OuterAccountDetailPO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public class OuterAccountDetailPORepositoryTest extends TestBase {
    @Autowired
    OuterAccountDetailPORepository OuterAccountDetailPORepository;

    @Test
    public void findByIdTest() {

    }

    @Test
    public void findAllByPaymentSeqNoTest() {
        List<OuterAccountDetailPO> outerAccountDetailPOList = OuterAccountDetailPORepository.findAllByPaymentSeqNo("P0001711040018250SEQ0375221");
        println(outerAccountDetailPOList);
        Assert.assertNotNull(outerAccountDetailPOList);
    }

}

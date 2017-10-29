package com.dicero.diceroller.test.dal;

import com.dicero.diceroller.TestBase;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import com.dicero.diceroller.dal.mysql.repository.OuterAccountDetailPORepository;
import com.dicero.diceroller.domain.model.OuterAccountDetailPO;
import org.junit.Test;

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
}

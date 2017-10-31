package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.model.OuterAccountPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public interface OuterAccountPORepository extends JpaRepository<OuterAccountPO, Integer> {
    OuterAccountPO findById(Integer id);

    OuterAccountPO findByAccountNo(String accountNo);
}
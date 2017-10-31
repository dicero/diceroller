package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.model.InnerAccountPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public interface InnerAccountPORepository extends JpaRepository<InnerAccountPO, Integer> {

    InnerAccountPO findByAccountNo(String accountNo);
}
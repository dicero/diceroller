package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.model.OuterAccountDetailPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public interface OuterAccountDetailPORepository extends JpaRepository<OuterAccountDetailPO, Integer> {
    List<OuterAccountDetailPO> findAllByPaymentSeqNo(String paymentSeqNo);
}
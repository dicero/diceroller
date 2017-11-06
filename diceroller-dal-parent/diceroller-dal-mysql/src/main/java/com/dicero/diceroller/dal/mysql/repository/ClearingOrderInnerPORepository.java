package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.model.ClearingOrderInnerPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public interface ClearingOrderInnerPORepository extends JpaRepository<ClearingOrderInnerPO, Integer> {
    List<ClearingOrderInnerPO> findAllByPaymentSeqNo(String paymentSeqNo);
}
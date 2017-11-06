package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.model.SettlementOrderPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public interface SettlementOrderPORepository extends JpaRepository<SettlementOrderPO, Integer> {

    SettlementOrderPO findByPaymentSeqNo(String paymentSeqNo);

    List<SettlementOrderPO> findAllByPaymentSeqNo(String paymentSeqNo);

    @Transactional
    @Modifying
    @Query("update SettlementOrderPO set status=?2, clearing_code_list=?3 where payment_seq_no = ?1")
    int updateStatusAndClearingCodeListByPaymentSeqNo(String paymentSeqNo,String status, String clearingCodeList);
}
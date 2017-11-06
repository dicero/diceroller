package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.model.SettlementCarrierPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public interface SettlementCarrierPORepository extends JpaRepository<SettlementCarrierPO, Integer> {
    List<SettlementCarrierPO> findAllByPaymentSeqNo(String paymentSeqNo);

    @Transactional
    @Modifying
    @Query("update SettlementCarrierPO set status=?2  where id = ?1")
    int updateStatusById(Integer id, String status);
}
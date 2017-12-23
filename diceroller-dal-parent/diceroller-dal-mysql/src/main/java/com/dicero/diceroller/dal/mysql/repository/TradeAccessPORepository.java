package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.enums.AccessNodeEnums;
import com.dicero.diceroller.domain.model.TradeAccessPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/12/23
 */
public interface TradeAccessPORepository extends JpaRepository<TradeAccessPO, Integer> {
    TradeAccessPO findByMemberIdAndNode(Integer memberId, AccessNodeEnums node);

    @Transactional
    @Modifying
    @Query("update TradeAccessPO set version=?2, node=?3 where id = ?1 and version+1 = ?2")
    int updateNodeById(Integer id, Integer version, AccessNodeEnums node);
}

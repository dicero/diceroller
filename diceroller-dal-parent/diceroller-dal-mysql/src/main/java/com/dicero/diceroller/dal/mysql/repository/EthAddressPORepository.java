package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.model.EthAddressPO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/25
 */
public interface EthAddressPORepository extends JpaRepository<EthAddressPO, Integer> {
    List<EthAddressPO> findByHasUse(Integer hasUse, Pageable pageable);


    @Transactional
    @Modifying
    @Query("update EthAddressPO set hasUse=?2 where id = ?1")
    int updateHasUseById(Integer id, Integer hasUse);
}
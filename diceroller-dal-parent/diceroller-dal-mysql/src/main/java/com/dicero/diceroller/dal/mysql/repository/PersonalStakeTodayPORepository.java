package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.model.PersonalStakeTodayPO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public interface PersonalStakeTodayPORepository extends JpaRepository<PersonalStakeTodayPO, Integer> {
    PersonalStakeTodayPO findByMemberIdAndCalDate(Integer memberId, Date calDate);
}
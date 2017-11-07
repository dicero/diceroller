package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.model.PersonalInfoPO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public interface PersonalInfoPORepository extends JpaRepository<PersonalInfoPO, Integer> {
    PersonalInfoPO findByMemberId(Integer memberId);
}
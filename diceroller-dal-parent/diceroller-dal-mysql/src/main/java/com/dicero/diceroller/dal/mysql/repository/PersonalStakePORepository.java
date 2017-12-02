package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.enums.EffectiveEnums;
import com.dicero.diceroller.domain.model.PersonalStakePO;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public interface PersonalStakePORepository extends JpaRepository<PersonalStakePO, Integer> {
    PersonalStakePO findByStakeId(String stakeId);

    List<PersonalStakePO> findAllByMemberId(Integer memberId, Pageable pageable);

    List<PersonalStakePO> findAllByMemberIdAndEffective(Integer memberId, EffectiveEnums effectiveEnums, Pageable pageable);

    List<PersonalStakePO> findAllByEffective(EffectiveEnums effectiveEnums, Pageable pageable);
}
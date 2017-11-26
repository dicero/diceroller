package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.model.PersonalSeedPO;
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
public interface PersonalSeedPORepository extends JpaRepository<PersonalSeedPO, Integer> {

    PersonalSeedPO findByMemberIdAndDefaultUse(Integer memberId, int defaultUse);

    List<PersonalSeedPO> findAllByMemberId(Integer memberId);

    @Transactional
    @Modifying
    @Query("update PersonalSeedPO set defaultUse=?2, updateTime=now() where id = ?1")
    int updateDefaultUseById(Integer id, int defaultUse);
}
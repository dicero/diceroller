package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.model.PersonalSeedTmpPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/26
 */
public interface PersonalSeedTmpPORepository extends JpaRepository<PersonalSeedTmpPO, Integer> {
    PersonalSeedTmpPO findByMemberIdAndDefaultOver(Integer memberId, int defaultOver);

    PersonalSeedTmpPO findByMemberIdAndClientSeedAndDefaultOver(Integer memberId, String clientSeed, int defaultOver);

    @Transactional
    @Modifying
    @Query("update PersonalSeedTmpPO set defaultOver=?2, updateTime=now() where id = ?1")
    int updateDefaultOverById(Integer id, int defaultOver);
}
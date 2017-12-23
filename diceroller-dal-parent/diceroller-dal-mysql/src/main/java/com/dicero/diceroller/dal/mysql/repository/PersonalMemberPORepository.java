package com.dicero.diceroller.dal.mysql.repository;

import com.dicero.diceroller.domain.model.PersonalMemberPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
public interface PersonalMemberPORepository extends JpaRepository<PersonalMemberPO, Integer> {
    PersonalMemberPO findByMemberId(Integer memberId);
    PersonalMemberPO findByMemberAccount(String memberAccount);
    PersonalMemberPO findByPlayAccessToken(String playAccessToken);

    @Transactional
    @Modifying
    @Query("update PersonalMemberPO set pwd=?2, updateTime=now() where memberId = ?1")
    int updatePasswordByMemberId(Integer memberId, String pwd);
}
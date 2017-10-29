package com.dicero.diceroller.dal.mysql.repository;

import java.util.Collection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.dicero.diceroller.domain.model.UserPlatformPO;


/**   
* <p>平台登录用户</p>
* @author ningzong.zeng
*/
public interface  UserPlatformRepository extends JpaRepository<UserPlatformPO, Long> {
	
	UserPlatformPO findById(Long id);
	
	UserPlatformPO findByLoginUsername(String loginUsername);
	
	Page<UserPlatformPO> findUserPlatformByLoginUsername(String loginUsername, Pageable pageable);
	
	@Transactional @Modifying @Query(""
		 + "update UserPlatformPO u set "
   	  	 + "u.loginUsername=:loginUsername, u.loginPassword=:loginPassword,u.nickName=:nickName "
   		 + "where u.id=:id")
    Integer setFixedFor(@Param("id") Long id,
		   @Param("loginUsername") String loginUsername, 
		   @Param("loginPassword") String loginPassword,
		   @Param("nickName") String nickName); 
	
	@Transactional @Modifying
	Long deleteById(Long id);
	
	@Transactional @Modifying
	Long deleteByIdIn(Collection<Long> ids);
}

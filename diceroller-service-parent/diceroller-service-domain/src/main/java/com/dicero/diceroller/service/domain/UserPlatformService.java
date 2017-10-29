package com.dicero.diceroller.service.domain;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dicero.diceroller.domain.model.UserPlatformPO;


/**   
* <p></p>
* @author ningzong.zeng
*/
public interface UserPlatformService {
	UserPlatformPO findById(Long id);
	UserPlatformPO findByLoginUsername(String loginUsername);
	Page<UserPlatformPO> findAll(int page, int pageSize);
	int update(Long id, String loginUsername, String loginPassword, String nickName);
	UserPlatformPO save(UserPlatformPO record);
	Long deleteById(Long id);
	Long deleteByIdIn(List<Long> ids);
	UserPlatformPO login(String loginUsername, String loginPassword);
}

package com.dicero.diceroller.service.domain;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dicero.diceroller.domain.model.UserPlatform;


/**   
* <p></p>
* @author ningzong.zeng
*/
public interface UserPlatformService {
	UserPlatform findById(Long id);
	UserPlatform findByLoginUsername(String loginUsername);
	Page<UserPlatform> findAll(int page, int pageSize);
	int update(Long id, String loginUsername, String loginPassword, String nickName);
	UserPlatform save(UserPlatform record);
	Long deleteById(Long id);
	Long deleteByIdIn(List<Long> ids);
	UserPlatform login(String loginUsername, String loginPassword);
}

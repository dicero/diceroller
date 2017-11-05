package com.dicero.diceroller.service.domain;

import com.dicero.diceroller.domain.enums.AdminRole;
import com.dicero.diceroller.domain.model.UserPlatformPO;
import org.springframework.data.domain.Page;

import java.util.List;


/**   
* <p></p>
* @author ningzong.zeng
*/
public interface UserPlatformService {
	UserPlatformPO findById(Long id);
	UserPlatformPO findByLoginUsername(String loginUsername);
	Page<UserPlatformPO> findAll(int page, int pageSize);
    int update(Long id, String loginUsername, String loginPassword, AdminRole adminRole, String nickName);
	UserPlatformPO save(UserPlatformPO record);
	Long deleteById(Long id);
	Long deleteByIdIn(List<Long> ids);
	UserPlatformPO login(String loginUsername, String loginPassword);
}

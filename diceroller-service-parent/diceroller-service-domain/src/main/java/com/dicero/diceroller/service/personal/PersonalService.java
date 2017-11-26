package com.dicero.diceroller.service.personal;

import com.dicero.diceroller.domain.model.PersonalMemberPO;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/29
 */
public interface PersonalService {
    // NOTE: 登录
    PersonalMemberPO login(String loginUsername, String loginPassword) ;

    // NOTE: 注册
    PersonalMemberPO register(String loginUsername) ;

    // NOTE: 设置密码
    boolean setPersonalPassword(Integer memberId, String password) ;

    // NOTE: 设置密码
    boolean updatePersonalPassword(Integer memberId, String oldPassword, String newPassword) ;

}

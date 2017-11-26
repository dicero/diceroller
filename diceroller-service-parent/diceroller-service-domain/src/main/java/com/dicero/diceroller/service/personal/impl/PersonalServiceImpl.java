package com.dicero.diceroller.service.personal.impl;

import com.dicero.diceroller.common.bean.extension.CommonDefinedException;
import com.dicero.diceroller.common.util.EncryptUtil;
import com.dicero.diceroller.common.util.MD5Util;
import com.dicero.diceroller.dal.mysql.repository.*;
import com.dicero.diceroller.domain.model.*;
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.personal.PersonalService;
import com.dicero.diceroller.service.play.PlayService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/29
 */
@Service
public class PersonalServiceImpl extends BaseService implements PersonalService {
    @Autowired PlayService playService;
    @Autowired PersonalSeedPORepository personalSeedPORepository;
    @Autowired PersonalMemberPORepository personalMemberPORepository;
    @Autowired PersonalInfoPORepository personalInfoPORepository;
    @Autowired EthAddressPORepository ethAddressPORepository;
    public final String salt = "666k^$V..&)[1";

    @Override
    public PersonalMemberPO login(String loginUsername, String loginPassword) {
        PersonalMemberPO personalMemberPO = personalMemberPORepository.findByMemberAccount(loginUsername);
        if(personalMemberPO != null && StringUtils.isNotBlank(personalMemberPO.getPwd()) && verifyMd5Password(loginPassword, personalMemberPO.getPwd())) {
            return personalMemberPO;
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public PersonalMemberPO register(String loginUsername) {
        PersonalMemberPO personalMemberPO = new PersonalMemberPO();
        personalMemberPO.setMemberAccount(loginUsername);
        personalMemberPO.setCreateTime(now);
        personalMemberPO.setUpdateTime(now);
        personalMemberPO =  personalMemberPORepository.save(personalMemberPO);


        // NOTE: 获取充值地址
        List<EthAddressPO> records = ethAddressPORepository.findByHasUse(0, new PageRequest(0, 1, new Sort(Sort.Direction.ASC, new String[] { "id" })  ));
        if(CollectionUtils.isEmpty(records)) {
            throw CommonDefinedException.SYSTEM_ERROR("地址用完");
        }
        EthAddressPO ethAddressPO = records.get(0);
        ethAddressPORepository.updateHasUseById(ethAddressPO.getId(), 1);

        // NOTE: 创建用户信息记录
        PersonalInfoPO personalInfoPO = new PersonalInfoPO();
        personalInfoPO.setMemberId(personalMemberPO.getMemberId());
        personalInfoPO.setNotifyBitAddress(ethAddressPO.getAddress());
        personalInfoPO.setCreateTime(now);
        personalInfoPO.setUpdateTime(now);
        personalInfoPORepository.save(personalInfoPO);

        // NOTE: 初始化用户种子
        PersonalSeedPO personalSeedPO = new PersonalSeedPO();
        personalSeedPO.setMemberId(personalInfoPO.getMemberId());
        personalSeedPO.setDefaultUse(1);
        personalSeedPO.setCreateTime(now);
        personalSeedPO.setUpdateTime(now);
        personalSeedPO.setServerSeed(playService.createServerSeed());
        personalSeedPO.setClientSeed(playService.createClientSeed());
        personalSeedPO.setServerSeedHash(EncryptUtil.SHA256(personalSeedPO.getServerSeed()));
        personalSeedPORepository.save(personalSeedPO);

        return personalMemberPO;
    }


    @Override
    public boolean setPersonalPassword(Integer memberId, String password) {
        if(memberId != null && StringUtils.isNotBlank(password) ){
            personalMemberPORepository.updatePasswordByMemberId(memberId, md5Password(password));
            return true;
        }
        return false;
    }

    @Override
    public boolean updatePersonalPassword(Integer memberId, String oldPassword, String newPassword) {
        PersonalMemberPO personalMemberPO = personalMemberPORepository.findByMemberId(memberId);
        if (personalMemberPO != null && StringUtils.isNotBlank(personalMemberPO.getPwd())
                && personalMemberPO.getPwd().equals(md5Password(oldPassword))) {
            personalMemberPORepository.updatePasswordByMemberId(memberId, md5Password(newPassword));
            return true;
        }
        return false;
    }

    private String md5Password(String password){
        return MD5Util.sign(password, salt);
    }

    private boolean verifyMd5Password(String password, String sign){
        return MD5Util.verify(password, sign, salt);
    }

}

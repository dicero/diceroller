package com.dicero.diceroller.service.personal.impl;

import com.dicero.diceroller.common.bean.extension.CommonDefinedException;
import com.dicero.diceroller.common.util.EncryptUtil;
import com.dicero.diceroller.common.util.MD5Util;
import com.dicero.diceroller.core.coin.util.Web3jConstants;
import com.dicero.diceroller.dal.mysql.repository.EthAddressPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalInfoPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalMemberPORepository;
import com.dicero.diceroller.dal.mysql.repository.PersonalSeedPORepository;
import com.dicero.diceroller.domain.model.EthAddressPO;
import com.dicero.diceroller.domain.model.PersonalInfoPO;
import com.dicero.diceroller.domain.model.PersonalMemberPO;
import com.dicero.diceroller.domain.model.PersonalSeedPO;
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.personal.PersonalService;
import com.dicero.diceroller.service.play.PlayService;
import com.dicero.diceroller.service.tss.TssTradeService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
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
    @Autowired TssTradeService tssTradeService;
    @Autowired PersonalSeedPORepository personalSeedPORepository;
    @Autowired PersonalMemberPORepository personalMemberPORepository;
    @Autowired PersonalInfoPORepository personalInfoPORepository;
    @Autowired EthAddressPORepository ethAddressPORepository;
    public final String salt = "666k^$V..&)[1";

    @Override
    public PersonalMemberPO login(String loginUsername, String loginPassword) {
        PersonalMemberPO personalMemberPO = personalMemberPORepository.findByMemberAccount(loginUsername);
        if(personalMemberPO != null && StringUtils.isNotBlank(personalMemberPO.getPwd()) && verifyMd5Password(loginPassword, personalMemberPO.getPwd())) {
            // NOTE: 更新playAccessToken
            personalMemberPORepository.updatePasswordByMemberId(personalMemberPO.getMemberId(), createPlayAccessToken());
            return personalMemberPO;
        }
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public PersonalMemberPO register(String loginUsername) {
        PersonalMemberPO personalMemberPO = new PersonalMemberPO();
        personalMemberPO.setMemberAccount(loginUsername);
        personalMemberPO.setPlayAccessToken(createPlayAccessToken());
        personalMemberPO.setCreateTime(now());
        personalMemberPO.setUpdateTime(now());
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
        personalInfoPO.setEthGasPrice(Web3jConstants.GAS_PRICE);
        personalInfoPO.setEthGasLimit(Web3jConstants.GAS_LIMIT_ETHER_TX);
        personalInfoPO.setCreateTime(now());
        personalInfoPO.setUpdateTime(now());
        personalInfoPORepository.save(personalInfoPO);

        // NOTE: 初始化用户种子
        PersonalSeedPO personalSeedPO = new PersonalSeedPO();
        personalSeedPO.setMemberId(personalInfoPO.getMemberId());
        personalSeedPO.setDefaultUse(1);
        personalSeedPO.setCreateTime(now());
        personalSeedPO.setUpdateTime(now());
        personalSeedPO.setServerSeed(playService.createServerSeed());
        personalSeedPO.setClientSeed(playService.createClientSeed());
        personalSeedPO.setServerSeedHash(EncryptUtil.SHA256(personalSeedPO.getServerSeed()));
        personalSeedPORepository.save(personalSeedPO);

        // NOTE: 下单授权
        tssTradeService.createAccessTrade(personalMemberPO.getMemberId());

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

    private String createPlayAccessToken() {
        return MD5Util.sign("901"+ System.currentTimeMillis() + RandomStringUtils.randomAlphanumeric(6), "dice2099311X");
    }

    private String md5Password(String password){
        return MD5Util.sign(password, salt);
    }

    private boolean verifyMd5Password(String password, String sign){
        return MD5Util.verify(password, sign, salt);
    }

}

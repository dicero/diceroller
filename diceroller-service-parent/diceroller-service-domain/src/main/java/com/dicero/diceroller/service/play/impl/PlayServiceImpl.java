package com.dicero.diceroller.service.play.impl;

import com.dicero.diceroller.common.bean.extension.CommonDefinedException;
import com.dicero.diceroller.common.util.EncryptUtil;
import com.dicero.diceroller.common.util.RandomUtil;
import com.dicero.diceroller.dal.mysql.repository.*;
import com.dicero.diceroller.domain.enums.EffectiveEnums;
import com.dicero.diceroller.domain.enums.FundTypeEnums;
import com.dicero.diceroller.domain.enums.TradeTypeEnums;
import com.dicero.diceroller.domain.model.*;
import com.dicero.diceroller.service.BaseService;
import com.dicero.diceroller.service.bean.DiceHmacBean;
import com.dicero.diceroller.service.bean.RollerBean;
import com.dicero.diceroller.service.play.PlayService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.Future;

/**
 * <p></p>
 当前种子对
 用户种子
 13612799814343
 服务器种子sha-256散列
 779176bd344b41a2b7f9c508c84a295670aa995f73201ac0fe99384e62c84f55
 ------------------------------------------------------------------------------------------
 以往种子配对
 用户种子
 5162163102898
 服务器种子
 1481c95e15e1ca2b0f1abe61c26c1c571cb799b5015e0fc3b18eae7d7610b276
 服务器种子sha-256散列
 8bd4ad65e79cb6b3b2e283aad771fe44c76548f7b2d60b8fe4927c244529450a
 * @author znz
 * @version 2017/10/29
 */
@Slf4j
@Service
public class PlayServiceImpl extends BaseService implements PlayService{

    @Autowired PersonalSeedPORepository personalSeedPORepository;
    @Autowired PersonalBillPORepository personalBillPORepository;
    @Autowired PersonalStakePORepository personalStakePORepository;
    @Autowired PersonalMemberPORepository personalMemberPORepository;
    @Autowired PersonalSeedTmpPORepository personalSeedTmpPORepository;

    @Override
    public String createClientSeed() {
        // NOTE: 13612799814343 , 14
        return "5" + RandomStringUtils.randomAlphanumeric(2) + System.currentTimeMillis() + RandomStringUtils.randomAlphanumeric(4) ;
    }

    @Override
    public String createServerSeed() {
        return EncryptUtil.SHA256("dice1099322Y" + System.currentTimeMillis() + RandomStringUtils.randomAlphanumeric(6) );
    }

    @Override
    public PersonalSeedTmpPO createPersonalSeedTmp(Integer memberId) {
        // NOTE: 创建临时种子数据
        PersonalSeedTmpPO personalSeedTmpPO = personalSeedTmpPORepository.findByMemberIdAndDefaultOver(memberId, 0);
        if (personalSeedTmpPO == null) {
            personalSeedTmpPO = new PersonalSeedTmpPO();
            String serverSeed = createServerSeed();
            String clientSeed = createClientSeed();
            personalSeedTmpPO.setMemberId(memberId);
            personalSeedTmpPO.setServerSeed(serverSeed);
            personalSeedTmpPO.setClientSeed(clientSeed);
            personalSeedTmpPO.setCreateTime(now);
            personalSeedTmpPO.setUpdateTime(now);
            personalSeedTmpPO = personalSeedTmpPORepository.save(personalSeedTmpPO);
        }

        return personalSeedTmpPO;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updatePersonalSeedByTmp(Integer memberId, String clientSeed) {
        PersonalSeedTmpPO personalSeedTmpPO = personalSeedTmpPORepository.findByMemberIdAndClientSeedAndDefaultOver(memberId, clientSeed, 0);
        if (personalSeedTmpPO != null ) {

            // NOTE: 更新老的数据
            PersonalSeedPO personalSeedPO = personalSeedPORepository.findByMemberIdAndDefaultUse(memberId, 1);
            personalSeedPORepository.updateDefaultUseById(personalSeedPO.getId(), 0);

            // NOTE: 更换种子
            PersonalSeedPO defaultPersonalSeedPO = new PersonalSeedPO();
            defaultPersonalSeedPO.setMemberId(memberId);
            defaultPersonalSeedPO.setClientSeed(personalSeedTmpPO.getClientSeed());
            defaultPersonalSeedPO.setServerSeed(personalSeedTmpPO.getServerSeed());
            defaultPersonalSeedPO.setServerSeedHash(EncryptUtil.SHA256(personalSeedTmpPO.getServerSeed()));
            defaultPersonalSeedPO.setCreateTime(now);
            defaultPersonalSeedPO.setUpdateTime(now);
            defaultPersonalSeedPO.setDefaultUse(1);
            personalSeedPORepository.save(defaultPersonalSeedPO);

            // NOTE: 废弃临时种子
            personalSeedTmpPORepository.updateDefaultOverById(personalSeedTmpPO.getId(), 1);

            return true;
        }
        return false;
    }


    @Transactional(rollbackFor = Exception.class)
    @Override
    public PersonalStakePO roller(Integer memberId, RollerBean rollerBean) {
        // NOTE:查询以往数据,设置下标
        int nonce = 0;
        List<PersonalStakePO> personalStakePOList = personalStakePORepository.findAllByMemberId(memberId,
                new PageRequest(0, 1, new Sort(Sort.Direction.DESC, new String[]{"id"})));
        if (CollectionUtils.isNotEmpty(personalStakePOList) && personalStakePOList.size() == 1) {
            nonce = personalStakePOList.get(0).getNonce() + 1;
        }


        // NOTE: 保存数据
        PersonalStakePO personalStakePO = new PersonalStakePO();
        personalStakePO.setMemberId(memberId);
        personalStakePO.setFundType(FundTypeEnums.FO);
        personalStakePO.setAmt(rollerBean.getAmt());
        personalStakePO.setStakeId(RandomUtil.randomStake());
        personalStakePO.setEffective(EffectiveEnums.INIT);
        personalStakePO.setTarget(rollerBean.getTarget());
        personalStakePO.setTargetCondition(rollerBean.getTargetCondition());
        personalStakePO.setNonce(nonce);
        personalStakePO.setCreateTime(now);
        personalStakePO.setUpdateTime(now);
        personalStakePO = personalStakePORepository.save(personalStakePO);

        // TODO: 智能合约执行
        DiceHmacBean diceHmacBean = execute(new DiceHmacBean(personalStakePO.getStakeId(), rollerBean, false));

        // NOTE:保存账单数据
        if(diceHmacBean.isWin()) personalStakePO.setFundType(FundTypeEnums.FI);
        personalStakePO.setEffective(EffectiveEnums.TRUE);
        personalStakePORepository.save(personalStakePO);

        return personalStakePO;
    }

    // NOTE: 色子随机数
    private DiceHmacBean execute(DiceHmacBean diceHmacBean){
        log.info("execute 色子随机数{}", diceHmacBean);

        // NOTE: 查询押注原始数据
        PersonalStakePO personalStakePO = personalStakePORepository.findByStakeId(diceHmacBean.getStakeId());
        if (personalStakePO == null) {
            throw CommonDefinedException.SYSTEM_ERROR("找不到押注数据");
        }

        // NOTE: 查询会员
        PersonalMemberPO personalMemberPO = personalMemberPORepository.findByMemberId(personalStakePO.getMemberId());
        if (personalMemberPO == null) {
            throw CommonDefinedException.SYSTEM_ERROR("找不到会员数据");
        }

        // NOTE: 查询种子
        PersonalSeedPO personalSeedPO = personalSeedPORepository.findByMemberIdAndDefaultUse(personalMemberPO.getMemberId(), 1);
        if (personalSeedPO == null) {
            throw CommonDefinedException.SYSTEM_ERROR("找不到种子数据");
        }

        // NOTE: 产生随机数
        double result = DiceHmacStrategy.hmacStrategy(personalSeedPO.getServerSeed(), personalSeedPO.getClientSeed(), String.valueOf(personalStakePO.getNonce()));
        log.info("execute 色子随机数, result:{}", result);

        RollerBean rollerBean = diceHmacBean.getRollerBean();
        if (rollerBean.getTargetCondition() == 1 && result >= diceHmacBean.getRollerBean().getTarget().doubleValue()) {
            log.info("execute 色子随机数[WIN], memberAccount:{}, targetCondition:{}, result:{}, [>=] target:{} ",
                    personalMemberPO.getMemberAccount(), rollerBean.getTargetCondition(),result,  diceHmacBean.getRollerBean().getTarget().doubleValue());
            diceHmacBean.setWin(true);
        } else if(rollerBean.getTargetCondition() == 0 && result <= diceHmacBean.getRollerBean().getTarget().doubleValue()){
            log.info("execute 色子随机数[WIN], memberAccount:{}, targetCondition:{}, result:{}, [<=] target:{} ",
                    personalMemberPO.getMemberAccount(), rollerBean.getTargetCondition(),result,  diceHmacBean.getRollerBean().getTarget().doubleValue());
            diceHmacBean.setWin(true);
        } else {
            log.info("execute 色子随机数[LOSE], memberAccount:{}, targetCondition:{}, result:{}, [*] target:{} ",
                    personalMemberPO.getMemberAccount(), rollerBean.getTargetCondition(),result,  diceHmacBean.getRollerBean().getTarget().doubleValue());
            diceHmacBean.setWin(false);
        }

        // NOTE: 异步更新押注数据
        updateState(personalMemberPO, personalStakePO, diceHmacBean);

        return diceHmacBean;
    }


    // NOTE: 异步更新押注数据
    @Async
    public Future<String> updateState(PersonalMemberPO personalMemberPO, PersonalStakePO personalStakePO, DiceHmacBean diceHmacBean) {

        // FIXME: 更新账户余额

        // NOTE: 保存账单-交易类型R-充值,W-提现,FI-收入,FO-支出
        PersonalBillPO personalBillPO = new PersonalBillPO();
        personalBillPO.setMemberId(personalMemberPO.getMemberId());
        personalBillPO.setBitAddress("");
        personalBillPO.setSeqNo(RandomUtil.randomPaymentSeq());
        personalBillPO.setStakeId(personalStakePO.getStakeId());
        personalBillPO.setStakeStatus("1");
        personalBillPO.setTradeAmt(diceHmacBean.getRollerBean().getAmt());
        personalBillPO.setTradeTitle("押注");
        personalBillPO.setTradeType(diceHmacBean.isWin()? TradeTypeEnums.FI : TradeTypeEnums.FO);
        personalBillPO.setUpdateTime(now);
        personalBillPO.setCreateTime(now);
        personalBillPORepository.save(personalBillPO);

        return new AsyncResult<>("更新成功");
    }


}

package com.dicero.diceroller.service.play;

import com.dicero.diceroller.domain.model.PersonalSeedTmpPO;
import com.dicero.diceroller.domain.model.PersonalStakePO;
import com.dicero.diceroller.service.bean.RollerBean;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/10/29
 */
public interface PlayService {


    String createClientSeed();

    String createServerSeed();

    // NOTE: 创建临时种子
    PersonalSeedTmpPO createPersonalSeedTmp(Integer memberId);

    // NOTE: 根据临时种子，更新用户新种子
    boolean updatePersonalSeedByTmp(Integer memberId, String clientSeed);

    // NOTE: 扔色子-true: 胜利, false-失败
    PersonalStakePO roller(Integer memberId, RollerBean rollerBean);



}

package com.dicero.diceroller.service.play;

import com.dicero.diceroller.domain.model.PersonalSeedTmpPO;
import com.dicero.diceroller.service.bean.RollerBean;
import com.dicero.diceroller.service.bean.MakeResult;

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
    boolean updatePersonalSeedByTmp(Integer newSeedId, Integer memberId, String clientSeed);

    // NOTE: 扔色子-true: 胜利, false-失败
    MakeResult roller(Integer memberId, String username, RollerBean rollerBean);



}

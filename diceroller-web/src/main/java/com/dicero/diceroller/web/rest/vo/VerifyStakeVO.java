package com.dicero.diceroller.web.rest.vo;

import lombok.Data;
import lombok.ToString;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/12/6
 */
@Data
@ToString
public class VerifyStakeVO extends StakeVO {
    private String serverSeedHashEd;
    private String clientSeedEd;
}

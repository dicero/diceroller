package com.dicero.diceroller.web.rest.vo;

import lombok.Data;
import lombok.ToString;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/26
 */
@Data
@ToString
public class MemberSeedVO {
    private String serverSeed;
    private String clientSeed;
    private String serverSeedHash;
    private int defaultUse;
    private int sumNonce;
}

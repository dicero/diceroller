package com.dicero.diceroller.web.rest.vo;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/25
 */
@Data
@ToString
public class MemberTokenVO implements Serializable {
    private String username;
    private String token;
}

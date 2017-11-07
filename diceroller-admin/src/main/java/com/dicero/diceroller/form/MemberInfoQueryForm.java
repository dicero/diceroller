package com.dicero.diceroller.form;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/7
 */
@Data
@ToString
public class MemberInfoQueryForm implements Serializable {
    @Size(min=1, max=40, message="长度不能小于1大于40")
    private String memberValue;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private QueryMemberType queryMemberType;

    public static enum  QueryMemberType {
        MEMBER_ID("会员编号"),
        PHONE("手机号码"),
        EMAIL("电子邮箱");

        private String desc;

        QueryMemberType(String desc) {
            this.desc = desc;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    }

}


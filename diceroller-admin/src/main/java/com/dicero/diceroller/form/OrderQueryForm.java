package com.dicero.diceroller.form;

import com.dicero.diceroller.domain.enums.NoTypeEnums;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/6
 */
public class OrderQueryForm implements Serializable {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private NoTypeEnums noTypeEnums;


    @Size(min=1, max=40, message="长度不能小于1大于40")
    private String no;


    public NoTypeEnums getNoTypeEnums() {
        return noTypeEnums;
    }

    public void setNoTypeEnums(NoTypeEnums noTypeEnums) {
        this.noTypeEnums = noTypeEnums;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "OrderQueryForm{" +
                "noTypeEnums=" + noTypeEnums +
                ", no='" + no + '\'' +
                '}';
    }
}

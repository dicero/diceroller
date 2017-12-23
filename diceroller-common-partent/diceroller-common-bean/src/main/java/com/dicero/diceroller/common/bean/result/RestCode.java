package com.dicero.diceroller.common.bean.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * <p></p>
 *
 * @author znz
 * @version 2017/11/25
 */
public abstract class RestCode {

    // NOTE: 成功
    public static CodeMessage SUCCESS = new CodeMessage(100,"成功");

    // NOTE: 用户名已存在
    public static CodeMessage USER_NAME_EXIST = new CodeMessage(101,"用户名已存在");

    // NOTE: 用户未登录
    public static CodeMessage USER_NOT_LOGIN = new CodeMessage(102,"用户未登录");

    // NOTE: 重复的请求
    public static CodeMessage DUPLICATE_REQUEST_NO = new CodeMessage(103,"重复的请求");

    // NOTE: 数据不存在
    public static CodeMessage DATA_NOT_EXIST = new CodeMessage(104,"数据不存在");

    // NOTE: 等待上一次的结果，才能继续
    public static CodeMessage PLAY_WALT = new CodeMessage(105,"等待上一次的结果，才能继续");

    // NOTE: 请求参数校检不通过
    public static CodeMessage PARAMES_ERROR = new CodeMessage(198,"请求参数校检不通过");

    // NOTE: 失败
    public static CodeMessage FAILED = new CodeMessage(199,"失败");

    // NOTE: 异常
    public static CodeMessage EXCEPTION = new CodeMessage(999,"异常");

    @Data
    @ToString
    @AllArgsConstructor
    public static class CodeMessage{
        private int code;
        private String msg;
    }

}

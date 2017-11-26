package com.dicero.diceroller.common.bean.result;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.HashMap;

/**   
* <p></p>
* @author zengningzong
*/
@Data
@ToString
public class RestResponse implements Serializable {
	private static final long serialVersionUID = -1003365387489106147L;
	
	private int code;
	private String  msg;
	private String  subMsg;
	private Object  data;
	
	/**
	 * 
	 * <p>成功</p>
	 * @param data
	 * @return
	 */
	public static RestResponse createSuccess(Object data) {
		RestResponse bean = new RestResponse();
		bean.data = data;
        bean.msg = RestCode.SUCCESS.getMsg();
        bean.subMsg = RestCode.SUCCESS.getMsg();
        bean.code = RestCode.SUCCESS.getCode();
        return bean;
	}


    /**
     *
     * <p>成功</p>
     * @return
     */
    public static RestResponse createSuccess() {
        RestResponse bean = new RestResponse();
        bean.data = new HashMap<>();
        bean.msg = RestCode.SUCCESS.getMsg();
        bean.subMsg = "成功";
        bean.code = RestCode.SUCCESS.getCode();
        return bean;
    }





    /**
     *
     * <p>错误</p>
     * @return
     */
    public static RestResponse createFailure(RestCode.CodeMessage codeMessage) {
        RestResponse bean = new RestResponse();
        bean.data = new HashMap<>();
        bean.msg = codeMessage.getMsg();
        bean.subMsg = "";
        bean.code = codeMessage.getCode();
        return bean;
    }
	

    /**
     *
     * <p>错误</p>
     * @return
     */
    public static RestResponse createFailure() {
        RestResponse bean = new RestResponse();
        bean.data = new HashMap<>();
        bean.msg = RestCode.FAILED.getMsg();
        bean.subMsg = "";
        bean.code = RestCode.FAILED.getCode();
        return bean;
    }


    /**
     *
     * <p>错误</p>
     * @return
     */
    public static RestResponse createFailure(RestCode.CodeMessage codeMessage, String subMsg) {
        RestResponse bean = new RestResponse();
        bean.data = new HashMap<>();
        bean.msg = codeMessage.getMsg();
        bean.subMsg = subMsg;
        bean.code = codeMessage.getCode();
        return bean;
    }

}

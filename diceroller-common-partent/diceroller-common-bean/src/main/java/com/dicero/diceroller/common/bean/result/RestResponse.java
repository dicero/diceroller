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
	
	private boolean status;
	private String  msg;
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
		bean.msg = "服务器成功";
		bean.status = true;
		return bean;
	}

	/**
	 *
	 * <p>成功</p>
	 * @param msg
	 * @param data
	 * @return
	 */
	public static RestResponse createSuccess(String msg, Object data) {
		RestResponse bean = new RestResponse();
		bean.data = data;
		bean.msg = msg;
		bean.status = true;
		return bean;
	}
	
	/**
	 * 
	 * <p>成功</p>
	 * @param msg
	 * @return
	 */
	public static RestResponse createSuccess(String msg) {
		RestResponse bean = new RestResponse();
		bean.data = new HashMap<>();
		bean.msg = msg;
		bean.status = true;
		return bean;
	}
	
	/**
	 * 
	 * <p>错误</p>
	 * @param data
	 * @return
	 */
	public static RestResponse createFailure(Object data) {
		RestResponse bean = new RestResponse();
		bean.data = data;
		bean.msg = "服务器错误";
		bean.status = false;
		return bean;
	}
	
	/**
	 * 
	 * <p>错误</p>
	 * @param msg
	 * @return
	 */
	public static RestResponse createFailure(String msg) {
		RestResponse bean = new RestResponse();
		bean.data = new HashMap<>();
		bean.msg = msg;
		bean.status = false;
		return bean;
	}


}

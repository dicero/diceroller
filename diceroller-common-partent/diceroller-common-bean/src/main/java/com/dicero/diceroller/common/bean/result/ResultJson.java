package com.dicero.diceroller.common.bean.result;

import java.util.Map;

/**   
* <p></p>
* @author ningzong.zeng
*/
public class ResultJson {
	private Map<String, Object> data;
	private Meta meta = new Meta();
	
	public static ResultJson createSuccess(){
		ResultJson success = new ResultJson();
		success.getMeta().message = "成功";
		success.getMeta().status = "T";
		return success;
	}
	
	/**
	 * <p>返回成功</p>
	 * @param data
	 * @return
	 */
	public static ResultJson createSuccess(Map<String, Object> data){
		ResultJson success = new ResultJson(data);
		success.data = data;
		success.getMeta().message = "成功";
		success.getMeta().status = "T";
		return success;
	}
	
	/**
	 * 
	 * <p>返回失败</p>
	 * @param errMessage 失败提示
	 * @param data
	 * @return
	 */
	public static ResultJson createFailed(String errMessage, Map<String, Object> data){
		ResultJson success = new ResultJson(data);
		success.data = data;
		success.getMeta().message = errMessage;
		success.getMeta().status = "F";
		return success;
	}
	
	/**
	 * 
	 * <p>返回失败</p>
	 * @param data
	 * @return
	 */
	public static ResultJson createFailed(Map<String, Object> data){
		ResultJson success = new ResultJson(data);
		success.getMeta().message = "失败";
		success.getMeta().status = "F";
		return success;
	}

	// 状态判断
	private static class Meta {
		private String status;
		private String message;
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
		@Override
		public String toString() {
			return "Meta [status=" + status + ", message=" + message + "]";
		} 
	}
	
	public ResultJson() { }
	
	public ResultJson(Map<String, Object> data) {
		this.data = data;
	}

	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	@Override
	public String toString() {
		return "ResultJson [data=" + data + ", meta=" + meta + "]";
	}

}

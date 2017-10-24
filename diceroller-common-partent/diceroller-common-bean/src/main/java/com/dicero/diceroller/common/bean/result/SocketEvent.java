package com.dicero.diceroller.common.bean.result;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**   
* <p></p>
* @author zengningzong
*/
public class SocketEvent implements Serializable {
	private static final long serialVersionUID = -2131342987102112263L;
	
	private String event;
	private UserInfo userInfo;
	private Object data;
	
	
	public static String joinSuccess() {
		SocketEvent socketEvent = new SocketEvent();
		HashMap<String, Object> data = new HashMap<>();
		data.put("joinStatus", true);
		socketEvent.setEvent(SocketEventEnum.JOIN);
		socketEvent.setData(data);
		return JSON.toJSONString(socketEvent);
	}
	
	public static String joinFailure() {
		SocketEvent socketEvent = new SocketEvent();
		Map<String, Object> data = new HashMap<>();
		data.put("joinStatus", false);
		socketEvent.setEvent(SocketEventEnum.JOIN);
		socketEvent.setData(data);
		return JSON.toJSONString(socketEvent);
	}
	
	public static String scan(Map<String, Object> data) {
		SocketEvent socketEvent = new SocketEvent();
		socketEvent.setEvent(SocketEventEnum.SCAN);
		socketEvent.setData(data);
		return JSON.toJSONString(socketEvent);
	}
	
	public static String error(String msg) {
		Map<String, Object> data = new HashMap<>();
		data.put("msg", msg);
		SocketEvent socketEvent = new SocketEvent();
		socketEvent.setEvent(SocketEventEnum.ERROR);
		socketEvent.setData(data);
		return JSON.toJSONString(socketEvent);
	}
	
	public boolean validate(){
		if(StringUtils.isBlank(this.getEvent())) {
			return false;
		}
		
		if(this.getUserInfo().getX() == null) {
			return false;
		}
		
		if(this.getUserInfo().getY() == null) {
			return false;
		}
		
		return true;
	}
	
	public String getEvent() {
		return event;
	}
	public void setEvent(String event) {
		this.event = event;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}

	public static class UserInfo {
		private Long id;
		private String nickname;
		private Integer x;
		private Integer y;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getNickname() {
			return nickname;
		}
		public void setNickname(String nickname) {
			this.nickname = nickname;
		}
		public Integer getX() {
			return x;
		}
		public void setX(Integer x) {
			this.x = x;
		}
		public Integer getY() {
			return y;
		}
		public void setY(Integer y) {
			this.y = y;
		}
		@Override
		public String toString() {
			return "UserInfo [id=" + id + ", nickname=" + nickname + ", x=" + x + ", y=" + y + "]";
		}
		
	}

	@Override
	public String toString() {
		return "SocketEvent [event=" + event + ", userInfo=" + userInfo + ", data=" + data + "]";
	}
	
}

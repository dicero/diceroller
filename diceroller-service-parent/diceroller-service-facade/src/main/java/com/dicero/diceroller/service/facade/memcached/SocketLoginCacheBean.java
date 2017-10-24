package com.dicero.diceroller.service.facade.memcached;
/**   
* <p></p>
* @author zengningzong
*/
public class SocketLoginCacheBean extends CacheBean {
	public static final String SOCKET_LOGIN_ = "SOCKET_LOGIN_" + KEY;
	
	@Override
	public Object getCache(String key) {
		return super.getCache(SOCKET_LOGIN_ +key);
	}
	
	@Override
	public void setCache(String key, Object value) {
		super.setCache(SOCKET_LOGIN_ + key, value);
	}
	
	@Override
	public void clearCache(String key) {
		super.clearCache(SOCKET_LOGIN_ +key);
	}
	
	@Override
	public boolean containsKey(String key) {
		return super.containsKey(SOCKET_LOGIN_ + key);
	}
}

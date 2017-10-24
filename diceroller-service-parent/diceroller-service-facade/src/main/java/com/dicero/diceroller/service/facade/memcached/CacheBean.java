package com.dicero.diceroller.service.facade.memcached;

import java.util.concurrent.ConcurrentHashMap;

/**   
* <p></p>
* @author zengningzong
*/
public abstract class CacheBean {
	public static final String KEY = "KEY";
	private ConcurrentHashMap<String, Object> maps = new ConcurrentHashMap<>();
	
	public Object getCache(String key) {
		if(maps.containsKey(key)) {
			return maps.get(key);
		} else {
			return null;
		}
	}
	
	public void setCache(String key, Object value) {
		if(value != null) {
			maps.put(key, value);
		}
	}
	
	public void clearCache(String key) {
		maps.remove(key);
	}
	
	public boolean containsKey(String key) {
		return maps.containsKey(key);
	}
	
	public ConcurrentHashMap<String, Object> getMaps() {
		return maps;
	}

	public void setMaps(ConcurrentHashMap<String, Object> maps) {
		this.maps = maps;
	}
	
	public static String getKey(String allKey) {
		return allKey.split(KEY)[1];
	}

}

package com.dicero.diceroller.service.facade.memcached;

/**   
* <p></p>
* @author zengningzong
*/
public class MemcachedManager {
	
	/** 区域留言缓存*/
	public static LocageListCacheBean LOCAGE_LISY_CACHE = new LocageListCacheBean();
	
	/** 单点留言缓存*/
	public static CacheBean LOCAGE_ITEM_CACHE = new LocageItemCacheBean();
	
	/** socket 登录缓存*/
	public static SocketLoginCacheBean SOCKET_LOGIN_CACHE = new SocketLoginCacheBean();
	
	public static boolean clearLocageCache(String key) {
		try {
			if(LOCAGE_ITEM_CACHE.containsKey(key)) {
				LOCAGE_ITEM_CACHE.clearCache(key);
				LOCAGE_LISY_CACHE.clearCache(key);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
}

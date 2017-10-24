package com.dicero.diceroller.service.facade.memcached;

/**   
* <p></p>
* @author zengningzong
*/
public class LocageItemCacheBean extends CacheBean {
	
	public static final String LOCAGE_ITEM_ = "LOCAGE_ITEM_" + KEY;
	
	@Override
	public Object getCache(String key) {
		return super.getCache(LOCAGE_ITEM_ +key);
	}
	
	@Override
	public void setCache(String key, Object value) {
		super.setCache(LOCAGE_ITEM_ + key, value);
	}
	
	@Override
	public void clearCache(String key) {
		super.clearCache(LOCAGE_ITEM_ +key);
	}
	
	@Override
	public boolean containsKey(String key) {
		return super.containsKey(LOCAGE_ITEM_ + key);
	}
	
}

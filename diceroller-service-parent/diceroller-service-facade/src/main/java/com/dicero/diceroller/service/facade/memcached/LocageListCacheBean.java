package com.dicero.diceroller.service.facade.memcached;
/**   
* <p></p>
* @author zengningzong
*/
public class LocageListCacheBean extends CacheBean {
	public static final String LOCAGE_LIST_ = "LOCAGE_LIST_" + KEY;
	
	@Override
	public Object getCache(String key) {
		return super.getCache(LOCAGE_LIST_ +key);
	}
	
	@Override
	public void setCache(String key, Object value) {
		super.setCache(LOCAGE_LIST_ + key, value);
	}
	
	@Override
	public void clearCache(String key) {
		super.clearCache(LOCAGE_LIST_ +key);
	}
	
	@Override
	public boolean containsKey(String key) {
		return super.containsKey(LOCAGE_LIST_ + key);
	}
	
}
package com.dicero.diceroller.common.bean.result;
/**   
* <p></p>
* @author zengningzong
*/
public abstract interface SocketEventEnum {
	
	/** 参加 */
	public static final String JOIN = "JOIN";
	
	/** 扫描 */
	public static final String SCAN = "SCAN";
	
	/** 推送 */
	public static final String PUSH = "PUSH";
	
	/** 错误 */
	public static final String ERROR = "ERROR";
}

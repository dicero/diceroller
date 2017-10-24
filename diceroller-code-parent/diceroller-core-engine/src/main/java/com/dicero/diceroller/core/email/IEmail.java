package com.dicero.diceroller.core.email;
/**   
* <p>邮件发送</p>
* @author ningzong.zeng
*/
public interface IEmail {
	/**
	 * 
	 * <p>发送单个text内容的邮件</p>
	 * @param toEmail 接受的邮件
	 * @param subject 邮件主题
	 * @param text    邮件内容
	 */
	void sendText(String toEmail, String subject, String text);
}

package com.dicero.diceroller.domain.enums;

/**   
* <p></p>
* @author ningzong.zeng
*/
public enum AdminRole {
	SUPER_ADMIN("超级管理员", "text-danger"),
	ADMIN("普通管理员", "text-navy");
	
	String info;
	String textClass;
	AdminRole(String info, String textClass) {
		this.info = info;
		this.textClass = textClass;
	}
	public String getInfo() {
		return info;
	}
	public String getTextClass() {
		return textClass;
	}
	// .text-navy{color:#1ab394}.text-primary{color:inherit}.text-success{color:#1c84c6}.text-info{color:#23c6c8}.text-warning{color:#f8ac59}.text-danger{color:#ed5565}.text-muted{color:#888}
}

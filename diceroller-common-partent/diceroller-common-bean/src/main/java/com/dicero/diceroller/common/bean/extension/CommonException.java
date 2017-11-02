package com.dicero.diceroller.common.bean.extension;

/**
* <p></p>
* @author ningzong.zeng
*/
public class CommonException extends RuntimeException {
	
	private static final long serialVersionUID = 3716062206079635401L;
	
	private String message;

	public CommonException(String message) {
		super(message);
		setMessage(message);
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}

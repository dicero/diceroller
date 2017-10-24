package com.dicero.diceroller.access;

/**
 * 
* <p></p>
* @author ningzhong.zeng
*
 */
public class AdminLoginer {
	public static final String ADMIN_IN_REQUEST = "ADMIN";
	
	private Long id;
	private String loginUsername;
	private String nickName;
	private String role;
	
	public AdminLoginer(Long id, String loginUsername, String role, String nickName) {
		super();
		this.id = id;
		this.loginUsername = loginUsername;
		this.role = role;
		this.nickName = nickName;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginUsername() {
		return loginUsername;
	}
	public void setLoginUsername(String loginUsername) {
		this.loginUsername = loginUsername;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	@Override
	public String toString() {
		return "AdminLoginer [id=" + id + ", loginUsername=" + loginUsername + ", nickName=" + nickName + ", role="
				+ role + "]";
	}
}

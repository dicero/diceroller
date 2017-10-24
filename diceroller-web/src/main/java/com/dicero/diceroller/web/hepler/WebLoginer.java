package com.dicero.diceroller.web.hepler;

/**
 * 
* <p></p>
* @author ningzhong.zeng
*
 */
public class WebLoginer {
	public static final String WEB_IN_REQUEST = "WEB";
	
	private Long id;
	private String username;
	public WebLoginer() { }
	public WebLoginer(Long id, String username) {
		this.id = id;
		this.username = username;
	}
	
//	public User toUser() {
//		User user = new User();
//		user.setId(id);
//		user.setUsername(username);
//		return user;
//	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "WebLoginer [id=" + id + ", username=" + username + "]";
	}
	
}

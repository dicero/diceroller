package com.dicero.diceroller.domain.model;

import com.dicero.diceroller.domain.BasePO;
import com.dicero.diceroller.domain.enums.AdminRole;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;

/**   
* <p></p>
* @author ningzong.zeng
*/
@Entity
@Table(name="user_platform")
public class UserPlatformPO extends BasePO {
	private static final long serialVersionUID = 1344107240473958021L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false)
	@Size(min=1, max=10, message="长度不能小于1大于10")
	private String loginUsername;
	
	@Column(nullable = false)
	@Size(min=1, max=200, message="长度不能小于1大于200")
	private String loginPassword;
	
	@Column(nullable = false)
    @Size(min=1, max=10, message="长度不能小于1大于10")
    private String nickName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
	private AdminRole role;
	
	@Column(nullable = false)
	private Date gmtCreate;
	
	@Column(nullable = false)
	private Date gmtMotify;
	
	public UserPlatformPO() {}
	public UserPlatformPO(Long id) { this.id = id; }
	
	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtMotify() {
		return gmtMotify;
	}

	public void setGmtMotify(Date gmtMotify) {
		this.gmtMotify = gmtMotify;
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

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public AdminRole getRole() {
		return role;
	}

	public void setRole(AdminRole role) {
		this.role = role;
	}
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}

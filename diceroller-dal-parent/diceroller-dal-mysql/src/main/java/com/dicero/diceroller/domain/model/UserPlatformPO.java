package com.dicero.diceroller.domain.model;

import com.dicero.diceroller.domain.BasePO;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * <p></p>
 *
 * @author znz zengningzhong@souche.com
 * @version 2017/10/29
 */
@Entity
@Table(name = "user_platform")
public class UserPlatformPO extends BasePO {
    private long id;
    private String loginUsername;
    private String loginPassword;
    private String nickName;
    private String role;
    private Timestamp gmtCreate;
    private Timestamp gmtMotify;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "login_username", nullable = true, length = 50)
    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    @Basic
    @Column(name = "login_password", nullable = true, length = 50)
    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Basic
    @Column(name = "nick_name", nullable = true, length = 50)
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "role", nullable = true, length = 11)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "gmt_create", nullable = true)
    public Timestamp getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Timestamp gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    @Basic
    @Column(name = "gmt_motify", nullable = true)
    public Timestamp getGmtMotify() {
        return gmtMotify;
    }

    public void setGmtMotify(Timestamp gmtMotify) {
        this.gmtMotify = gmtMotify;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPlatformPO that = (UserPlatformPO) o;

        if (id != that.id) return false;
        if (loginUsername != null ? !loginUsername.equals(that.loginUsername) : that.loginUsername != null)
            return false;
        if (loginPassword != null ? !loginPassword.equals(that.loginPassword) : that.loginPassword != null)
            return false;
        if (nickName != null ? !nickName.equals(that.nickName) : that.nickName != null) return false;
        if (role != null ? !role.equals(that.role) : that.role != null) return false;
        if (gmtCreate != null ? !gmtCreate.equals(that.gmtCreate) : that.gmtCreate != null) return false;
        if (gmtMotify != null ? !gmtMotify.equals(that.gmtMotify) : that.gmtMotify != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (loginUsername != null ? loginUsername.hashCode() : 0);
        result = 31 * result + (loginPassword != null ? loginPassword.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (role != null ? role.hashCode() : 0);
        result = 31 * result + (gmtCreate != null ? gmtCreate.hashCode() : 0);
        result = 31 * result + (gmtMotify != null ? gmtMotify.hashCode() : 0);
        return result;
    }
}

package com.adms.auth.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.adms.common.domain.BaseAuditDomain;

@Entity
@Table(name="AUTH.dbo.[USER]")
public class User extends BaseAuditDomain {

	private static final long serialVersionUID = 7221611703511823519L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="USERNAME", nullable=false, unique=true)
	private String username;
	
	@Column(name="PWD")
	private String pwd;
	
	@Column(name="LAST_PWD")
	private String lastPwd;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="LAST_LOGIN")
	@Temporal(TemporalType.TIMESTAMP)
	private Date lastLogin;
	
	@Column(name="PWD_EXPIRE_DATE")
	@Temporal(TemporalType.DATE)
	private Date pwdExpireDate;
	
	@Column(name="FORCE_CHANGE_PWD")
	private String forceChangePwd;
	
	@Column(name="FAIL_ATTEMP")
	private Integer failAttemp;
	
	@Column(name="ACTIVE")
	private String active;
	
	@OneToMany(mappedBy="user")
	private List<UserRole> userRoles;

	public User() {
		
	}
	
	public User(String username) {
		this.username = username;
	}
	
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

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getLastPwd() {
		return lastPwd;
	}

	public void setLastPwd(String lastPwd) {
		this.lastPwd = lastPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}

	public Date getPwdExpireDate() {
		return pwdExpireDate;
	}

	public void setPwdExpireDate(Date pwdExpireDate) {
		this.pwdExpireDate = pwdExpireDate;
	}

	public String getForceChangePwd() {
		return forceChangePwd;
	}

	public void setForceChangePwd(String forceChangePwd) {
		this.forceChangePwd = forceChangePwd;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Integer getFailAttemp() {
		return failAttemp;
	}

	public void setFailAttemp(Integer failAttemp) {
		this.failAttemp = failAttemp;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
}

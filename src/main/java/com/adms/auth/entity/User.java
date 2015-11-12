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

	public User setId(Long id) {
		this.id = id;
		return this;
	}

	public String getUsername() {
		return username;
	}

	public User setUsername(String username) {
		this.username = username;
		return this;
	}

	public String getPwd() {
		return pwd;
	}

	public User setPwd(String pwd) {
		this.pwd = pwd;
		return this;
	}

	public String getLastPwd() {
		return lastPwd;
	}

	public User setLastPwd(String lastPwd) {
		this.lastPwd = lastPwd;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public User setEmail(String email) {
		this.email = email;
		return this;
	}

	public Date getLastLogin() {
		return lastLogin;
	}

	public User setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
		return this;
	}

	public Date getPwdExpireDate() {
		return pwdExpireDate;
	}

	public User setPwdExpireDate(Date pwdExpireDate) {
		this.pwdExpireDate = pwdExpireDate;
		return this;
	}

	public String getForceChangePwd() {
		return forceChangePwd;
	}

	public User setForceChangePwd(String forceChangePwd) {
		this.forceChangePwd = forceChangePwd;
		return this;
	}

	public String getActive() {
		return active;
	}

	public User setActive(String active) {
		this.active = active;
		return this;
	}

	public Integer getFailAttemp() {
		return failAttemp;
	}

	public User setFailAttemp(Integer failAttemp) {
		this.failAttemp = failAttemp;
		return this;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public User setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
		return this;
	}
}

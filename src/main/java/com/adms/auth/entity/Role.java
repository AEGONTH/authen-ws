package com.adms.auth.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.adms.common.domain.BaseDomain;

@Entity
@Table(name="AUTH.dbo.[ROLE]")
public class Role extends BaseDomain {
	
	private static final long serialVersionUID = 1987180087596027194L;

	@Id
	@Column(name="ID")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="ROLE_CODE", nullable=false, unique=true)
	private String roleCode;
	
	@Column(name="ROLE_NAME")
	private String roleName;
	
	public Role() {
		
	}

	public Role(String roleCode, String roleName) {
		this.roleCode = roleCode;
		this.roleName = roleName;
	}
	
	public Role(Long id, String roleCode, String roleName) {
		this(roleCode, roleName);
		this.id = id;
	}

	public Role id(Long id) {
		this.id = id;
		return this;
	}

	public Role roleCode(String roleCode) {
		this.roleCode = roleCode;
		return this;
	}

	public Role roleName(String roleName) {
		this.roleName = roleName;
		return this;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}

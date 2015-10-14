package com.adms.auth.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.adms.auth.entity.RolePrivilege;

public interface RolePrivilegeService {

	public RolePrivilege add(RolePrivilege example, String rolePrivilegeLogin) throws Exception;

	public RolePrivilege update(RolePrivilege example, String rolePrivilegeLogin) throws Exception;

	public List<RolePrivilege> findAll() throws Exception;
	
	public RolePrivilege find(Long id) throws Exception;
	
	public List<RolePrivilege> find(RolePrivilege example) throws Exception;

	public List<RolePrivilege> findByHql(String hql, Object...vals) throws Exception;

	public List<RolePrivilege> findByNamedQuery(String namedQuery, Object...vals) throws Exception;

	public List<RolePrivilege> findByCriteria(DetachedCriteria detachedCriteria) throws Exception;

}

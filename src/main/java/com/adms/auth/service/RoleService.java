package com.adms.auth.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.adms.auth.entity.Role;

public interface RoleService {

	public Role add(Role example, String userLogin) throws Exception;

	public Role update(Role example, String userLogin) throws Exception;

	public List<Role> findAll() throws Exception;
	
	public Role find(Long id) throws Exception;
	
	public List<Role> find(Role example) throws Exception;

	public List<Role> findByHql(String hql, Object...vals) throws Exception;

	public List<Role> findByNamedQuery(String namedQuery, Object...vals) throws Exception;

	public List<Role> findByCriteria(DetachedCriteria detachedCriteria) throws Exception;

}

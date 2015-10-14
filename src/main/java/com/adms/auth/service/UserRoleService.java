package com.adms.auth.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.adms.auth.entity.UserRole;

public interface UserRoleService {

	public UserRole add(UserRole example, String userLogin) throws Exception;

	public UserRole update(UserRole example, String userLogin) throws Exception;

	public List<UserRole> findAll() throws Exception;
	
	public UserRole find(Long id) throws Exception;
	
	public List<UserRole> find(UserRole example) throws Exception;

	public List<UserRole> findByHql(String hql, Object...vals) throws Exception;

	public List<UserRole> findByNamedQuery(String namedQuery, Object...vals) throws Exception;

	public List<UserRole> findByCriteria(DetachedCriteria detachedCriteria) throws Exception;

}

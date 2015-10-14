package com.adms.auth.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.adms.auth.entity.User;

public interface UserService {

	public User add(User example, String userLogin) throws Exception;

	public User update(User example, String userLogin) throws Exception;

	public List<User> findAll() throws Exception;
	
	public User find(Long id) throws Exception;
	
	public List<User> find(User example) throws Exception;

	public List<User> findByHql(String hql, Object...vals) throws Exception;

	public List<User> findByNamedQuery(String namedQuery, Object...vals) throws Exception;

	public List<User> findByCriteria(DetachedCriteria detachedCriteria) throws Exception;

}

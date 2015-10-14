package com.adms.auth.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adms.auth.dao.UserRoleDao;
import com.adms.auth.entity.UserRole;
import com.adms.auth.service.UserRoleService;

@Service("userRoleService")
@Transactional
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleDao userRoleDao;
	
	public UserRoleServiceImpl() {
		
	}

	public void setUserRoleDao(UserRoleDao userRoleDao) {
		this.userRoleDao = userRoleDao;
	}
	
	@Override
	public List<UserRole> findAll() throws Exception {
		return userRoleDao.findAll();
	}

	@Override
	public UserRole add(UserRole example, String userRoleLogin) throws Exception {
		return userRoleDao.save(example);
	}
	
	@Override
	public UserRole update(UserRole example, String userRoleLogin) throws Exception {
		return userRoleDao.save(example);
	}

	@Override
	public UserRole find(Long id) throws Exception {
		return userRoleDao.find(id);
	}
	
	@Override
	public List<UserRole> find(UserRole example) throws Exception {
		return userRoleDao.find(example);
	}
	
	@Override
	public List<UserRole> findByHql(String hql, Object...vals) throws Exception {
		return userRoleDao.findByHQL(hql, vals);
	}

	@Override
	public List<UserRole> findByNamedQuery(String namedQuery, Object...vals) throws Exception {
		return userRoleDao.findByNamedQuery(namedQuery, vals);
	}
	
	@Override
	public List<UserRole> findByCriteria(DetachedCriteria detachedCriteria) throws Exception {
		return userRoleDao.findByCriteria(detachedCriteria);
	}
	
}

package com.adms.auth.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adms.auth.dao.UserDao;
import com.adms.auth.entity.User;
import com.adms.auth.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public UserServiceImpl() {
		
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	@Override
	public List<User> findAll() throws Exception {
		return userDao.findAll();
	}

	@Override
	public User add(User example, String userLogin) throws Exception {
		return userDao.save(example);
	}
	
	@Override
	public User update(User example, String userLogin) throws Exception {
		return userDao.save(example);
	}

	@Override
	public User find(Long id) throws Exception {
		return userDao.find(id);
	}
	
	@Override
	public List<User> find(User example) throws Exception {
		return userDao.find(example);
	}
	
	@Override
	public List<User> findByHql(String hql, Object...vals) throws Exception {
		return userDao.findByHQL(hql, vals);
	}

	@Override
	public List<User> findByNamedQuery(String namedQuery, Object...vals) throws Exception {
		return userDao.findByNamedQuery(namedQuery, vals);
	}
	
	@Override
	public List<User> findByCriteria(DetachedCriteria detachedCriteria) throws Exception {
		return userDao.findByCriteria(detachedCriteria);
	}
	
}

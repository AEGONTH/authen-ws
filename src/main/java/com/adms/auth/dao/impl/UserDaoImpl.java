package com.adms.auth.dao.impl;

import org.springframework.stereotype.Repository;

import com.adms.auth.dao.UserDao;
import com.adms.auth.entity.User;
import com.adms.common.dao.generic.impl.GenericDaoHibernate;

@Repository("userDao")
public class UserDaoImpl extends GenericDaoHibernate<User, Long> implements UserDao {
	
	public UserDaoImpl() {
		super(User.class);
	}
}

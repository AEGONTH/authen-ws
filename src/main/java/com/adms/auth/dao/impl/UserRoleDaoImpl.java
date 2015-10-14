package com.adms.auth.dao.impl;

import org.springframework.stereotype.Repository;

import com.adms.auth.dao.UserRoleDao;
import com.adms.auth.entity.UserRole;
import com.adms.common.dao.generic.impl.GenericDaoHibernate;

@Repository("userRoleDao")
public class UserRoleDaoImpl extends GenericDaoHibernate<UserRole, Long> implements UserRoleDao {
	
	public UserRoleDaoImpl() {
		super(UserRole.class);
	}
}

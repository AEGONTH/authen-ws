package com.adms.auth.dao.impl;

import org.springframework.stereotype.Repository;

import com.adms.auth.dao.RoleDao;
import com.adms.auth.entity.Role;
import com.adms.common.dao.generic.impl.GenericDaoHibernate;

@Repository("roleDao")
public class RoleDaoImpl extends GenericDaoHibernate<Role, Long> implements RoleDao {
	
	public RoleDaoImpl() {
		super(Role.class);
	}
}

package com.adms.auth.dao.impl;

import org.springframework.stereotype.Repository;

import com.adms.auth.dao.RolePrivilegeDao;
import com.adms.auth.entity.RolePrivilege;
import com.adms.common.dao.generic.impl.GenericDaoHibernate;

@Repository("rolePrivilegeDao")
public class RolePrivilegeDaoImpl extends GenericDaoHibernate<RolePrivilege, Long> implements RolePrivilegeDao {
	
	public RolePrivilegeDaoImpl() {
		super(RolePrivilege.class);
	}
}

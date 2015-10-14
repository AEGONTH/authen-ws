package com.adms.auth.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adms.auth.dao.RolePrivilegeDao;
import com.adms.auth.entity.RolePrivilege;
import com.adms.auth.service.RolePrivilegeService;

@Service("rolePrivilegeService")
@Transactional
public class RolePrivilegeServiceImpl implements RolePrivilegeService {

	@Autowired
	private RolePrivilegeDao rolePrivilegeDao;
	
	public RolePrivilegeServiceImpl() {
		
	}

	public void setRolePrivilegeDao(RolePrivilegeDao rolePrivilegeDao) {
		this.rolePrivilegeDao = rolePrivilegeDao;
	}
	
	@Override
	public List<RolePrivilege> findAll() throws Exception {
		return rolePrivilegeDao.findAll();
	}

	@Override
	public RolePrivilege add(RolePrivilege example, String rolePrivilegeLogin) throws Exception {
		return rolePrivilegeDao.save(example);
	}
	
	@Override
	public RolePrivilege update(RolePrivilege example, String rolePrivilegeLogin) throws Exception {
		return rolePrivilegeDao.save(example);
	}

	@Override
	public RolePrivilege find(Long id) throws Exception {
		return rolePrivilegeDao.find(id);
	}
	
	@Override
	public List<RolePrivilege> find(RolePrivilege example) throws Exception {
		return rolePrivilegeDao.find(example);
	}
	
	@Override
	public List<RolePrivilege> findByHql(String hql, Object...vals) throws Exception {
		return rolePrivilegeDao.findByHQL(hql, vals);
	}

	@Override
	public List<RolePrivilege> findByNamedQuery(String namedQuery, Object...vals) throws Exception {
		return rolePrivilegeDao.findByNamedQuery(namedQuery, vals);
	}
	
	@Override
	public List<RolePrivilege> findByCriteria(DetachedCriteria detachedCriteria) throws Exception {
		return rolePrivilegeDao.findByCriteria(detachedCriteria);
	}
	
}

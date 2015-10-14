package com.adms.auth.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.adms.auth.dao.RoleDao;
import com.adms.auth.entity.Role;
import com.adms.auth.service.RoleService;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;
	
	public RoleServiceImpl() {
		
	}

	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}
	
	@Override
	public List<Role> findAll() throws Exception {
		return roleDao.findAll();
	}

	@Override
	public Role add(Role example, String roleLogin) throws Exception {
		return roleDao.save(example);
	}
	
	@Override
	public Role update(Role example, String roleLogin) throws Exception {
		return roleDao.save(example);
	}

	@Override
	public Role find(Long id) throws Exception {
		return roleDao.find(id);
	}
	
	@Override
	public List<Role> find(Role example) throws Exception {
		return roleDao.find(example);
	}
	
	@Override
	public List<Role> findByHql(String hql, Object...vals) throws Exception {
		return roleDao.findByHQL(hql, vals);
	}

	@Override
	public List<Role> findByNamedQuery(String namedQuery, Object...vals) throws Exception {
		return roleDao.findByNamedQuery(namedQuery, vals);
	}
	
	@Override
	public List<Role> findByCriteria(DetachedCriteria detachedCriteria) throws Exception {
		return roleDao.findByCriteria(detachedCriteria);
	}
	
}

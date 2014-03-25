package com.thomas.myexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thomas.myexample.entity.Role;
import com.thomas.myexample.repository.BaseDao;
import com.thomas.myexample.repository.RoleDao;
import com.thomas.myexample.service.account.BaseService;

@Component
@Transactional
public class ManagmentService extends BaseService<Role, Long> {

	@Autowired
	private RoleDao roleDao;

	@Override
	public BaseDao<Role, Long> getDao() {
		return roleDao;
	}
	
	public Role findByRoleName(String roleName){
		return roleDao.findByRoleName(roleName);
	}
	
}

package it.pkg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import it.pkg.entity.Role;
import it.pkg.repository.BaseDao;
import it.pkg.repository.RoleDao;
import it.pkg.service.account.BaseService;

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

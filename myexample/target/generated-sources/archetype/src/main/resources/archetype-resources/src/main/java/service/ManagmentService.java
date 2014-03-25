#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ${package}.entity.Role;
import ${package}.repository.BaseDao;
import ${package}.repository.RoleDao;
import ${package}.service.account.BaseService;

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

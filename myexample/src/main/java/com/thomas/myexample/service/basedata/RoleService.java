package com.thomas.myexample.service.basedata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.thomas.myexample.entity.basedata.Role;
import com.thomas.myexample.repository.BaseDao;
import com.thomas.myexample.repository.basedata.RoleDao;

@Component
@Service
public class RoleService extends BaseService<Role, Long> {

	@Autowired
	RoleDao dao;

	@Override
	public BaseDao<Role, Long> getDao() {
		return dao;
	}

	public Role findByRoleName(String roleName) {
		List<Role> list = dao.findByRoleName(roleName);
		if ((list != null) && (list.size() > 0)) {
			return list.get(0);
		}
		return null;
	}

}

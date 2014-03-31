package com.thomas.myexample.repository.basedata;

import java.util.List;

import com.thomas.myexample.entity.basedata.Role;
import com.thomas.myexample.repository.BaseDao;

/**
 * @ClassName: RoleDao
 * @Description: 角色dao
 * @author XuTao
 * @date 2014-3-28 下午02:46:13
 * 
 */
public interface RoleDao extends BaseDao<Role, Long> {

	List<Role> findByRoleName(String roleName);
}

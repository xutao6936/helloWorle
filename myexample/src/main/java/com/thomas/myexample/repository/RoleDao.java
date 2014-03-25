package com.thomas.myexample.repository;

import com.thomas.myexample.entity.Role;

/** 
* @ClassName: RoleDao 
* @Description:  
* @author XuTao
* @date 2013-12-13 上午10:45:31 
*  
*/
public interface RoleDao extends BaseDao<Role,Long>{
	
	Role findByRoleName(String roleName);
	
	
}

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import ${package}.entity.Role;

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

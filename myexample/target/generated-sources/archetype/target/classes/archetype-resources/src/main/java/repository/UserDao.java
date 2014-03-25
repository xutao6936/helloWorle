#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import ${package}.entity.User;

/** 
* @ClassName: UserDao 
* @Description: user dao 使用spring data jpa的方式进行持久化逻辑 
* @author XuTao
* @date 2013-12-13 上午10:38:57 
*  
*/
public interface UserDao extends BaseDao<User,Long>{
	
	User findByLogName(String logName);

}

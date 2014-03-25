#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.repository;

import ${package}.entity.Authirity;

public interface AuthirityDao extends BaseDao<Authirity,Long>{
	
	
	Authirity findByAuthCode(String authCode);
	Authirity findByAuthName(String authName);
	
}

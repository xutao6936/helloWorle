#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

import ${package}.webservice.response.GetRoleResult;
import ${package}.webservice.response.GetUserResult;

@WebService(name="UserService",targetNamespace=WsConstants.NS)
public interface UserSoapService {
	
	
	GetRoleResult getRole(@WebParam(name="roleName")String roleName);
	
//	GetUserResult getUser(@WebParam(name="id") Long id);
}

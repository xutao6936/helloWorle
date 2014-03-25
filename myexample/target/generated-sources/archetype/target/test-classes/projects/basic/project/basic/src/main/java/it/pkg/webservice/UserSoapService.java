package it.pkg.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

import it.pkg.webservice.response.GetRoleResult;
import it.pkg.webservice.response.GetUserResult;

@WebService(name="UserService",targetNamespace=WsConstants.NS)
public interface UserSoapService {
	
	
	GetRoleResult getRole(@WebParam(name="roleName")String roleName);
	
//	GetUserResult getUser(@WebParam(name="id") Long id);
}

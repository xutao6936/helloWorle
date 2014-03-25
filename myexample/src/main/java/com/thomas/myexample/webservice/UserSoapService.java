package com.thomas.myexample.webservice;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.thomas.myexample.webservice.response.GetRoleResult;
import com.thomas.myexample.webservice.response.GetUserResult;

@WebService(name="UserService",targetNamespace=WsConstants.NS)
public interface UserSoapService {
	
	
	GetRoleResult getRole(@WebParam(name="roleName")String roleName);
	
//	GetUserResult getUser(@WebParam(name="id") Long id);
}

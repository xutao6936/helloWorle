package com.thomas.myexample.webservice;

import javax.jws.WebService;

import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springside.modules.mapper.BeanMapper;

import com.thomas.myexample.entity.basedata.Role;
import com.thomas.myexample.service.basedata.RoleService;
import com.thomas.myexample.webservice.response.GetRoleResult;
import com.thomas.myexample.webservice.response.WSResult;
import com.thomas.myexample.webservice.response.dto.RoleDto;

@WebService(serviceName = "UserService", endpointInterface = "com.thomas.myexample.webservice.UserSoapService", targetNamespace = WsConstants.NS)
public class UserSoapServiceImpl implements UserSoapService {

	private static Logger logger = LoggerFactory.getLogger(UserSoapServiceImpl.class);

	// @Autowired
	// private AccountService accountService;

	@Autowired
	private RoleService roleService;

	/*
	 * @Autowired
	 * private Validator validator;
	 */

	/*
	 * @Override
	 * public GetUserResult getUser(Long id) {
	 * GetUserResult result = new GetUserResult();
	 * Validate.notNull(id, "用户参数为空");
	 * User user = accountService.getEntity(id);
	 * result.setUser(user);
	 * return result;
	 * }
	 */

	@Override
	public GetRoleResult getRole(String roleName) {
		GetRoleResult result = new GetRoleResult();
		try {
			Validate.notNull(roleName, "角色名不能为空");
			Role role = roleService.findByRoleName(roleName);
			RoleDto dto = BeanMapper.map(role, RoleDto.class);
			result.setDto(dto);
		} catch (RuntimeException e) {
			return handleGeneralError(result, e);
		}
		return result;

	}

	private <T extends WSResult> T handleParameterError(T result, Exception e, String message) {
		logger.error(message, e.getMessage());
		result.setError(WSResult.PARAMETER_ERROR, message);
		return result;
	}

	private <T extends WSResult> T handleParameterError(T result, Exception e) {
		logger.error(e.getMessage());
		result.setError(WSResult.PARAMETER_ERROR, e.getMessage());
		return result;
	}

	private <T extends WSResult> T handleGeneralError(T result, Exception e) {
		logger.error(e.getMessage());
		result.setDefaultError();
		return result;
	}

}

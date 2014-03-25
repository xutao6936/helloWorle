#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.webservice;

import javax.jws.WebService;
import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springside.modules.beanvalidator.BeanValidators;
import org.springside.modules.mapper.BeanMapper;
import org.springside.modules.utils.Exceptions;

import ${package}.entity.Role;
import ${package}.entity.User;
import ${package}.service.ManagmentService;
import ${package}.service.account.AccountService;
import ${package}.webservice.response.GetRoleResult;
import ${package}.webservice.response.GetUserResult;
import ${package}.webservice.response.WSResult;
import ${package}.webservice.response.dto.RoleDto;

@WebService(serviceName = "UserService", endpointInterface="${package}.webservice.UserSoapService",  targetNamespace = WsConstants.NS)
public class UserSoapServiceImpl implements UserSoapService {
	
	private static Logger logger = LoggerFactory.getLogger(UserSoapServiceImpl.class);
	
//	@Autowired
//	private AccountService accountService;
	
	@Autowired
	private ManagmentService managmentService;
	/*@Autowired
	private Validator validator;*/

	/*@Override
	public GetUserResult getUser(Long id) {
		GetUserResult  result =  new GetUserResult();
		Validate.notNull(id, "用户参数为空");
		User user = accountService.getEntity(id);
		result.setUser(user);
		return result;
	}*/
	
	public GetRoleResult getRole(String roleName){
		GetRoleResult result = new GetRoleResult();
		try{
			Validate.notNull(roleName, "角色名不能为空");
			Role role = managmentService.findByRoleName(roleName);
			RoleDto dto = BeanMapper.map(role, RoleDto.class);
			result.setDto(dto);
		}  catch (RuntimeException e) {
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

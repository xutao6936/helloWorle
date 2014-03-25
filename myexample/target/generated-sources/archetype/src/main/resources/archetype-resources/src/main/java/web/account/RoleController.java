#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ${package}.entity.Role;
import ${package}.service.ManagmentService;
import ${package}.service.account.BaseService;
import ${package}.web.utils.UrlConstants;

@Controller
@RequestMapping(value="/role")
public class RoleController extends BaseController<Role,Long>{

	@Autowired
	private ManagmentService  service;
	
	@Override
	public BaseService<Role, Long> getService() {
		return service;
	}

	@Override
	public String getFloder() {
		return UrlConstants.ACCOUNT;
	}
	
	
	@RequestMapping(value="checkRoleName")
	@ResponseBody
	public String checkRoleName(@RequestParam("roleName") String roleName){
		if(service.findByRoleName(roleName)==null){
			return "true";
		}
		return "false";
	}

}

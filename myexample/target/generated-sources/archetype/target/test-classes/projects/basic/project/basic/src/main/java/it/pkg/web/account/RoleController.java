package it.pkg.web.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import it.pkg.entity.Role;
import it.pkg.service.ManagmentService;
import it.pkg.service.account.BaseService;
import it.pkg.web.utils.UrlConstants;

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

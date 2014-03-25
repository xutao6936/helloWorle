#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import ${package}.entity.Authirity;
import ${package}.service.AuthirityService;
import ${package}.service.account.BaseService;
import ${package}.web.utils.UrlConstants;

/** 
* @ClassName: AuthirityController 
* @Description: 权限表对应controller 
* @author XuTao
* @date 2013-12-23 下午05:57:01 
*  
*/
@Controller
@RequestMapping(value="/authirity")
public class AuthirityController extends BaseController<Authirity,Long>{
	
	@Autowired
	AuthirityService service;
	@Override
	public BaseService<Authirity, Long> getService() {
		return service;
	}

	@Override
	public String getFloder() {
		return UrlConstants.ACCOUNT;
	}
	
	
	
	@RequestMapping(value="checkAuthCode")
	@ResponseBody
	public String checkAuthCode(@RequestParam("authCode") String authCode){
		if(service.findByAuthCode(authCode)==null){
			return "true";
		}
		return "false";
	}
	
	@RequestMapping(value="checkAuthName")
	@ResponseBody
	public String checkAuthName(@RequestParam("authName") String authName){
		if(service.findByAuthName(authName)==null){
			return "true";
		}
		return "false";
	}
}

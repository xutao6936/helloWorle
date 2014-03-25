package com.thomas.myexample.web.account;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thomas.myexample.entity.Role;
import com.thomas.myexample.entity.User;
import com.thomas.myexample.service.account.AccountService;


@Controller
@RequestMapping(value="/register")
public class RegisterController {
	
	@Autowired
	private AccountService service;
	
	/*private static Map<String,String> status = Maps.newHashMap();
	
	static{
		status.put("enable", "有效");
		status.put("disable", "无效");
	}*/
	
	@RequestMapping(method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute User user, @RequestParam(value="roleList") Long roleId,  RedirectAttributes  redirect){
		Role role = service.getRole(roleId);
		user.setRole(role);
		service.registerUser(user);
		redirect.addFlashAttribute("username", user.getLogName());
		return "redirect:/login";
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String registerForm(Model model) {
		model.addAttribute("allRoles", service.getAllRole());
//		model.addAttribute("status", status);
		return "account/register"; // 直接返回到view层
	}
	
	@RequestMapping(value="checkLoginName")
	@ResponseBody
	public String checkLoginName(@RequestParam("logName") String logName){
		if(service.findByLogName(logName)==null){
			return "true";
		}else{
			return "false";
		}
	}
	
	/*// 获取所有的role
	@RequestMapping(value="allRoles")
	public String findAllRoles(@RequestParam("callback") String callbackName){
		List<String> roles = service.getRoleById(1L);
		JsonMapper mapper = new  JsonMapper();
		return mapper.toJsonP(callbackName,roles);
	}*/
	
	// 默认不在对象上绑定这些radio的信息,直接从requestParam中获得
	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setDisallowedFields("roleList");
	}
	
}

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.account;

import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.modules.web.Servlets;

import ${package}.entity.User;
import ${package}.service.account.AccountService;
import ${package}.service.account.ShiroUser;

@Controller
@RequestMapping(value="/admin")
public class AdminController {
	
	private Logger log =LoggerFactory.getLogger(AdminController.class) ;
	
	private static final String PAGE_SIZE = "3";
	
	@Autowired
	private AccountService service;
	
	@RequestMapping(value="user" )
	public String user(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			ServletRequest request){
		Map<String, Object> map = Servlets.getParametersStartingWith(request, "search_");
		Long userId = getCurrentUserId();
		System.out.println(((HttpServletRequest) request).getRequestURI()+"getRequestURI"+"----------");
		System.out.println(((HttpServletRequest) request).getServerName()+"  getServerName"+"----------");
		System.out.println(((HttpServletRequest) request).getServletPath()+"  getServletPath"+"----------");
		//   /${artifactId}/admin/user
		Page<User> users =  service.getEntitysWithPage(userId,map,pageNumber,pageSize,sortType);
		model.addAttribute("users", users);
		return "account/adminUserList";
	}
	
	private  Long getCurrentUserId(){
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
	
	
	// 此處不在requsetParam里面  必须用pathVariable获取id参数
	@RequestMapping(value="delete/{id}")
	public String delete(@PathVariable("id") Long id,RedirectAttributes  redirect){
		User user = service.getUserById(id);
		service.deleteUser(user);
		redirect.addFlashAttribute("message", "刪除用戶"+user.getLogName()+"成功");
		log.info("删除用户{}成功",user.getLogName());
		return "redirect:/admin/user";
	}
	
	
}

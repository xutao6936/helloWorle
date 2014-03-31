package com.thomas.myexample.web.account;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springside.modules.web.Servlets;

import com.thomas.myexample.service.basedata.BaseService;
import com.thomas.myexample.service.basedata.ShiroUser;
import com.thomas.myexample.web.utils.UrlMappingUtils;

/** 
* @ClassName: BaseController 
* @Description: controller基础类 
* @author XuTao
* @date 2013-12-23 下午02:47:18 
* 
* @param <T>
* @param <PK> 
*/
public abstract class BaseController<T,PK extends Serializable> {
	
	private static final String PAGE_SIZE = "3";
	
	public abstract BaseService<T,PK>  getService();
	
	public abstract String getFloder();
	
	@RequestMapping(value=UrlMappingUtils.LIST)
	public String list(@RequestParam(value = "page", defaultValue = "1") int pageNumber,
			@RequestParam(value = "page.size", defaultValue = PAGE_SIZE) int pageSize,
			@RequestParam(value = "sortType", defaultValue = "auto") String sortType, Model model,
			ServletRequest request){
		Map<String, Object> map = Servlets.getParametersStartingWith(request, "search_");
		Long userId = getCurrentUserId();
		Page<T> objects =  getService().getEntitysWithPage(userId,map,pageNumber,pageSize,sortType);
		model.addAttribute("objects", objects);
		return UrlMappingUtils.getReturnToViewPath((HttpServletRequest)request, UrlMappingUtils.LIST,getFloder());
	}
	
	private  Long getCurrentUserId(){
		ShiroUser user = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.id;
	}
	
	@RequestMapping(value=UrlMappingUtils.SAVE)
	public String save(@Valid @ModelAttribute T entity,ServletRequest request){
		getService().saveEntity(entity);
		return UrlMappingUtils.redirectUrl((HttpServletRequest)request);
	}
	
	@ModelAttribute
	public void getEntity(@RequestParam(value="id",required=false) Long id,Model model){
		if(id!=null){
			model.addAttribute("entity", getService().getEntity(id));
		}
	}
	
	@RequestMapping(value="delete/{id}")
	public String del(@PathVariable("id") Long id,RedirectAttributes  redirect,ServletRequest request){
		getService().delEntityById((PK)id);
		return UrlMappingUtils.redirectUrl((HttpServletRequest)request);
	}
	
	
}

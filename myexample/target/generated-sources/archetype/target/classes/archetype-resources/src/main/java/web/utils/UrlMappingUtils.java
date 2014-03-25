#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.web.utils;

import javax.servlet.http.HttpServletRequest;

/** 
* @ClassName: UrlMappingUtils 
* @Description: 路径映射工具类 
* @author XuTao
* @date 2013-12-20 下午02:15:46 
*  
*/
public class UrlMappingUtils {
	
	public static final String LIST = "List";
	public static final String SAVE = "Save";
	public static final String UPDATE = "Update";
//	public static String LIST = "List";
	public static String FORM = "Form";
	public static String REDIRECT = "redirect:";
	
	
	/** 
	* @Title: getReturnToViewPath 
	* @Description: 获取返回到view的路径  view命名规则是*Form *List  
	* @param @param request
	* @param @param method
	* @param @return    
	* @return String    
	* @throws 
	*/
	public static String getReturnToViewPath(HttpServletRequest  request,String method,String folder){
		///   /admin/user  getServletPath----------
		String servletPath = request.getServletPath();
			String path = getLocalPath(servletPath); // admin
			StringBuffer sb = new StringBuffer();
			sb.append(folder);
			sb.append("/");
			sb.append(path);
			if(LIST.equals(method)){
				sb.append(LIST);
				return sb.toString();
			}else if(FORM.equals(method)){
				sb.append(FORM);
				return sb.toString();
			}
		
		return "";
	}
	
	/** 
	* @Title: redirectUrl 
	* @Description: 在删除和保存修改结束后redirect跳转到list方法
	* @param @param request
	* @param @return    
	* @return String    
	* @throws 
	*/
	public static String redirectUrl(HttpServletRequest  request){
		String servletPath = request.getServletPath();
		String path = getLocalPath(servletPath); // admin
		StringBuffer sb = new StringBuffer();
		sb.append(REDIRECT);
		sb.append("/");
		sb.append(path);
		sb.append("/");
		sb.append(LIST);
		return  sb.toString();
	}
	
	private static String getLocalPath(String servletPath){
		if(servletPath.startsWith("/")){
			String path = servletPath.split("/")[1]; // admin
			return path;
		}
		return "";
	}
	
}

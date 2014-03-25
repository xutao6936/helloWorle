package it.pkg.webservice.response;

import javax.xml.bind.annotation.XmlType;

import it.pkg.entity.User;
import it.pkg.webservice.WsConstants;

/** 
* @ClassName: GetUserResult 
* @Description: soap  使用类型 
* @author XuTao
* @date 2014-3-7 上午09:28:42 
*  
*/
@XmlType(name="GetUserResult"  ,namespace=WsConstants.NS)
public class GetUserResult {
	
	
	private User user;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}

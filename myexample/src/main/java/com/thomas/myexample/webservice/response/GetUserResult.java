package com.thomas.myexample.webservice.response;

import javax.xml.bind.annotation.XmlType;

import com.thomas.myexample.entity.User;
import com.thomas.myexample.webservice.WsConstants;

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

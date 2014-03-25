package com.thomas.myexample.webservice.response.dto;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.thomas.myexample.webservice.WsConstants;


/** 
* @ClassName: RoleDto 
* @Description: webservice 传输role的dto，只传输web接口需要的属性，尽量使用默认规定 
* @author XuTao
* @date 2014-3-17 上午10:14:36 
*  
*/
@XmlRootElement
@XmlType(name="Role",namespace= WsConstants.NS)
public class RoleDto {

	private Long id;
	private String roleName;

	public RoleDto() {
	}

	public RoleDto(Long id, String roleName) {
		super();
		this.id = id;
		this.roleName = roleName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

}

package com.thomas.myexample.webservice.response;

import javax.xml.bind.annotation.XmlType;

import com.thomas.myexample.webservice.WsConstants;
import com.thomas.myexample.webservice.response.dto.RoleDto;

@XmlType(name = "GetRoleResult", namespace = WsConstants.NS)
public class GetRoleResult extends WSResult {
	private RoleDto dto;

	public RoleDto getDto() {
		return dto;
	}

	public void setDto(RoleDto dto) {
		this.dto = dto;
	}

}

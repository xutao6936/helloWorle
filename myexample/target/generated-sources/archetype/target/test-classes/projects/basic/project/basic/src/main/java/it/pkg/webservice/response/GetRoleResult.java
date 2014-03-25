package it.pkg.webservice.response;

import javax.xml.bind.annotation.XmlType;


import it.pkg.entity.Role;
import it.pkg.webservice.WsConstants;
import it.pkg.webservice.response.dto.RoleDto;

@XmlType(name="GetRoleResult",namespace=WsConstants.NS)
public class GetRoleResult extends WSResult{
	private RoleDto dto;

	public RoleDto getDto() {
		return dto;
	}

	public void setDto(RoleDto dto) {
		this.dto = dto;
	}

	
	
}

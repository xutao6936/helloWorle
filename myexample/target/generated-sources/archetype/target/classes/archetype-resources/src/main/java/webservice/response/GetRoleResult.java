#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.webservice.response;

import javax.xml.bind.annotation.XmlType;


import ${package}.entity.Role;
import ${package}.webservice.WsConstants;
import ${package}.webservice.response.dto.RoleDto;

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

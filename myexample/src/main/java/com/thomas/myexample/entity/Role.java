package com.thomas.myexample.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;


/** 
* @ClassName: Role 
* @Description: 角色表 放入中间表的set集合 
* @author XuTao
* @date 2013-12-13 上午10:36:10 
*  
*/
@Entity
@Table(name="ACCT_ROLE")
public class Role  extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String roleName;
	
	private Set<RoleAuthMiddle> roleAuthMiddles;

    public Role() {
    }
    
    
    @Id
	@SequenceGenerator(name="ACCT_ROLE_ID_GENERATOR", sequenceName="SEQ_ROLE")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCT_ROLE_ID_GENERATOR")
	public Long getId() {
		return id;
	}
    

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
	
	@OneToMany(mappedBy="role")
	public Set<RoleAuthMiddle> getRoleAuthMiddles() {
		return this.roleAuthMiddles;
	}

	public void setRoleAuthMiddles(Set<RoleAuthMiddle> roleAuthMiddles) {
		this.roleAuthMiddles = roleAuthMiddles;
	}
	
}
package com.thomas.myexample.entity;

import java.io.Serializable;
import javax.persistence.*;


/** 
* @ClassName: RoleAuthMiddle 
* @Description: 权限角色中间表 
* @author XuTao
* @date 2013-12-13 上午10:34:03 
*  
*/
//@Embeddable// 复合主键类
@Entity
@Table(name="ROLE_AUTH_MIDDLE")
public class RoleAuthMiddle extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Role role;

    
	private Authirity acctAuthirity;

    public RoleAuthMiddle() {
    }
    
    
    @Id
	@SequenceGenerator(name="ACCT_AUTHIRITY_ID_GENERATOR", sequenceName="SEQ_AUTH")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCT_AUTHIRITY_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

    
    @ManyToOne
    @JoinColumn(name="ROLE_ID")
	public Role getRole() {
		return role;
	}


	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn(name="AUTH_ID")
	public Authirity getAcctAuthirity() {
		return this.acctAuthirity;
	}

	public void setAcctAuthirity(Authirity acctAuthirity) {
		this.acctAuthirity = acctAuthirity;
	}
	
}
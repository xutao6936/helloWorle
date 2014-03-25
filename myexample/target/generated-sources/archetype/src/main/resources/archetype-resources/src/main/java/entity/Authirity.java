#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.google.common.collect.Lists;


/**
 * The persistent class for the ACCT_AUTHIRITY database table.
 * 
 */
@Entity
@Table(name="ACCT_AUTHIRITY")
public class Authirity  extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	private String authCode;

	private String authName;

	
	private List<RoleAuthMiddle> roleAuthMiddles = Lists.newArrayList();

    public Authirity() {
    }
    
    @Id
	@SequenceGenerator(name="ACCT_AUTHIRITY_ID_GENERATOR", sequenceName="SEQ_AUTH")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ACCT_AUTHIRITY_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public String getAuthCode() {
		return this.authCode;
	}

	public void setAuthCode(String authCode) {
		this.authCode = authCode;
	}

	public String getAuthName() {
		return this.authName;
	}

	public void setAuthName(String authName) {
		this.authName = authName;
	}
	
	
	@OneToMany(mappedBy="acctAuthirity")
	public List<RoleAuthMiddle> getRoleAuthMiddles() {
		return this.roleAuthMiddles;
	}

	public void setRoleAuthMiddles(List<RoleAuthMiddle> roleAuthMiddles) {
		this.roleAuthMiddles = roleAuthMiddles;
	}
	
}
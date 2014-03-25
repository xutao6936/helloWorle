#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

/** 
* @ClassName: User 
* @Description: user实体 将role放入到此处里，但没有cascade 
* @author XuTao
* @date 2013-12-13 上午10:27:31 
*  
*/
@Entity
@Table(name = "ACC_USER")
public class User extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;


	private Date careteDate;

	private String logName;

	private String name;

	private String pwd;

	private String plainPwd;

	private Role role;

	private String salt;

	public User() {
	}
	

	@Id
	@SequenceGenerator(name = "ACC_USER_ID_GENERATOR", sequenceName = "SEQ_USER", allocationSize = 20)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_USER_ID_GENERATOR")
	public Long getId() {
		return id;
	}


	public Date getCareteDate() {
		return this.careteDate;
	}

	public void setCareteDate(Date careteDate) {
		this.careteDate = careteDate;
	}

	@NotBlank
	public String getLogName() {
		return this.logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

	@NotBlank
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPwd() {
		return this.pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@OneToOne
	@JoinColumn(name = "ROLE_ID")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Transient
	public String getPlainPwd() {
		return plainPwd;
	}

	public void setPlainPwd(String plainPwd) {
		this.plainPwd = plainPwd;
	}

}
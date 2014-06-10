package com.thomas.myexample.entity.basedata;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.Email;

import com.thomas.myexample.entity.BaseEntity;

/**
 * @ClassName: User
 * @Description: 用户实体
 * @author XuTao
 * @date 2014-3-28 下午01:59:11
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

	private Role role;

	private String salt;

	private String plainPwd;

	private String enable;

	private String email;

	public User() {
	}

	@Override
	@Id
	@SequenceGenerator(name = "ACC_USER_ID_GENERATOR", sequenceName = "SEQ_USER")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACC_USER_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CARETE_DATE")
	public Date getCareteDate() {
		return this.careteDate;
	}

	public void setCareteDate(Date careteDate) {
		this.careteDate = careteDate;
	}

	public String getLogName() {
		return this.logName;
	}

	public void setLogName(String logName) {
		this.logName = logName;
	}

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

	@OneToOne
	@JoinColumn(name = "ROLE_ID")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	@Transient
	public String getPlainPwd() {
		return plainPwd;
	}

	public void setPlainPwd(String plainPwd) {
		this.plainPwd = plainPwd;
	}

	public String getEnable() {
		return enable;
	}

	public void setEnable(String enable) {
		this.enable = enable;
	}

	@Email
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
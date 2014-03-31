package com.thomas.myexample.entity.basedata;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.StringUtils;

import com.google.common.collect.ImmutableList;
import com.thomas.myexample.entity.BaseEntity;

/**
 * @ClassName: Role
 * @Description: 角色 实体
 * @author XuTao
 * @date 2014-3-28 下午01:58:50
 * 
 */
@Entity
@Table(name = "ACCT_ROLE")
public class Role extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String authitiy;

	private String roleName;

	public Role() {

	}

	@Override
	@Id
	@SequenceGenerator(name = "ACCT_ROLE_ID_GENERATOR", sequenceName = "SEQ_ROLE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCT_ROLE_ID_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public String getAuthitiy() {
		return this.authitiy;
	}

	public void setAuthitiy(String authitiy) {
		this.authitiy = authitiy;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@Transient
	public List<String> getAuthList() {
		return ImmutableList.copyOf(StringUtils.split(authitiy, ","));
	}
}
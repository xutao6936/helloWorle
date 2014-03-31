package com.thomas.myexample.entity.basedata;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.thomas.myexample.entity.BaseEntity;

/**
 * @ClassName: Operatroom
 * @Description: 手术间实体
 * @author XuTao
 * @date 2014-3-28 下午02:23:04
 * 
 */
@Entity
@Table(name = "ACCT_OPERATROOM")
public class Operatroom extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean enable;

	private String name;

	public Operatroom() {
	}

	@Override
	@Id
	@SequenceGenerator(name = "ACCT_OPERATROOM_CODE_GENERATOR", sequenceName = "SEQ_OPERATROOM")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCT_OPERATROOM_CODE_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public Boolean getEnable() {
		return this.enable;
	}

	public void setEnable(Boolean enable) {
		this.enable = enable;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
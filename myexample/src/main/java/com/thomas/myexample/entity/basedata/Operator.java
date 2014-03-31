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
 * @ClassName: Operator
 * @Description: 手术医生实体
 * @author XuTao
 * @date 2014-3-28 下午02:27:23
 * 
 */
@Entity
@Table(name = "ACCT_OPERATOR")
public class Operator extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private String competence;

	private Boolean enable;

	private String name;

	private String sourceCode;

	public Operator() {
	}

	@Override
	@Id
	@SequenceGenerator(name = "ACCT_OPERATOR_CODE_GENERATOR", sequenceName = "SEQ_OPERATOR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCT_OPERATOR_CODE_GENERATOR")
	public Long getId() {
		return this.id;
	}

	public String getCompetence() {
		return this.competence;
	}

	public void setCompetence(String competence) {
		this.competence = competence;
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

	public String getSourceCode() {
		return this.sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

}
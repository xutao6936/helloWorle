package com.thomas.myexample.entity.basedata;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.thomas.myexample.entity.BaseEntity;

/**
 * @ClassName: SurgicalName
 * @Description: 手术名称实体
 * @author XuTao
 * @date 2014-3-28 下午02:33:07
 * 
 */
@Entity
@Table(name = "ACCT_SURGICAL_NAME")
public class SurgicalName extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean enable;

	private String name;

	private String pinyin;

	@Column(name = "SOURCE_CODE")
	private String sourceCode;

	@Column(name = "SOURCE_NAME")
	private String sourceName;

	public SurgicalName() {
	}

	@Override
	@Id
	@SequenceGenerator(name = "ACCT_SURGICAL_NAME_GENERATOR", sequenceName = "SEQ_SURGICAL")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCT_SURGICAL_NAME_GENERATOR")
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

	public String getPinyin() {
		return this.pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getSourceCode() {
		return this.sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceName() {
		return this.sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

}
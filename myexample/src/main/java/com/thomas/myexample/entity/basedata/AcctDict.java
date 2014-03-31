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
 * @ClassName: AcctDict
 * @Description: 数据字典
 * @author XuTao
 * @date 2014-3-28 下午04:27:42
 * 
 */
@Entity
@Table(name = "ACCT_DICT")
public class AcctDict extends BaseEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	private Boolean enable;

	private String name;

	@Column(name = "TYPE_CODE")
	private String typeCode;

	@Column(name = "TYPE_NAME")
	private String typeName;

	private String value;

	public AcctDict() {
	}

	@Override
	@Id
	@SequenceGenerator(name = "ACCT_DICT_CODE_GENERATOR", sequenceName = "SEQ_DICT")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCT_DICT_CODE_GENERATOR")
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

	public String getTypeCode() {
		return this.typeCode;
	}

	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getValue() {
		return this.value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
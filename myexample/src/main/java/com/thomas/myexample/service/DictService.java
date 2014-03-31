package com.thomas.myexample.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.thomas.myexample.entity.basedata.AcctDict;
import com.thomas.myexample.repository.BaseDao;
import com.thomas.myexample.repository.basedata.DictDao;
import com.thomas.myexample.service.basedata.BaseService;

public class DictService extends BaseService<AcctDict, Long> {

	@Autowired
	DictDao dao;

	@Override
	public BaseDao<AcctDict, Long> getDao() {
		return dao;
	}

}

package com.thomas.myexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thomas.myexample.entity.basedata.AcctDict;
import com.thomas.myexample.utils.AcctDictUtils;

@Service
public class AcctDictList {

	@Autowired
	DictService service;

	public void init() {
		List<AcctDict> list = service.getAllEntity();
		for (AcctDict acctDict : list) {
			AcctDictUtils.addToTypeMap(acctDict);
			AcctDictUtils.addToAllDatas(acctDict);
		}
	}

	// 重载数据字典
	public void reload() {
		AcctDictUtils.clearDatas();
		init();
	}

}

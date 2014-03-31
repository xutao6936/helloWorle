package com.thomas.myexample.utils;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.thomas.myexample.entity.basedata.AcctDict;

public class AcctDictUtils {

	public static Map<String, AcctDict> allDatas = Maps.newHashMap();

	public static Map<String, List<AcctDict>> groupByType = Maps.newHashMap();

	public static void clearDatas() {
		allDatas = Maps.newHashMap();
		groupByType = Maps.newHashMap();
	}

	public static void addToTypeMap(AcctDict dict) {
		String type = dict.getTypeCode();
		List<AcctDict> list = groupByType.get(type);
		if (list == null) {
			list = Lists.newArrayList();
			groupByType.put(type, list);
		}
		list.add(dict);

	}

	// 从分组map中获得type队形的list
	public List<AcctDict> getTypeData(String type) {
		return groupByType.get(type);
	}

	public static void addToAllDatas(AcctDict dict) {
		String key = dict.getId().toString();
		allDatas.put(key, dict);
	}

	public static String getNameByCode(String code) {
		return allDatas.get(code).getName();
	}
}

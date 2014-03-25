package com.thomas.myexample.repository;

import com.thomas.myexample.entity.Authirity;

public interface AuthirityDao extends BaseDao<Authirity,Long>{
	
	
	Authirity findByAuthCode(String authCode);
	Authirity findByAuthName(String authName);
	
}

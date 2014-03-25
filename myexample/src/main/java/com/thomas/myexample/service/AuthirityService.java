package com.thomas.myexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.thomas.myexample.entity.Authirity;
import com.thomas.myexample.repository.AuthirityDao;
import com.thomas.myexample.repository.BaseDao;
import com.thomas.myexample.service.account.BaseService;

@Component
@Transactional
public class AuthirityService extends BaseService<Authirity,Long>{
	
	@Autowired
	AuthirityDao  dao;
	
	@Override
	public BaseDao<Authirity, Long> getDao() {
		return dao;
	}
	
	
	
	public  Authirity  findByAuthName(String authName){
		return  dao.findByAuthName(authName);
	}
	
	public  Authirity  findByAuthCode(String authCode){
		return dao.findByAuthCode(authCode);
	}
}

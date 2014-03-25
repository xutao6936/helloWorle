#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ${package}.entity.Authirity;
import ${package}.repository.AuthirityDao;
import ${package}.repository.BaseDao;
import ${package}.service.account.BaseService;

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

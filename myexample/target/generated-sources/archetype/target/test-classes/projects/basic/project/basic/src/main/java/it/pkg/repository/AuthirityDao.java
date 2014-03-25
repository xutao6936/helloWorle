package it.pkg.repository;

import it.pkg.entity.Authirity;

public interface AuthirityDao extends BaseDao<Authirity,Long>{
	
	
	Authirity findByAuthCode(String authCode);
	Authirity findByAuthName(String authName);
	
}

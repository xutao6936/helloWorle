package com.thomas.myexample.repository.basedata;

import com.thomas.myexample.entity.basedata.User;
import com.thomas.myexample.repository.BaseDao;

/**
 * @ClassName: UserDao
 * @Description: 用户dao
 * @author XuTao
 * @date 2014-3-28 下午02:46:26
 * 
 */
public interface UserDao extends BaseDao<User, Long> {

	User findByLogName(String logName);

	User findByEmail(String email);

	User findByLogNameOrEmail(String logName, String email);
}

package com.thomas.myexample.service.basedata;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.Encodes;

import com.thomas.myexample.email.SimpleMailService;
import com.thomas.myexample.entity.basedata.User;
import com.thomas.myexample.repository.BaseDao;
import com.thomas.myexample.repository.basedata.UserDao;

/**
 * @ClassName: UserService
 * @Description: 用户管理类
 * @author XuTao
 * @date 2014-3-28 下午03:25:30
 * 
 */
@Component
@Transactional
public class UserService extends BaseService<User, Long> {

	public static Logger log = LoggerFactory.getLogger(UserService.class);

	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;

	UserDao userDao;

	SimpleMailService mail;

	@Override
	public BaseDao<User, Long> getDao() {
		return userDao;
	}

	// 保存用户
	public void saveUser(User user) {
		if (isSuperAdmin(user)) {
			log.warn("操作员{}尝试修改超级管理员", getCurrentName());
			throw new ServiceException("不能修改超级管理员");
		}
		if (StringUtils.isNotBlank(user.getPlainPwd())) {
			// 将密码加密
			entryptPassword(user);
		}
		userDao.save(user);
		// 发送邮件
		mail.sendNotifyMail(user.getName(), user.getEmail());
	}

	public User findByLogName(String logName) {
		return userDao.findByLogName(logName);
	}

	public User findByEmail(String email) {
		return userDao.findByEmail(email);
	}

	public User findByLogNameOrEmail(String content) {
		return userDao.findByLogNameOrEmail(content, content);
	}

	/**
	 * @Title: entryptPassword
	 * @Description: 设置安全的密码，生成随机的salt并经过1024次sha-1
	 * @param @param user
	 * @return void
	 * @throws
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));
		byte[] hashPassword = Digests.sha1(user.getPlainPwd().getBytes(), salt, HASH_INTERATIONS);
		user.setPwd(Encodes.encodeHex(hashPassword));
	}

	private String getCurrentName() {
		ShiroUser suser = (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return suser.getName();
	}

	/**
	 * @Title: isSuperAdmin
	 * @Description: 判断是否为超级管理员，默认超级管理员id为1
	 * @param @param user
	 * @param @return
	 * @return Boolean
	 * @throws
	 */
	private Boolean isSuperAdmin(User user) {
		return ((user.getId() != null) && (user.getId() == 1L));
	}

	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setMail(SimpleMailService mail) {
		this.mail = mail;
	}

}

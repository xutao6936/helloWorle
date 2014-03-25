#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.service.account;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.security.utils.Digests;
import org.springside.modules.utils.DateProvider;
import org.springside.modules.utils.Encodes;

import ${package}.entity.Role;
import ${package}.entity.RoleAuthMiddle;
import ${package}.entity.User;
import ${package}.repository.BaseDao;
import ${package}.repository.RoleDao;
import ${package}.repository.UserDao;


/** 
* @ClassName: AccountService 
* @Description: 用户管理类 
* @author XuTao
* @date 2013-12-13 上午11:00:36 
*  
*/
// spring service bean的表示
@Component
@Transactional
public class AccountService extends BaseService<User,Long>{
	
	
	public static final String HASH_ALGORITHM = "SHA-1";
	public static final int HASH_INTERATIONS = 1024;
	private static final int SALT_SIZE = 8;
	
	private UserDao userDao;
	
	private RoleDao roleDao;
	
	private static Logger log = LoggerFactory.getLogger(AccountService.class);
	
	private DateProvider dateProvider = DateProvider.DEFAULT;
	
	
	/** 
	* @Title: saveUser 
	* @Description: 保存用户
	* @param @param user    
	* @return void    
	* @throws 
	*/
	public void saveUser(User user){
		if(isSupervisor(user)){
			log.warn("操作员{}尝试更改管理员账号",getCurrentUserName());
			throw new ServiceException("不能修改超级管理员用户");
		}
		// 设定安全的密码， 并生成随机的salt，经过1024次sha-1 hash
		if(StringUtils.isNotBlank(user.getPlainPwd())){
			entryptPassword(user);
		}
		userDao.save(user);
	}
	
	// 注册用户
	public void registerUser(User user){
		entryptPassword(user);
		user.setCareteDate(dateProvider.getDate());
		userDao.save(user);
	}
	
	
	/**
	 * 设定安全的密码，生成随机的salt并经过1024次 sha-1 hash
	 */
	private void entryptPassword(User user) {
		byte[] salt = Digests.generateSalt(SALT_SIZE);
		user.setSalt(Encodes.encodeHex(salt));

		byte[] hashPassword = Digests.sha1(user.getPlainPwd().getBytes(), salt, HASH_INTERATIONS);
		user.setPwd(Encodes.encodeHex(hashPassword));
	}
	// 取得当前登录者姓名
	private String getCurrentUserName(){
		ShiroUser user =  (ShiroUser) SecurityUtils.getSubject().getPrincipal();
		return user.loginName;
	}
	// 判断是否是超级管理员
	private boolean isSupervisor(User user){
		return (user.getId()!=null && user.getId()==1L);
	}
	
	
	public List<User> searchUser(Map<String, Object> searchParams){
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<User> specification = DynamicSpecifications.bySearchFilter(filters.values(), User.class);
		List<User> list = userDao.findAll(specification);
		return list;
	}
	
	
	public long getUserCount(){
		return userDao.count();
	}
	
	public User findByLogName(String logName){
		return userDao.findByLogName(logName);
	}
	
	public List<User> getAllUser(){
		return (List<User>) userDao.findAll();
	}
	
	

	
	
	
	public User getUserById(Long id){
		return userDao.findOne(id);
	}
	
	public void deleteUser(User user){
		userDao.delete(user);
	}
	public Role getRole(Long roleId){
		return roleDao.findOne(roleId);
	}
	public List<Role> getAllRole(){
		return (List<Role>) roleDao.findAll();
	}
	
	// 通过roleid获得权限列表
	public List<String> getRoleById(Long roleId){
		Role role = roleDao.findOne(roleId);
		if(role!=null){
			
			Set<RoleAuthMiddle> set = role.getRoleAuthMiddles();
			List<String> auths = new ArrayList<String>();
			for (RoleAuthMiddle roleAuthMiddle : set) {
				auths.add(roleAuthMiddle.getAcctAuthirity().getAuthCode());
			}
			return auths;
		}
		return null;
	}
	
	public List<User> getEntities(Map<String, Object> searchParams){
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
		Specification<User> specification =  DynamicSpecifications.bySearchFilter(filters.values(), User.class);
		return userDao.findAll(specification);
	}
	
	
	
	
	
	
	
	 //----------------//
	// ---set method---//
	@Autowired
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Autowired
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	@Override
	public BaseDao<User, Long> getDao() {
		// TODO Auto-generated method stub
		return userDao;
	}

	
}

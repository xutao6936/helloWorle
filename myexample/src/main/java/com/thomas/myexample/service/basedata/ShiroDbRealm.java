package com.thomas.myexample.service.basedata;

import javax.annotation.PostConstruct;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springside.modules.utils.Encodes;

import com.thomas.myexample.entity.basedata.User;

/**
 * @ClassName: ShiroDbRealm
 * @Description: shiro 函数
 * @author XuTao
 * @date 2013-12-13 上午11:56:04
 * 
 */
public class ShiroDbRealm extends AuthorizingRealm {

	// 必须有set和get方法
	private UserService userService;

	// 授权回调函数，进行鉴权但缓存中没有时调用
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
		User user = userService.findByLogName(shiroUser.getLoginName());
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		// 基于role的权限信息
		info.addRole(user.getRole().getRoleName());
		// 基于permissions的权限信息
		info.addStringPermissions(user.getRole().getAuthList());

		return info;
	}

	/**
	 * 设定Password校验的Hash算法与迭代次数.
	 */
	@PostConstruct
	public void initCredentialsMatcher() {
		HashedCredentialsMatcher matcher = new HashedCredentialsMatcher(userService.HASH_ALGORITHM);
		matcher.setHashIterations(userService.HASH_INTERATIONS);

		setCredentialsMatcher(matcher);
	}

	// 认证回调函数 登录时调用
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
		User user = userService.findByLogName(token.getUsername());
		if (user != null) {
			byte[] salts = Encodes.decodeHex(user.getSalt());
			return new SimpleAuthenticationInfo(new ShiroUser(user.getLogName(), user.getName()), user.getPwd(),
					ByteSource.Util.bytes(salts), getName());
		} else {
			return null;
		}
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

}

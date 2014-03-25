<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<div id="header">
	    <div class="navbar  navbar-inverse navbar-fixed-top" >
		  <div class="navbar-inner">
		  <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </a>
	      
		  <a class="brand" href="${ctx}">QuickStart示例</a>
	      	<div class="nav-collapse collapse navbar-responsive-collapse">
			    <ul class="nav">
			      <li><a href="#">首页</a></li>
			      <li><a href="#">Link</a></li>
			      <li class="dropdown "><a href="#" class="dropdown-toggle" data-toggle="dropdown">系统管理<b class="caret"></b></a>
			      	 <shiro:hasRole name="admin">
				      	 <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
				      	 	<li class="dropdown-submenu">
				      	 		<a tabindex="-1" href="#">管理用户</a>
				      	 		<ul class="dropdown-menu">
				      	 			<li><a href="${ctx}/admin/user">用户列表</a></li>
				      	 			<li><a href="${ctx}/register">添加用户</a></li>
				      	 		</ul>
				      	 	</li>
				      	 	<li class="dropdown-submenu">
				      	 		<a tabindex="-1" href="#">管理角色</a>
				      	 		<ul class="dropdown-menu">
				      	 			<li><a href="${ctx}/role/List">角色列表</a></li>
				      	 			<li><a href="${ctx}/account/roleForm">添加角色</a></li>
				      	 		</ul>
				      	 	</li>
				      	 	<li class="dropdown-submenu">
				      	 		<a tabindex="-1" href="#">管理权限</a>
				      	 		<ul class="dropdown-menu">
				      	 			<li><a href="${ctx}/authirity/List">权限列表</a></li>
				      	 			<li><a href="${ctx}/account/authirityForm">添加权限</a></li>
				      	 		</ul>
				      	 	</li>
					    </ul>
			      	</shiro:hasRole>
			      </li>
			    </ul>
      		</div>
		  </div>
		 <shiro:user>
			<div class="btn-group pull-right">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
					<i class="icon-user"></i> <shiro:principal property="name"/>
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="${ctx}/logout">Logout</a></li>
				</ul>
			</div>
		</shiro:user>
		</div>
</div>


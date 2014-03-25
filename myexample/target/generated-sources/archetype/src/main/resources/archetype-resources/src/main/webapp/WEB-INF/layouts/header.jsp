#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ page language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<c:set var="ctx" value="${symbol_dollar}{pageContext.request.contextPath}"/>
<div id="header">
	    <div class="navbar  navbar-inverse">
		  <div class="navbar-inner">
		  <a class="btn btn-navbar" data-toggle="collapse" data-target=".nav-collapse">
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	        <span class="icon-bar"></span>
	      </a>
	      
		  <a class="brand" href="${symbol_dollar}{ctx}">QuickStart示例</a>
	      	<div class="nav-collapse collapse navbar-responsive-collapse">
			    <ul class="nav">
			      <li><a href="${symbol_pound}">首页</a></li>
			      <li><a href="${symbol_pound}">Link</a></li>
			      <li class="dropdown "><a href="${symbol_pound}" class="dropdown-toggle" data-toggle="dropdown">系统管理<b class="caret"></b></a>
			      	 <ul class="dropdown-menu" role="menu" aria-labelledby="dLabel">
			      	 <shiro:hasRole name="admin">
			      	 	<li class="dropdown-submenu">
			      	 		<a tabindex="-1" href="${symbol_pound}">管理用户</a>
			      	 		<ul class="dropdown-menu">
			      	 			<li><a href="${symbol_dollar}{ctx}/admin/user">用户列表</a></li>
			      	 			<li><a href="${symbol_dollar}{ctx}/register">添加用户</a></li>
			      	 		</ul>
			      	 	</li>
			      	 	<li class="dropdown-submenu">
			      	 		<a tabindex="-1" href="${symbol_pound}">管理角色</a>
			      	 		<ul class="dropdown-menu">
			      	 			<li><a href="${symbol_dollar}{ctx}/role/List">角色列表</a></li>
			      	 			<li><a href="${symbol_dollar}{ctx}/account/roleForm">添加角色</a></li>
			      	 		</ul>
			      	 	</li>
			      	 	<li class="dropdown-submenu">
			      	 		<a tabindex="-1" href="${symbol_pound}">管理权限</a>
			      	 		<ul class="dropdown-menu">
			      	 			<li><a href="${symbol_dollar}{ctx}/authirity/List">权限列表</a></li>
			      	 			<li><a href="${symbol_dollar}{ctx}/account/authirityForm">添加权限</a></li>
			      	 		</ul>
			      	 	</li>
			      	 </shiro:hasRole>
				    </ul>
			      </li>
			    </ul>
      		</div>
		  </div>
		 <shiro:user>
			<div class="btn-group pull-right">
				<a class="btn dropdown-toggle" data-toggle="dropdown" href="${symbol_pound}">
					<i class="icon-user"></i> <shiro:principal property="name"/>
					<span class="caret"></span>
				</a>
				<ul class="dropdown-menu">
					<li><a href="${symbol_dollar}{ctx}/logout">Logout</a></li>
				</ul>
			</div>
		</shiro:user>
		</div>
</div>


#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${symbol_dollar}{pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户管理</title>
</head>

<body>
	<c:if test="${symbol_dollar}{not empty message}">
		<div id="message" class="alert alert-success topForm"><button data-dismiss="alert" class="close">×</button>${symbol_dollar}{message}</div>
	</c:if>
	<div class="row" style="margin-top:60px">
		<div class="span4 offset7">
			<form class="form-search" action="${symbol_dollar}{ctx }/admin/user" method="post">
			
				<label>用户名：</label> 
				<form class="navbar-search pull-left">
				  	<input type="text" class="search-query input-medium" placeholder="Search" name="search_LIKE_name"  value="${symbol_dollar}{param.search_LIKE_name}"/>
					<!-- <button type="submit" class="btn" id="search_btn">Search</button> -->
				</form>
		    </form>
	    </div>
	</div> 
	<table id="contentTable" class="table table-striped table-bordered table-condensed topForm">
		<thead><tr><th>登录名</th><th>用户名</th><th>注册时间</th><th>角色</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${symbol_dollar}{users.content}" var="user">
			<tr>
				<td><a href="${symbol_dollar}{ctx}/admin/update/${symbol_dollar}{user.id}">${symbol_dollar}{user.logName}</a></td>
				<td>${symbol_dollar}{user.name}</td>
				<td>
					<fmt:formatDate value="${symbol_dollar}{user.careteDate}" pattern="yyyy年MM月dd日  HH时mm分ss秒" />
				</td>
				<td>
					${symbol_dollar}{user.role.roleName }
				</td>
				<td><a href="${symbol_dollar}{ctx}/admin/delete/${symbol_dollar}{user.id}">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<tags:pagination page="${symbol_dollar}{users}" paginationSize="5"/>
</body>
</html>

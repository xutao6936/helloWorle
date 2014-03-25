<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户管理</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success topForm"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row" style="margin-top:60px">
		<div class="span4 offset7">
			<form class="form-search" action="${ctx }/admin/user" method="post">
			
				<label>用户名：</label> 
				<form class="navbar-search pull-left">
				  	<input type="text" class="search-query input-medium" placeholder="Search" name="search_LIKE_name"  value="${param.search_LIKE_name}"/>
					<!-- <button type="submit" class="btn" id="search_btn">Search</button> -->
				</form>
		    </form>
	    </div>
	</div> 
	<table id="contentTable" class="table table-striped table-bordered table-condensed topForm">
		<thead><tr><th>登录名</th><th>用户名</th><th>注册时间</th><th>角色</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${users.content}" var="user">
			<tr>
				<td><a href="${ctx}/admin/update/${user.id}">${user.logName}</a></td>
				<td>${user.name}</td>
				<td>
					<fmt:formatDate value="${user.careteDate}" pattern="yyyy年MM月dd日  HH时mm分ss秒" />
				</td>
				<td>
					${user.role.roleName }
				</td>
				<td><a href="${ctx}/admin/delete/${user.id}">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<tags:pagination page="${users}" paginationSize="5"/>
</body>
</html>

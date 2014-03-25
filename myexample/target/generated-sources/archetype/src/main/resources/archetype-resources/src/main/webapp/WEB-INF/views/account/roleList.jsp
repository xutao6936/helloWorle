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
	<title>角色管理</title>
</head>

<body>
	<c:if test="${symbol_dollar}{not empty message}">
		<div id="message" class="alert alert-success topForm"><button data-dismiss="alert" class="close">×</button>${symbol_dollar}{message}</div>
	</c:if>
	<div class="row" style="margin-top:60px">
		<div class="span4 offset7">
			<form class="form-search" action="${symbol_dollar}{ctx }/role/List" method="post">
			
				<label>角色名：</label> 
				<form class="navbar-search pull-left">
				  	<input type="text" class="search-query input-medium" placeholder="Search" name="search_LIKE_roleName"  value="${symbol_dollar}{param.search_LIKE_roleName}"/>
				</form>
		    </form>
	    </div>
	</div> 
	<table id="contentTable" class="table table-striped table-bordered table-condensed topForm">
		<thead><tr><th>角色</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${symbol_dollar}{objects.content}" var="entity">
			<tr>
				<td>
					${symbol_dollar}{entity.roleName }
				</td>
				<td><a href="${symbol_dollar}{ctx}/role/delete/${symbol_dollar}{entity.id}">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
	<tags:pagination page="${symbol_dollar}{objects}" paginationSize="5"/>
</body>
</html>

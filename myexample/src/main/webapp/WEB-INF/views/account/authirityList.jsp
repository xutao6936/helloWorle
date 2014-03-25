<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>权限管理</title>
</head>

<body>
	<c:if test="${not empty message}">
		<div id="message" class="alert alert-success topForm"><button data-dismiss="alert" class="close">×</button>${message}</div>
	</c:if>
	<div class="row" style="margin-top:60px">
		<div class="span4 offset7">
			<form class="form-search" action="${ctx }/authirity/List" method="post">
			
				<label>权限名：</label> 
				<form class="navbar-search pull-left">
				  	<input type="text" class="search-query input-medium" placeholder="Search" name="search_LIKE_authName"  value="${param.search_LIKE_authName}"/>
				</form>
		    </form>
	    </div>
	</div> 
	<table id="contentTable" class="table table-striped table-bordered table-condensed topForm">
		<thead><tr><th>权限代码</th><th>权限名称</th><th>管理</th></tr></thead>
		<tbody>
		<c:forEach items="${objects.content}" var="entity">
			<tr>
				<td>
					${entity.authCode }
				</td>
				<td>
					${entity.authName }
				</td>
				<td><a href="${ctx}/authirity/delete/${entity.id}">删除</a></td>
			</tr>
		</c:forEach>
		</tbody>
		
	</table>
	<tags:pagination page="${objects}" paginationSize="5"/>
</body>
</html>

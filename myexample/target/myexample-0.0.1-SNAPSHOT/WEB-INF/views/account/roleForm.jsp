<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>

<html>
<head>
	<title>添加角色</title>
	<script>
		$(document).ready(function(){
			//聚焦第一个输入框
			$("#roleName").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate({
				rules: {
					roleName: {
						remote: "${ctx}/role/checkRoleName"
					}
				},
				messages: {
					roleName: {
						remote: "角色名称已存在"
					}
				}
			});
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/role/Save" method="post" class="form-horizontal topForm">
		<fieldset>
			<legend><small>添加角色</small></legend>
			<div class="control-group">
				<label for="roleName" class="control-label">角色名:</label>
				<div class="controls">
					<input type="text" id="roleName" name="roleName" class="input-large required" minlength="3"/>
				</div>
			</div>
			<div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>

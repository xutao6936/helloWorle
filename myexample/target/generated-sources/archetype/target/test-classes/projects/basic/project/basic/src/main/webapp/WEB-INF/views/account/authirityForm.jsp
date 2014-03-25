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
			$("#authCode").focus();
			//为inputForm注册validate函数
			$("#inputForm").validate({
				rules: {
					authCode: {
						remote: "${ctx}/authirity/checkAuthCode"
					},
					authName: {
						remote: "${ctx}/authirity/checkAuthName"
					}
				},
				messages: {
					authCode: {
						remote: "权限代码已存在"
					},
					authName: {
						remote: "权限名称已存在"
					}
				}
			});
		});
	</script>
</head>

<body>
	<form id="inputForm" action="${ctx}/authirity/Save" method="post" class="form-horizontal topForm">
		<fieldset>
			<legend><small>添加权限</small></legend>
			<div class="control-group">
				<label for="authCode" class="control-label">权限代码:</label>
				<div class="controls">
					<input type="text" id="authCode" name="authCode" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="authName" class="control-label">权限名称:</label>
				<div class="controls">
					<input type="text" id="authName" name="authName" class="input-large required" minlength="3"/>
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

#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ctx" value="${symbol_dollar}{pageContext.request.contextPath}"/>

<html>
<head>
	<title>用户注册</title>
	
	<script>
		${symbol_dollar}(document).ready(function() {
			//聚焦第一个输入框
			${symbol_dollar}("${symbol_pound}logName").focus();
			//为inputForm注册validate函数
			${symbol_dollar}("${symbol_pound}inputForm").validate({
				rules: {
					logName: {
						remote: "${symbol_dollar}{ctx}/register/checkLoginName"
					},
					// 此处错误信息的位置不对
					roleList:"required"
				},
				messages: {
					logName: {
						remote: "用户登录名已存在"
					}
				},
				// 默认会把出错信息显示在当前元素的后面
				errorPlacement: function(error, element) {
					if ( element.is(":radio")|| element.is(":checkbox") )
						error.appendTo ( element.parent().next() );
					else
						error.insertAfter( element );
					}
			});
		});
		
	</script>
</head>

<body>
	<form id="inputForm" action="${symbol_dollar}{ctx}/register" method="post" class="form-horizontal">
		<fieldset>
			<legend><small>用户注册</small></legend>
			<div class="control-group">
				<label for="logName" class="control-label">登录名:</label>
				<div class="controls">
					<input type="text" id="logName" name="logName" class="input-large required" minlength="3"/>
				</div>
			</div>
			<div class="control-group">
				<label for="name" class="control-label">用户名:</label>
				<div class="controls">
					<input type="text" id="name" name="name" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="plainPwd" class="control-label">密码:</label>
				<div class="controls">
					<input type="password" id="plainPwd" name="plainPwd" class="input-large required"/>
				</div>
			</div>
			<div class="control-group">
				<label for="confirmPassword" class="control-label">确认密码:</label>
				<div class="controls">
					<input type="password" id="confirmPassword" name="confirmPassword" class="input-large required" equalTo="${symbol_pound}plainPwd"/>
				</div>
			</div>
			
			<div class="control-group">
				<label for="groupList" class="control-label">角色:</label>
				<div class="controls">
				<c:forEach var="r" items="${symbol_dollar}{allRoles }">
					<label class="radio-inline">
						<input type="radio" name="roleList" value="${symbol_dollar}{r.id}">${symbol_dollar}{r.roleName }</input>
					</label>
				</c:forEach>
				</div>
			</div>	
			<!--  此处用jstl标签加载select -->
			<!--<div class="control-group">
				<label for="status" class="control-label">状态:</label>
				<div class="controls">
					<select>
						<c:forEach var="st" items="${symbol_dollar}{status}">
							<option value="st.key">${symbol_dollar}{st.value }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			--><div class="form-actions">
				<input id="submit_btn" class="btn btn-primary" type="submit" value="提交"/>&nbsp;	
				<input id="cancel_btn" class="btn" type="button" value="返回" onclick="history.back()"/>
			</div>
		</fieldset>
	</form>
</body>
</html>

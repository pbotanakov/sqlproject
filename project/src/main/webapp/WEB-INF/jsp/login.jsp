<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
</head>
<body>
	<form:form id="myForm" method="post" commandName="userLogin">
		<fieldset>
			<legend>User Login Form</legend>

			<div class="form-group">
				<label for="userNameInput" class="col-lg-3 control-label">User
					Name</label>
				<div class="col-lg-9">
					<form:input type="text" class="form-control" path="userName"
						id="userNameInput" placeholder="User Name" />
					<form:errors path="userName" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="passwordInput" class="col-lg-3 control-label">Password</label>
				<div class="col-lg-9">
					<form:input type="password" class="form-control" path="password"
						id="passwordInput" placeholder="Password" />
					<form:errors path="password" cssClass="error" />
				</div>
			</div>

			<div class="col-lg-9 col-lg-offset-3">
				<button class="btn btn-default">Cancel</button>

				<button class="btn btn-primary">Login</button>
			</div>

		</fieldset>
	</form:form>

</body>
</html>
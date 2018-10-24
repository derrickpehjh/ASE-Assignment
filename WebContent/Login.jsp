<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="sb" uri="/struts-bootstrap-tags"%>
<html>
<head>
<title>Login</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<sb:head />
<body>

	<!--action connect to struts.xml -->

	<div class="container">
		<s:form method="POST" action="logon" theme="bootstrap"
			cssClass="well form-vertical login_form">
			<s:textfield name="userName" label="User Name"
				placeholder="Login" />
			<s:password name="password" label="Password"
				placeholder="Password" />
			<s:submit name="submit" id="submitd" label="Submit"
				cssClass="btn btn-primary" />
			<br />
			<br />
			<strong><s:text name="%{errorMsg}" /></strong>
		</s:form>

	</div>

</body>

<style type="text/css">
.container {position relative;
	
}

.login_form {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
	width: 400px;
	height: 250px;
	border: none;
}
</style>
</html>
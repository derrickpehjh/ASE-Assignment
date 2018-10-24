<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"><%@page
	language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Homepage</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>


	<h2>
		Welcome
		<s:property value="userName" />
	</h2>

	<div class="container">
		<div class="centre">
			<h1>Successful Login</h1>
		</div>
	</div>
</body>

<style type="text/css">
.container {position relative;
	
}

.centre {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
</html>
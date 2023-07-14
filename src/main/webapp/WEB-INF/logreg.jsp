<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
	<h1>Register</h1>
	<form:form action="/users/register" method="post" modelAttribute="newUser">
		<div class="form-group">
			<form:label path="userName">Username: </form:label>
			<form:input path="userName" type="text" class="form-control"/>
			<form:errors path="userName" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="email">Email: </form:label>
			<form:input path="email" class="form-control" />
			<form:errors path="userName" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="password">Password: </form:label>
			<form:input path="password" class="form-control" />
			<form:errors path="password" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="confirm">Confirm Password: </form:label>
			<form:input path="confirm" class="form-control" />
			<form:errors path="confirm" class="text-danger" />
		</div>
	<button type="submit" class="btn btn-outline-primary" style="margin: 10px;" >Register</button>
	</form:form>
	<h1>Login</h1>
	<form:form action="/users/login" method="post" modelAttribute="newUser">
		<div class="form-group">
			<form:label path="email">Email: </form:label>
			<form:input path="email" class="form-control" />
			<form:errors path="userName" class="text-danger" />
		</div>
		<div class="form-group">
			<form:label path="password">Password: </form:label>
			<form:input path="password" class="form-control" />
			<form:errors path="password" class="text-danger" />
		</div>
		<button type="submit" class="btn btn-outline-primary" style="margin: 10px;" >Login</button>
	</form:form>
	<a href="/"><button class="btn btn-outline-primary" style="margin: 10px;" >Home</button></a>
</div>
</body>
</html>
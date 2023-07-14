<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<title>Dashboard</title>
</head>
<body>
<div style="width: 500px; text-align: center;" >
<h1>Welcome! <c:out value="${userName }" /></h1>
<h3>This is your dashboard. Nothing to see here yet!</h3>
<a href="/users/logout"><button class="btn btn-outline-danger" style="margin: 10px;" >Logout</button></a>
</div>
</body>
</html>
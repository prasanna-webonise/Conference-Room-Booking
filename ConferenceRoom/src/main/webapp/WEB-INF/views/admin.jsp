<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/properties.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<title>Insert title here</title>
</head>
<body align="center">
	<header>
	<div class="container">
		<a href="" class="logo"></a>
		<ul>
			<li><label class="user"> Hello
					${pageContext.request.userPrincipal.name} !!</label></li>
			<li><c:url var="logoutUrl" value="j_spring_security_logout" />
				<form action="${logoutUrl}" method="post">
					<input class="btn" type="submit" value="Log out" /> <input
						type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
				</form></li>
			<li class="clear"></li>

		</ul>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	</header>

	<div class="maincontent">
		<div class="container">
			<br /> <br />
			<h1>Admin profile page !!!</h1>
			<h2>Click to perform</h2>


			<a href="admin/viewallrooms">view All Room Details</a> <br />
			<br /> <a href="admin/addroom">Add new room into the System</a> <br />
			<br /> <a href="admin/viewallusers">view All User Details</a> <br />
			<br /> <a href="admin/deleteroom">Delete selected Room</a> <br />
			<br />
		</div>
	</div>
</body>
</html>
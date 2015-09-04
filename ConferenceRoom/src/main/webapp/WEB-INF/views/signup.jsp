<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<spring:url value="/resources/css/properties.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<title>Add User</title>
</head>
<body>

	<header>
	<div class="container">
		<a href="" class="logo"> </a>
		<ul>
			<li><a href="home">HOME</a></li>
			<li><a href="login">LOGIN</a></li>
			<li class="clear"></li>
		</ul>
		<div class="clear"></div>
	</div>
	<div class="clear"></div>
	</header>


	<div class="maincontent">
		<div class="container">
			<br /> <br />
			<h1>Enter the Employee's Details</h1>
			<form:form action="signupcomplete" method="post"
				modelAttribute="employee">
				
				${message }<br />
				<table class="tablecontainer">
					<tr>
						<td>Employee ID</td>
						<td><form:input type="text" name="employeeId"
								path="employeeId" /></td>

					</tr>
					<tr>
						<td>Employee Name</td>
						<td><form:input type="text" name="employeeName"
								path="employeeName" /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><form:input type="text" name="password" path="password" /></td>
					</tr>
					<tr>
						<td>City</td>
						<td><form:input type="text" name="city" path="city" /></td>
					</tr>

					<tr>
						<td><input type="reset" value="RESET DATA"></td>
						<td><input type="submit" value="REGISTER"></td>
					</tr>

				</table>
			</form:form>
		</div>
	</div>
</body>
</html>
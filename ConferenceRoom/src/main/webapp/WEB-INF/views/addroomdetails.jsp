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
			<li><a href="/crbs/admin">HOME</a></li>
			<li><c:url var="logoutUrl" value="/j_spring_security_logout" />
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
			<br /> <br /> <br /> ${message } <br /> <br />
			<h1>ENTER ROOM DETAILS</h1>

			<form:form action="roomdetails" method="post" modelAttribute="room">
				<table class="tablecontainer">
					<tr>
						<td>Floor Number</td>
						<td><form:select path="floorNo" name="floorNo">
								<option>3</option>
								<option>5</option>
							</form:select></td>
						<%-- <form:input type="text" name="floorNo" path="floorNo" /></td> --%>
					</tr>
					<tr>
						<td>Description</td>
						<td><form:textarea name="description" path="description" /></td>
					</tr>
					<tr>
						<td>Capacity</td>

						<td><%-- <form:select path="capacity" name="capacity">
								<option>3</option>
								<option>4</option>
							</form:select> --%>
						<form:input type="text" name="capacity" path="capacity" />
						</td>
					</tr>


					<tr>
						<td><input type="reset" value="RESET DATA"></td>
						<td><input type="submit" value="ADD ROOM"></td>

					</tr>
				</table>
			</form:form>
		</div>
	</div>
</body>
</html>
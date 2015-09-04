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
			<li><a href="/crbs/user">HOME</a></li>
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

			<h2>Select the Room</h2>

			<form:form action="bookroom" method="post">
				<select name="roomNumber" title="RoomId">
					<c:forEach var="roomNumber" items="${roomList}">
						<option value="${roomNumber.roomId}">room
							${roomNumber.roomId} floor ${roomNumber.floorNo}</option>
					</c:forEach>
				</select>
				<br />
				<br />
				<br />
				<input type="submit" value="select">
			</form:form>
		</div>
	</div>
</body>
</html>
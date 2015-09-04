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
<script type="text/javascript">
	
</script>
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
			<br /> <br />
			<h1>Status</h1>
			<br />
			<br /> ${message }

			<form:form action="compltedbooking" method="post"
				commandName="scheduleDetail">
				<table class="tablecontainer">
					<tr>
						<td>Room number :</td>
						<td><form:input path="room.roomId" type="text" name="roomId"
								value="${room.getRoomId() }" readonly="true" /></td>
					</tr>
					<form:input path="employee.employeeId" type="hidden"
						name="employeeId"
						value="${pageContext.request.userPrincipal.name} " readonly="true" />
					<tr>
						<td>enter comments :</td>
						<td><form:textarea path="comment" type="text" name="comment" /></td>
					</tr>
					<tr>
						<td>Select Date :</td>
						<td><form:input path="scheduleDate" type="Date" id="date"
								name="date" /></td>
					</tr>


					<tr>
						<td>FROM TIME</td>
						<td><form:select path="startTime" id="fromTime"
								name="fromTime">
								<option>10 am</option>
								<option>11 am</option>
								<option>12 pm</option>
								<option>1 pm</option>
								<option>2 pm</option>
								<option>3 pm</option>
								<option>4 pm</option>
							</form:select></td>

					</tr>
					<tr>

						<td>TO TIME</td>
						<td><form:select path="endTime" id="fromTime" name="toTime">
								<option>11 am</option>
								<option>12 pm</option>
								<option>1 pm</option>
								<option>2 pm</option>
								<option>3 pm</option>
								<option>4 pm</option>
							</form:select></td>
					</tr>

					<tr>
						<td><input type="submit" value="book"></td>
					</tr>
				</table>

			</form:form>
		</div>
	</div>
</body>
</html>
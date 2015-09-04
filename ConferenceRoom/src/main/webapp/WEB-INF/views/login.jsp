<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<spring:url value="/resources/css/properties.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<title>Login</title>
</head>
<body align="center">
	<header>
		<div class="container">
			<a href="" class="logo"> </a>
			<ul>
				<li><a href="home">HOME</a></li>
				<li class="clear"></li>
			</ul>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</header>



	<div class="maincontent">
		<div class="container">

			<br /> <br /> <br />
			<h2>Please enter your username and password to login !</h2>
			<br /> <span style="color: red">${message}</span> <br />
			<form:form method="post" action="j_spring_security_check"
				modelAttribute="employee">
				<table class="tablecontainer">
					<tr>
						<td>Employee ID:</td>
						<td><form:input type="text" path="employeeId" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><form:input type="password" path="password" /></td>
					</tr>

					<tr>
						<td>&nbsp;</td>
						<td><input type="submit" value="Login"/></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>

</body>
</html>
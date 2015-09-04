<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>

<head>
<spring:url value="/resources/css/properties.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
<title>User Profile Page</title>
</head>
<body>

	<header>
		<div class="container">
			<a href="" class="logo"> </a>
			<ul>
				<li><label class="user"> Hello
						${pageContext.request.userPrincipal.name} !!</label></li>
				<li><c:url var="logoutUrl" value="j_spring_security_logout" />
					<form action="${logoutUrl}" method="post">
						<input class="btn" type="submit" value="Log out" /> <input
							type="hidden" name="${_csrf.parameterName}"
							value="${_csrf.token}" />
					</form></li>
				<li class="clear"></li>

			</ul>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</header>

	<div class="maincontent">
		<div class="container">
			<br />
			<h1>User profile page !!!</h1>

			<h3>Click on the task you want to perform !</h3>
			<br /> <br /> <a href="user/viewallrooms">View all rooms</a> <br />
			<br /> <a href="user/bookingroom">Book a Room</a> <br /> <br /> <a
				href="user/viewMyBookings">View my Bookings</a>
		</div>
	</div>
</body>
</html>
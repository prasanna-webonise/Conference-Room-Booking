<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<title>Home Page</title>
<spring:url value="/resources/css/properties.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
</head>
<body>

	<header>
		<div class="container">
			<a href="" class="logo"></a>
			<ul>
				<li><a href="signup">SIGN UP</a></li>
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
			<h1>WELCOME TO CONFERENCE ROOM BOOKING</h1>
		</div>
	</div>
	<br />
	<br />
</body>
</html>
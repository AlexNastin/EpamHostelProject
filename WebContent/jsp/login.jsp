<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="title.jsp"%>
<%@ include file="lang.jsp"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Weclome</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.login" var="loc" />
<fmt:message bundle="${loc}" key="login.pass" var="pass" />
<fmt:message bundle="${loc}" key="login.name" var="name" />
<fmt:message bundle="${loc}" key="login.email" var="email" />
<fmt:message bundle="${loc}" key="login.register" var="register" />
<fmt:message bundle="${loc}" key="login.locbutton.log" var="log" />
<fmt:message bundle="${loc}" key="login.log.name" var="namelog" />
</head>
<body>
	<div class="container">
		<section id="content">
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="login">
				<h1>${namelog}</h1>
				<div>
					<input type="text" name="userLogin" placeholder="${name}" value=""
						required="required"
						pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$">
				</div>
				<div>
					<input type="password" name="userPassword" value=""
						placeholder="${pass}" required="required">
				</div>
				<div>
					<input type="submit" value="${log}"> <a
						href="Controller?command=goregister">${register}</a>
				</div>
			</form>
		</section>
	</div>
</body>
</html>
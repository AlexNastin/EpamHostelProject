<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="title.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />

<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.register" var="loc" />
<fmt:message bundle="${loc}" key="register.message" var="message" />
<fmt:message bundle="${loc}" key="register.name" var="name" />
<fmt:message bundle="${loc}" key="register.surname" var="surname" />
<fmt:message bundle="${loc}" key="register.numpass" var="numpass" />
<fmt:message bundle="${loc}" key="register.login" var="login" />
<fmt:message bundle="${loc}" key="register.password" var="password" />
<fmt:message bundle="${loc}" key="register.passwordmatch"
	var="passwordmatch" />





</head>
<body>
	<div class="container">
		<section id="content">
			<form action="Controller" method="post">
				<input type="hidden" name="command" value="register">
				<table border="1">
					<tr>
						<td><input placeholder="${name}" type="text" name="userName"
							required="required" value=""></td>
					</tr>
					<tr>
						<td><input placeholder="${surname}" type="text"
							name="userSurname" required="required" value=""></td>
					</tr>
					<tr>
						<td><input placeholder="${numpass}" type="text"
							name="userNumpass" required="required" value=""></td>
					</tr>
					<tr>
						<td><input placeholder="${login}" type="text"
							name="userLogin" required="required"
							pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$" value=""></td>
					</tr>
					<tr>
						<td><input placeholder="${password}" type="password"
							name="userPassword" value="" required="required"></td>
					</tr>
					<tr>
					<tr>
						<td><input placeholder="${passwordmatch}" type="password"
							name="userPasswordMatch" required="required" value=""></td>
					</tr>
					<tr>
						<td><input type="submit" value="${message}"></td>
					</tr>
				</table>
			</form>
		</section>
	</div>
</body>
</html>
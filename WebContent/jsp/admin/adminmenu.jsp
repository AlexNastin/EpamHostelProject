<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adminmenu</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.admin" var="loc" />
<fmt:message bundle="${loc}" key="admin.message" var="message" />
<fmt:message bundle="${loc}" key="admin.exit" var="exit" />
<fmt:message bundle="${loc}" key="admin.users" var="usersBut" />
<fmt:message bundle="${loc}" key="admin.orders" var="ordersBut" />
<fmt:message bundle="${loc}" key="admin.rooms" var="roomsBut" />

</head>
<body>
	<div class="div_button_1">
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="admin_use_user"> <input
		 	type="submit" value="${usersBut}">
	</form>
	</div>
	<div class="div_button_1">
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="admin_use_orders"> 
		<input type="submit" value="${ordersBut}">
	</form>
	</div>
	<div class="div_button_1">
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="admin_use_rooms"> <input
		  type="submit" value="${roomsBut}">
	</form>
	</div>
	<div class="div_button_1">
		<form action="Controller" method="post">
		<input type="hidden" name="command" value="logout"> <input
			type="submit" value="${exit}">
	</form>
	</div>
</body>
</html>
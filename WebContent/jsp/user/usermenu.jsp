<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.usermenu" var="loc" />
<fmt:message bundle="${loc}" key="user.exit" var="exit" />
<fmt:message bundle="${loc}" key="user.makeorder" var="makeorder" />
<fmt:message bundle="${loc}" key="user.orders" var="ordersBut" />

<body>
	<div class="div_button_1">
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="userorders"> <input
			type="submit" value="${ordersBut}">
	</form>
	</div>
	<div class="div_button_1">
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="gofilldate"> <input
			type="submit" value="${makeorder}">
	</form>
	</div>
	<div class="div_button_1">
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="logout"> <input
			type="submit" value="${exit}">
	</form>
	</div>
</body>
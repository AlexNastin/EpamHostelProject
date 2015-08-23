<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserMenu</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.user" var="loc" />
<fmt:message bundle="${loc}" key="user.order.idorder" var="idorder" />
<fmt:message bundle="${loc}" key="user.order.arrival" var="arrival" />
<fmt:message bundle="${loc}" key="user.order.departure" var="departure" />
<fmt:message bundle="${loc}" key="user.room.idroom" var="idroom" />
<fmt:message bundle="${loc}" key="user.room.price" var="price" />
<fmt:message bundle="${loc}" key="user.room.category" var="category" />
<fmt:message bundle="${loc}" key="user.room.capacity" var="capacity" />

</head>
<body>
	<div class="content">
	<div class="titlehotel">
		<%@ include file="/jsp/title.jsp"%>
	</div>
	<div class="menu_order">
		<div class="menu_order_in">
			<%@ include file="/jsp/user/usermenu.jsp"%>
		</div>
	</div>
	<table   class="table-hotel">
		<tr>
			<td>${idorder}</td>
			<td>${idroom}</td>
			<td>${price}</td>
			<td>${category}</td>
			<td>${capacity}</td>
			<td>${arrival}</td>
			<td>${departure}</td>
		</tr>
		<c:forEach items="${userorders}" var="userorders">
			<tr>
				<td>${userorders.idOrder}</td>
				<td>${userorders.room.idRoom}</td>
				<td>${userorders.room.price}</td>
				<td>${userorders.room.category}</td>
				<td>${userorders.room.capacity}</td>
				<td>${userorders.arrival}</td>
				<td>${userorders.departure}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
</body>
</html>
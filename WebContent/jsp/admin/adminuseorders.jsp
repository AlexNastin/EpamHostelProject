<%@page import="by.epam.hostel.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminOrders</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.admin" var="loc" />
<c:if test="${error != null}">
	<fmt:message bundle="${loc}" key="${error}" var="notfind" />
</c:if>
<fmt:message bundle="${loc}" key="admin.order.idorder" var="idorder" />
<fmt:message bundle="${loc}" key="admin.user.name" var="nameuser" />
<fmt:message bundle="${loc}" key="admin.user.surname" var="surnameuser" />
<fmt:message bundle="${loc}" key="admin.user.numpass" var="numpass" />
<fmt:message bundle="${loc}" key="admin.room.idroom" var="idroom" />
<fmt:message bundle="${loc}" key="admin.room.price" var="price" />
<fmt:message bundle="${loc}" key="admin.room.category" var="category" />
<fmt:message bundle="${loc}" key="admin.room.capacity" var="capacity" />
<fmt:message bundle="${loc}" key="admin.order.arrival" var="arrival" />
<fmt:message bundle="${loc}" key="admin.order.departure" var="departure" />
<fmt:message bundle="${loc}" key="admin.order.paid" var="paid" />
</head>
<body>
	<div class="content">
		<div class="titlehotel">
			<%@ include file="/jsp/title.jsp"%>
		</div>
		<div class="menu_order">
			<div class="menu_order_in_admin">
				<%@ include file="/jsp/admin/adminmenu.jsp"%>
			</div>
		</div>
		<table border="1" class="table-hotel">
			<tr>
				<td>${idorder}</td>
				<td>${nameuser}</td>
				<td>${surnameuser}</td>
				<td>${numpass}</td>
				<td>${idroom}</td>
				<td>${price}</td>
				<td>${category}</td>
				<td>${capacity}</td>
				<td>${arrival}</td>
				<td>${departure}</td>
				<td>${paid}</td>
			</tr>
			<c:forEach items="${orders}" var="orders">
				<tr>
					<td>${orders.idOrder}</td>
					<td>${orders.user.name}</td>
					<td>${orders.user.surname}</td>
					<td>${orders.user.numpass}</td>
					<td>${orders.room.idRoom}</td>
					<td>${orders.room.price}</td>
					<td>${orders.room.category}</td>
					<td>${orders.room.capacity}</td>
					<td>${orders.arrival}</td>
					<td>${orders.departure}</td>
					<td><a
						href="Controller?command=setpaid&idOrder=${orders.idOrder}&paid=${orders.paid}">${orders.paid}</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>
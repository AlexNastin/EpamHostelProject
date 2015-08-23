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
<title>AdminRooms</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.admin" var="loc" />
<fmt:message bundle="${loc}" key="admin.find" var="find" />
<c:if test="${error != null}">
	<fmt:message bundle="${loc}" key="${error}" var="notfind" />
</c:if>
<fmt:message bundle="${loc}" key="admin.room.idroom" var="idroom" />
<fmt:message bundle="${loc}" key="admin.room.booking" var="booking" />
<fmt:message bundle="${loc}" key="admin.room.notbooking"
	var="notbooking" />
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
		<div class="form_area">
			<table border="1" class="table-hotel">
				<tr>
					<td>${idroom}</td>
					<td>${booking}</td>
					<td>${notbooking}</td>
				</tr>
				<c:forEach items="${bookeddates}" var="bookeddates">
					<tr class="even">
						<td>${bookeddates.idRoom}</td>
						<td>${bookeddates.booking}</td>
						<td>${bookeddates.notBooking}</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>
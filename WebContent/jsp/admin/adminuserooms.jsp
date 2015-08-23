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
<fmt:message bundle="${loc}" key="admin.room.price" var="price" />
<fmt:message bundle="${loc}" key="admin.room.category" var="category" />
<fmt:message bundle="${loc}" key="admin.room.capacity" var="capacity" />
<fmt:message bundle="${loc}" key="admin.room.isdeleted" var="isdeleted" />
<fmt:message bundle="${loc}" key="admin.room.insertroom"
	var="insertroom" />
<fmt:message bundle="${loc}" key="admin.room.booked" var="booked" />
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
	<div class="table_area">
	<table border="1" class="table-hotel">
		<tr>
			<td>${idroom}</td>
			<td>${price}</td>
			<td>${category}</td>
			<td>${capacity}</td>
			<td>${isdeleted}</td>
		</tr>
		<c:forEach items="${rooms}" var="rooms">

			<tr>
				<td>${rooms.idRoom}</td>
				<td>${rooms.price}</td>
				<td>${rooms.category}</td>
				<td>${rooms.capacity}</td>
				<td>${rooms.deleted}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div class="table_area_input_admin_id">
	<form action="Controller" class="table-hotel">
		<input type="hidden" name="command" value="getroom"> <br /> <input
			type="text" name="idRoom" placeholder="" required="required" pattern="[0-9]+" >
			<div class="find_button">
		<br /> <input type="submit" value="${find}" class="find_button">	
		</div>
	</form>
	${notfind}
	</div>
	<div class="button_right_admin">
	<form action="Controller" >
		<input type="hidden" name="command" value="showbooked"> <input
			type="submit" value="${booked}" class="right_button">
	</form>
	<form action="Controller" >
	<input type="hidden" name="command" value="goinsertroom"> <input
		type="submit" value="${insertroom}" class="right_button">
</form>
</div>
	</div>
</body>
</html>
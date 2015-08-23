<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Booked</title>
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

<fmt:message bundle="${loc}" key="user.picks.selection" var="selection" />
<fmt:message bundle="${loc}" key="user.picks.price" var="pricesel" />
<fmt:message bundle="${loc}" key="user.picks.capacity" var="capacitysel" />
<fmt:message bundle="${loc}" key="user.picks.find" var="find" />
<fmt:message bundle="${loc}" key="user.picks.book" var="book" />
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
	<div class="table_area">
	<table class="table-hotel">
		<tr>
			<td>${idroom}</td>
			<td>${price}</td>
			<td>${category}</td>
			<td>${capacity}</td>
			<td>${book}</td>
		</tr>
		<c:forEach items="${sessionScope.freerooms}" var="freerooms">
			<tr>
				<td>${freerooms.idRoom}</td>
				<td>${freerooms.price}</td>
				<td>${freerooms.category}</td>
				<td>${freerooms.capacity}</td>
				<td><a
					href="Controller?command=booked&idRoom=${freerooms.idRoom}">${book}</a></td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div class="table_area_input">
	<form action="Controller" method="post">
		<input type="hidden" name="command" value="samplerooms">
		<div class="message">
		${selection}<br>
		</div>
		<table border="1" class="table-hotel">
			<tr>

				<td><input type="text" name="price" placeholder="${price}"
					value="" pattern="[0-9]+"></td>
			</tr>
			<tr>
				<td><input type="radio" name="category" value="LUX">LUX
					<input type="radio" name="category" value="SUPER_LUX">SUPER_LUX
					<input type="radio" name="category" value="ECONOM">ECONOM <input
					type="radio" name="category" value="FAMILY">FAMILY <input
					type="radio" name="category" value="ALL" checked="checked">ALL
				</td>
			</tr>
			<tr>
				<td><input type="text" name="capacity"
					placeholder="${capacity}" required="required" pattern="[0-9]+"></td>
			</tr>
		</table>
		<div class="find_button">
		<input type="submit" value="${find}" class="find_button">
		</div>
	</form>
	</div>
	</div>

	
	
</body>
</html>
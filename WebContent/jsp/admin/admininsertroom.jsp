<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>InsertRoom</title>
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
	<form action="Controller">
		<input type="hidden" name="command" value="insertroom" />
		<table class="table-hotel">
			<tr>
				<td>${idroom}</td>
				<td><input type="text" name="idRoom" required="required"
					value="" pattern="[0-9]+"></td>
			</tr>
			<tr>
				<td>${price}</td>
				<td><input type="text" name="price" value=""  required="required" pattern="\d+\.{0,1}\d*$"></td>
			</tr>
			<tr>
				<td>${category}</td>
				<td><input type="radio" name="category" value="LUX">LUX
					<input type="radio" name="category" value="SUPER_LUX">SUPER_LUX
					<input type="radio" name="category" value="ECONOM"
					checked="checked">ECONOM <input type="radio"
					name="category" value="FAMILY">FAMILY</td>

			</tr>
			<tr>
				<td>${capacity}</td>
				<td><input type="text" name="capacity"  required="required" value="" pattern="[0-9]+"></td>
			</tr>
		</table>
		<div class="done_button">
		<input type="submit" class="done_button"/>
		</div>
	</form>
	</div>
</div>
</body>
</html>
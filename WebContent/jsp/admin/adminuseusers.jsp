<%@page import="by.epam.hostel.entity.User"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@ taglib prefix="ctg" uri="/WEB-INF/taglib.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>AdminUsers</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.admin" var="loc" />
<fmt:message bundle="${loc}" key="admin.find" var="find" />
<c:if test="${error != null}">
	<fmt:message bundle="${loc}" key="${error}" var="notfind" />
</c:if>
<fmt:message bundle="${loc}" key="admin.madeadmin" var="madeadmin" />
<fmt:message bundle="${loc}" key="admin.addblacklist" var="addblacklist" />
<fmt:message bundle="${loc}" key="admin.user.iduser" var="lociduser" />
<fmt:message bundle="${loc}" key="admin.user.name" var="nameuser" />
<fmt:message bundle="${loc}" key="admin.user.surname" var="surnameuser" />
<fmt:message bundle="${loc}" key="admin.user.numpass" var="numpass" />


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
			<td>${lociduser}</td>
			<td>${nameuser}</td>
			<td>${surnameuser}</td>
			<td>${numpass}</td>
		</tr>
		<c:forEach items="${users}" var="users">

			<tr class="even">
				<td>${users.idUser}</td>
				<td>${users.name}</td>
				<td>${users.surname}</td>
				<td>${users.numpass}</td>
			</tr>
		</c:forEach>
	</table>
	</div>
	<div class="table_area_input_admin_id">
	<form action="Controller" class="table-hotel">
		<input type="hidden" name="command" value="getuser"> <br /> <input
			type="text" name="idUser" placeholder="" required="required" pattern="[0-9]+">
			<div class="find_button">
		<br /> <input type="submit" value="${find}" class="find_button">
		</div>
	</form>
	${notfind}
	</div>
</div>





	
	
</body>
</html>
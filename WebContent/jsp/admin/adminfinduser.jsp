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
<title>AdminUser</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.admin" var="loc" />
<fmt:message bundle="${loc}" key="admin.user.iduser" var="lociduser" />
<fmt:message bundle="${loc}" key="admin.user.name" var="nameuser" />
<fmt:message bundle="${loc}" key="admin.user.surname" var="surnameuser" />
<fmt:message bundle="${loc}" key="admin.user.numpass" var="numpass" />
<fmt:message bundle="${loc}" key="admin.user.email" var="email" />
<fmt:message bundle="${loc}" key="admin.user.status" var="status" />
<fmt:message bundle="${loc}" key="admin.user.blacklist" var="blacklist" />

</head>
<div class="content">
	<div class="titlehotel">
		<%@ include file="/jsp/title.jsp"%>
	</div>
	<div class="menu_order">
		<div class="menu_order_in_admin">
			<%@ include file="/jsp/admin/adminmenu.jsp"%>
		</div>
	</div>
	<div class="table_area_user_find">
	<table border="1" class="table-hotel">
	<tr>
			<td>${lociduser}</td>
			<td>${nameuser}</td>
			<td>${surnameuser}</td>
			<td>${numpass}</td>
			<td>${email}</td>
			<td>${status}</td>
			<td>${blacklist}</td>
		</tr>
		<tr  class="even">
			<td>${user.idUser}</td>
			<td>${user.name}</td>
			<td>${user.surname}</td>
			<td>${user.numpass}</td>
			<td>${user.login.login}</td>
			<td><a href="Controller?command=makeadmin&idUser=${user.idUser}&status=${user.login.status}">${user.login.status}</a></td>
			<td><a href="Controller?command=addblacklist&idUser=${user.idUser}&blacklist=${user.login.blacklist}">${user.login.blacklist}</a></td>
		</tr>
	</table>
	</div>
	</div>
</body>
</html>
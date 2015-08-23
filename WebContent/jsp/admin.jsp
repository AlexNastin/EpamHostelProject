<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.admin" var="loc" />
<fmt:message bundle="${loc}" key="admin.message" var="message" />
<body>
<div class="content">
	<div class="titlehotel">
		<%@ include file="title.jsp"%>
	</div>
	<div class="menu_order">
		<div class="menu_order_in_admin">
			<%@ include file="/jsp/admin/adminmenu.jsp"%>
		</div>
	</div>
	<div class="info_text_area">
	<div class="text">
	<c:out  value="${message}" />
	<c:out value="${sessionScope.userLogin}" />
	</div>
	</div>
</div>




</body>
</html>
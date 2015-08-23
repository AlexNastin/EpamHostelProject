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
<fmt:setBundle basename="by.epam.hostel.localization.user" var="loc" />
<fmt:message bundle="${loc}" key="user.message" var="message" />
<c:if test="${info != null}">
	<fmt:message bundle="${loc}" key="${info}" var="infouser" />
</c:if>
<c:if test="${info != null}">
<fmt:message bundle="${loc}" key="user.allprice" var="allprice" />
</c:if>
</head>
<body>
	<div class="content">
	<div class="titlehotel">
		<%@ include file="title.jsp"%>
	</div>
	<div class="menu_order">
		<div class="menu_order_in">
			<%@ include file="/jsp/user/usermenu.jsp"%>
		</div>
	</div>
	<div class="info_text_area">
		<div class="text">
			<c:out value="${message}" />
			<c:out value="${sessionScope.userLogin}" />
			<br />
			<c:out value="${infouser}" />
			<c:out value="${allprice}" />
			<c:out value="${totalPrice}" />
			
		</div>
	</div>
	</div>
</body>
</html>
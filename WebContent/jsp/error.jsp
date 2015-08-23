<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.error" var="loc" />
<fmt:message bundle="${loc}" key="error.name" var="name" />
<c:if test="${errorPasswordNotMatch != null}">
	<fmt:message bundle="${loc}" key="${errorPasswordNotMatch}"
		var="passwordNotMatch" />
</c:if>
<c:if test="${fieldNot != null}">
	<fmt:message bundle="${loc}" key="${fieldNot}" var="fieldNotMessage" />
</c:if>
<c:if test="${regexLogin != null}">
	<fmt:message bundle="${loc}" key="${regexLogin}" var="errorlogin" />
</c:if>
<fmt:message bundle="${loc}" key="error.link" var="link" />
</head>
<body>
	<div class="content">
		<div class="titlehotel">
			<%@ include file="title.jsp"%>
		</div>
		<div class="message_error">
			${name}<br /> ${passwordNotMatch} <br /> ${fieldNotMessage} <br />
			${errorlogin} <br /> <a href="index.jsp">${link}</a>
		</div>
	</div>
</body>
</html>
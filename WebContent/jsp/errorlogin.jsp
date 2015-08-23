<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error filling in the form</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.errorlogin"
	var="loc" />
<fmt:message bundle="${loc}" key="errorlogin.message" var="message" />
<fmt:message bundle="${loc}" key="errorlogin.link" var="link" />
</head>
<body>
<div class="content">
	<div class="titlehotel">
		<%@ include file="title.jsp"%>
	</div>
	<div class="message_error">
	${message}
	<br /> <a href="index.jsp">${link}</a>
		</div>
	</div>
</body>
</html>
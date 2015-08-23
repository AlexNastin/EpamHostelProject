<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.title" var="loc" />
<fmt:message bundle="${loc}" key="title.name" var="title" />
<fmt:message bundle="${loc}" key="title.locbutton.name.en"
	var="en_button" />
<fmt:message bundle="${loc}" key="title.locbutton.name.ru"
	var="ru_button" />
<body>
	<div class="titlehoteltext">
		${title}
	</div>
</body>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="ctg" uri="/WEB-INF/taglib.tld" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>UserFillDate</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.user" var="loc" />

<fmt:message bundle="${loc}" key="user.filldate.message" var="message" />
<fmt:message bundle="${loc}" key="user.filldate.arrival" var="arrival" />
<fmt:message bundle="${loc}" key="user.filldate.departure"
	var="departure" />
<fmt:message bundle="${loc}" key="user.filldate.day" var="day" />
<fmt:message bundle="${loc}" key="user.filldate.month" var="month" />
<fmt:message bundle="${loc}" key="user.filldate.year" var="year" />
<fmt:message bundle="${loc}" key="user.filldate.find" var="find" />
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
	<div class="date_info">
	<ctg:resource locale="${requestScope.locale}"/>
	</div>
	<div class="message">${message}</div>
	<div class="form_area">
	<form action="Controller" method="post">
	<input type="hidden" name="command" value="checkdate">
	<table  class="table-hotel">
		<tr>
			<th>${arrival}</th>
			<td><input type="text" name="aday" value="" placeholder="${day}"
				size="1" required="required" pattern="[0-9]{2}"></td>
			<td><input type="text" name="amonth" value=""
				placeholder="${month}" size="1" required="required" pattern="[0-9]{2}"></td>
			<td><input type="text" name="ayear" value=""
				placeholder="${year}" size="1" required="required" pattern="[0-9]{4}"></td>
		</tr>
		<tr>
			<th>${departure}</th>
			<td><input type="text" name="dday" value="" placeholder="${day}"
				size="1" required="required" pattern="[0-9]{2}"></td>
			<td><input type="text" name="dmonth" value=""
				placeholder="${month}" size="1" required="required" pattern="[0-9]{2}"></td>
			<td><input type="text" name="dyear" value=""
				placeholder="${year}" size="1" required="required" pattern="[0-9]{4}"></td>
		</tr>
	</table>
	<div class="find_button">
	<input type="submit" class="find_button" value="${find}">
	</div>
	</form>
	</div>
	</div>
	
		
	
	
</body>

</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>
</head>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<fmt:setLocale value="${sessionScope.locale}" />
<fmt:setBundle basename="by.epam.hostel.localization.title" var="loc" />
<fmt:message bundle="${loc}" key="title.locbutton.name.en"
	var="en_button" />
<fmt:message bundle="${loc}" key="title.locbutton.name.ru"
	var="ru_button" />
<fmt:message bundle="${loc}" key="title.locbutton.name" var="loc_button" />
</head>
<body>
	<div class="lang">
		<form action="Controller" method="post">
			<table>
				<tr>
					<th><input type="hidden" name="command" value="locale">
						<input type="submit" class="lang" value="${loc_button}"></th>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
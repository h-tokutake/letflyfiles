<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login to Let Fly Files</title>
</head>
<body>
	<c:if test="${not empty logoutUrl}">
		<a href="/pushup">push up</a><br />
		<a href="<c:out value="${logoutUrl}" />">LOGOUT</a><br />
	</c:if>
	<c:if test="${not empty loginUrl}">
		<a href="<c:out value="${loginUrl}" />">LOGIN</a><br />
	</c:if>
</body>
</html>
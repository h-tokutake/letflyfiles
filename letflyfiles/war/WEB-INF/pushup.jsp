<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Push up something into the sky</title>
</head>
<body>
	<a href="/login">BACK to TOP</a><br />
	<form name="pushup" action="<c:out value="${uploadUrl}" />" method="POST" enctype="multipart/form-data">
		<input id="file" name="file" type="file" />
		<input id="submit" type="submit" />
	</form>
</body>
</html>
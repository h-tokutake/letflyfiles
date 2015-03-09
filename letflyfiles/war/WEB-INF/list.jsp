<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>List everything falling from the sky</title>
</head>
<body>
	<a href="/login">BACK to TOP</a><br />
	<table>
	<tr><th>filename</th><th>contentType</th><th>creation</th><th>size</th></tr>
	<c:forEach var="filename" items="${filename_list}" varStatus="status">
		<tr>
		<td><c:out value="${filename}" /></td>
		<td><c:out value="${contentType_list[status.index]}" /></td>
		<td><c:out value="${creation_list[status.index]}" /></td>
		<td><c:out value="${size_list[status.index]}" /></td>
		<td><a href="/serve?blobKey=<c:out value="${blobKey_list[status.index]}" />" target="_blank">DOWNLOAD</a></td>
		<td><a href="/delete?blobKey=<c:out value="${blobKey_list[status.index]}" />">DELETE</a></td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>
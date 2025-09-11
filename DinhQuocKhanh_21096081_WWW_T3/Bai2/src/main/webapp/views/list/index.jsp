<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ListUser</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>First name</th>
			<th>Last name</th>
			<th>Email</th>
		</tr>
		<c:forEach var="user" items="${users}">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.firstName}" /></td>
			</tr>
		</c:forEach>
	</table>
	<a href="${pageContext.request.contextPath }/user">Dang Ky</a>
</body>
</html>
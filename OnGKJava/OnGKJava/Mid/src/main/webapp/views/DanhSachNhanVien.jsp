<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<a href="${pageContext.request.contextPath}/themNV">Them nv</a>
	</div>
	<table>
		<tr>
			<th>Ten phong</th>
			<th>Ten nv</th>
		</tr>
		<c:forEach var="item" items="${nhanVien}">
			<tr>
				<td>${item.phongBan.tenPhongBan}</td>
				<td>${item.phongBan.maPhongBan}</td>
				<td>${item.tenNV}</td>
				<td>
					<form action="${pageContext.request.contextPath}/list"
						method="post">
						<input type="hidden" name="action" value="remove"> <input
							type="hidden" name="maNhanVien" value="${item.maNhanVien}">
						<input type="submit" value="Xóa">
					</form>
				</td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>
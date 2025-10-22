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
	<div class="container">
		<!-- Header -->
		<div></div>

		<!-- Menu -->
		<div></div>

		<!-- Content -->
		<div>
			<table class="cart-table" border="">
				<tr>
					<th>Ten</th>
					<th>NgaySX</th>
					<th>SoLuong</th>
					<th>HinhAnh</th>
				</tr>
	
				<c:forEach var="item" items="${dienThoai}">
					<tr>
						<td>${item.tenDT}</td>	
						<td>${item.ngaySX}</td>			
						<td>${item.soLuong}</td>
						<td>
						<img
							src="${pageContext.request.contextPath}/resources/images/${item.hinhAnh}"></td>
					</tr>
				</c:forEach>


			</table>
		</div>
	</div>
</body>
</html>
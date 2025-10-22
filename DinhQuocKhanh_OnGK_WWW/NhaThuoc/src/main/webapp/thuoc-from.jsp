<%--
  Created by IntelliJ IDEA.
  User: kioma
  Date: 9/30/2025
  Time: 6:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="loaithuoc">Danh sách các loại thuốc</a>
<a href="thuoc">Danh sách thuốc</a>
<a href="thuoc?action=CREATE">Thêm mới thuốc</a>
<h1>Thêm mới thuốc</h1>

<form action="thuoc" method="post">
    <div>
        <label> Tên thuốc: </label>
        <input name="tenThuoc" required>
    </div>    <div>
        <label> Giá: </label>
        <input name="gia" required>
    </div>    <div>
        <label> Năn sản xuất: </label>
        <input name="namSX" required type="number">

    <select name="loaiThuocId">
        <option value="All">Tất cả</option>
        <c:forEach items="${listLoaiThuoc}" var="loaiThuoc">
            <option value="${loaiThuoc.maLoai}">${loaiThuoc.tenLoai}</option>
        </c:forEach>
    </select>
    <button type="submit">Tạo mới</button>
</form>


</body>
</html>

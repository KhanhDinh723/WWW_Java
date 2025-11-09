<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head><title>Employee List</title></head>
<body>
<h2>Employee Management</h2>
<p><a href="/employees/new">Add Employee</a></p>

<table border="1" cellpadding="6" cellspacing="0">
    <thead>
    <tr>
        <th>First</th><th>Last</th><th>Gender</th><th>DOB</th>
        <th>Email</th><th>Phone</th><th>Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="e" items="${employees}">
        <tr>
            <td>${e.firstName}</td>
            <td>${e.lastName}</td>
            <td>${e.gender}</td>
            <td>${e.dob}</td>
            <td>${e.email}</td>
            <td>${e.phone}</td>
            <td>
                <a href="/employees/${e.id}/edit">Update</a> |
                <a href="/employees/${e.id}/delete" onclick="return confirm('Delete?')">Delete</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

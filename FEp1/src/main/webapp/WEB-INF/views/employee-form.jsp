<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head><title>${formTitle}</title></head>
<body>
<h2>${formTitle}</h2>
<form method="post" action="/employees/save">
    <input type="hidden" name="id" value="${employee.id}"/>
    <div>
        <label>First Name:</label>
        <input name="firstName" value="${employee.firstName}" required />
    </div>
    <div>
        <label>Last Name:</label>
        <input name="lastName" value="${employee.lastName}" required />
    </div>
    <div>
        <label>Gender:</label>
        <select name="gender">
            <option ${employee.gender=='Male'?'selected':''}>Male</option>
            <option ${employee.gender=='Female'?'selected':''}>Female</option>
        </select>
    </div>
    <div>
        <label>Date of Birth:</label>
        <input type="date" name="dob" value="${employee.dob}" />
    </div>
    <div>
        <label>Email:</label>
        <input type="email" name="email" value="${employee.email}" />
    </div>
    <div>
        <label>Phone:</label>
        <input name="phone" value="${employee.phone}" />
    </div>
    <div style="margin-top:10px;">
        <button type="submit">Save</button>
        <a href="/employees">Back</a>
    </div>
</form>
</body>
</html>

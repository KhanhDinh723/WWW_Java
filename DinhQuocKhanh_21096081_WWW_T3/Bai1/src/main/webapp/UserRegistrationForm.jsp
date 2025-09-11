<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	    <h2>User Registration Form</h2>
    <form>
        <table>
            <tr>
                <td colspan="1"><input type="text" name="firstName" placeholder="First Name" required></td>
                <td colspan="1"><input type="text" name="lastName" placeholder="Last Name" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="email" name="email" placeholder="Your Email" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="email" name="reenterEmail" placeholder="Re-enter Email" required></td>
            </tr>
            <tr>
                <td colspan="2"><input type="password" name="password" placeholder="New Password" required></td>
            </tr>
        </table>

        <label for="birthday">Birthday</label><br>
        <select name="month" required>
            <option value="">Month</option>
            <option value="1">January</option>
            <option value="2">February</option>
            <option value="3">March</option>
            <option value="4">April</option>
            <option value="5">May</option>
            <option value="6">June</option>
            <option value="7">July</option>
            <option value="8">August</option>
            <option value="9">September</option>
            <option value="10">October</option>
            <option value="11">November</option>
            <option value="12">December</option>
        </select>

        <select name="day" required>
            <option value="">Day</option>
            <% for (int i = 1; i <= 31; i++) { %>
                <option value="<%= i %>"><%= i %></option>
            <% } %>
        </select>

        <select name="year" required>
            <option value="">Year</option>
            <% int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR); %>
            <% for (int i = currentYear; i >= 1900; i--) { %>
                <option value="<%= i %>"><%= i %></option>
            <% } %>
        </select><br>

        <label>Gender:</label>
        <input type="radio" name="gender" value="female" required> Female
        <input type="radio" name="gender" value="male" required> Male<br>

        <button type="submit">Sign Up</button>
    </form>
</body>
</html>
<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 24.09.2020
  Time: 22:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register</title>
</head>
<body>
    <div align="center">
        <h1>User Register</h1>
        <form action="${pageContext.request.contextPath}/user" method="post">
            <table style="width: 80%">
                <tr>
                    <td>First Name</td>
                    <td><input type = "text" name="first_name"></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type = "text" name="last_name"></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type = "text" name="address"></td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td><input type = "text" name="username"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type = "password" name="password"></td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td><input type = "text" name="email"></td>
                </tr>
            </table>
        <input type="submit" value="Submit">
        </form>
    </div>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 28.09.2020
  Time: 23:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <script>
        function validate() {
            var username = document.form.username.value;
            var password = document.form.password.value;

            if (username == null || username == "") {
                alert("Username cannot be blank");
                return false;
            } else if (password == null || password == "") {
                alert("Password cannot be blank");
                return false;
            }
        }
    </script>
</head>
<body>
<div style="text-align:center"><h1>Login form </h1></div>
<br>
<form name="form" action="${pageContext.request.contextPath}/login" method="post" onsubmit="return validate()">
    <table align="center">
        <tr>
            <td>Username</td>
            <td><input type="text" name="username"/></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password"/></td>
        </tr>
        <tr> <!-- refer to the video to understand request.getAttribute() -->
            <td><span style="color:red"><%=(request.getAttribute("errMessage") == null) ? ""
                    : request.getAttribute("errMessage")%></span></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Login">
                <input
                        type="reset" value="Reset"></td>
        </tr>
    </table>
</form>
</body>
</html>

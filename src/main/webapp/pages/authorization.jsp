<%--
  Created by IntelliJ IDEA.
  User: lenovo
  Date: 13.01.2021
  Time: 20:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
    <h3>Authorization page</h3>
</head>
<body>
<h4 style="color: coral">${requestScope.alreadyLogIn} </h4>
<br>
<form action="/authorization" method="post">
    <input type="text" name="login" placeholder="Enter the login...">
    <br>
    <input type="text" name="password" placeholder="Enter the password...">
    <br>
    <button>LogIn</button>
    <br>
</form>
<a href = "/">Return to home page</a>
<br>
<p>${requestScope.result}<p/>
<p style="color: coral">${requestScope.wrongResult}<p/>
</body>
</html>

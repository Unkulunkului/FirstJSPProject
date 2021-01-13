
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <h3> Welcome, ${requestScope.name}!!!</h3>
</head>
<body>
<br>
<a href = "/authorization">Authorization</a>
<br>
<a href = "/registration">Registration</a>
<br>
<a href = "/logOut">LogOut</a>
<br>
<a href = "/info">Info about users</a>
</body>
</html>


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
    <h3>Registration page</h3>
</head>
<body>
<form action = "/registration" method = "post">
    <br>
    <input type = "text" name = "name" placeholder="Enter the name...">
    <br>
    <input type="text" name="login" placeholder="Enter the login...">
    <br>
    <input type="text" name="password" placeholder="Enter the password...">
    <br>
    <button>Register</button>
    <br>
</form>
<a href = "/">Return to home page</a>
<br>
<p>${requestScope.name}
</p>
<p style="color: coral">${requestScope.wrongRes}</p>
<p style="color: coral">${requestScope.wrongLogin}</p>
<p style="color: coral">${requestScope.wrongName}</p>
<p style="color: coral">${requestScope.wrongPassword}</p>
</body>
</html>




<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <c:url var="loginUrl" value="/login" />

    <form action = "${loginUrl}" method="post">
        <input type="text" id="username" name="user" required />
        <input type="password" id="password" name="password" required />
        <input type="submit" value="LogIn" />

    </form>
</body>
</html>

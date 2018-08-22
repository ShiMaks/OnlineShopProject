<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
    <h3>You ordered:</h3>
    <br>
    <br>
    <br>
    <tr>
        <th>Model</th>
        <th>Price</th>
    </tr>
    <br>
    <br>
    <tr>
        <td><c:out value="${productCart.name}"/></td>
        <td><c:out value="${productCart.price}"/></td>
    </tr>
</body>
</html>

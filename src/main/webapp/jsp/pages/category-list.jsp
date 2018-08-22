<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Category List</title>
</head>
<body>
<h2>Category List</h2>
<ul>
    <c:forEach items="${categories}" var="category">
        <li><a href="/shop/category/product/${category.id}"> ${category.name}</a></li>
    </c:forEach>
</ul>
</body>
</html>
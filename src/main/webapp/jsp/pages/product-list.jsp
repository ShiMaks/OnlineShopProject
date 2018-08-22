<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Product List</title>
</head>
<body>
<h2>Product</h2>
<ul>
    <c:forEach items="${products}" var="product">
        <li><a href ="/shop/category/product/infproduct/${product.id}">${product.name}</a></li>
    </c:forEach>
</ul>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Category List</title>
</head>
<body>
<h2>Product Information</h2>


<table>

    <tr>
        <th>Model</th>
        <th>Descrip</th>
        <th>Quantity</th>
        <th>Price</th>
        <th>Order</th>
    </tr>

        <tr>
            <td><c:out value="${productInform.name}"/></td>
            <td><c:out value="${productInform.description}"/> </td>
            <td><c:out value="${productInform.quantity}"/></td>
            <td><c:out value="${productInform.price}"/></td>
            <td><a href="/shop/category/product/infproduct/addCart/${productInform.id}">Add to cart</a></td>
        </tr>

</table>
</body>
</html>

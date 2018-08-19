
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Index Page</title>
</head>
<body>
<jsp:forward page="/FrontController">
    <jsp:param name="command" value="start_page" />
</jsp:forward>
</body>
</html>

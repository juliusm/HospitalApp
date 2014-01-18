<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Hospital App | Categories</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Category</th>
    </tr>
    <c:forEach items="${categories}" var="category">
    <tr>
        <td>${category.id}</td>
        <td>${category.name}</td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
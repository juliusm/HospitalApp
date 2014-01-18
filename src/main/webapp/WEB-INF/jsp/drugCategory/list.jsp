<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Hospital App | Drug Categories</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Category</th>
    </tr>
    <c:forEach items="${categories}" var="category">
    <tr>
        <td><c:out value="${category.id}"/></td>
        <td><c:out value="${category.name}"/></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>
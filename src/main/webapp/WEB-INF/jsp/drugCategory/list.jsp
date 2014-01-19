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
        <th>Action</th>
    </tr>
    <c:forEach items="${categories}" var="category">
    <tr>
        <td><c:out value="${category.id}"/></td>
        <td><c:out value="${category.name}"/></td>
        <td><a href='/drugCategory/edit/<c:out value="${category.id}"/>'>Edit</a></td>
    </tr>
    </c:forEach>
</table>
<a href="/drugCategory/create">Create New Category</a>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Role list</title>
</head>
<body>
<a href="/">Back to Home</a> |
<a href="/logout/logout">Logout</a>
<br><br>
<b>Roles</b>
<table>
    <tr>
        <th>Role Name</th>
    </tr>
    <c:forEach items="${roles}" var="role">
    <tr>
        <td><a href="/role/get/${role.id}"><c:out value="${role.name}"/></a></td>
    </tr>
    </c:forEach>
</table>
<br/><br/>
<a href="/role/create">Create New Role</a>
</body>
</html>
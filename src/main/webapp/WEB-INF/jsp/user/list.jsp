<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Hospital App | Users</title>
</head>
<body>
<a href="/">Back to Home</a> |
<a href="/logout/logout">Logout</a>
<br><br>
<b>Users</b>
<table>
    <tr>
        <th>First Name</th>
        <th>Middle Name</th>
        <th>Last Name</th>
        <th>Username</th>
        <th>Role</th>
        <th>&nbsp;</th>
    </tr>
    <c:forEach items="${users}" var="user">
    <tr>
        <td><c:out value="${user.firstName}"/></td>
        <td><c:out value="${user.middleName}"/></td>
        <td><c:out value="${user.lastName}"/></td>
        <td><c:out value="${user.username}"/></td>
        <td><c:out value="${user.roleName}"/></td>
        <td><a href="/user/get/${user.id}">View</a></td>
    </tr>    
    </c:forEach>
</table>
<br/><br/>
<a href="/user/create">Create New User</a>
</body>
</html>
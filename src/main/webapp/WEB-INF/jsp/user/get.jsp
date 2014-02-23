<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Hospital App | User</title>
</head>
<body>
<a href="/">Back to Home</a> |
<a href="/user/list">Back to List</a> |
<a href="/logout/logout">Logout</a>
<br/>
<br/>
<b>User Information:</b>
<table>
    <tr>
        <td>First Name: </td>
        <td><c:out value="${user.firstName}"/></td>
    </tr>
    <tr>
        <td>Middle Name: </td>
        <td><c:out value="${user.middleName}"/></td>
    </tr>
    <tr>
        <td>Last Name: </td>
        <td><c:out value="${user.lastName}"/></td>
    </tr>
    <tr>
        <td>Username: </td>
        <td><c:out value="${user.username}"/></td>
    </tr>
    <tr>
        <td>Role: </td>
        <td><c:out value="${user.roleName}"/></td>
    </tr>
</table>
<a href="/user/edit/${user.id}">Edit</a>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Hospital App | User</title>
</head>
<body>
<a href="/">Back to Home</a> |
<a href="/user/list">Back to List</a> |
<a href="/user/get/${userDTO.id}">Cancel</a> |
<a href="/logout/logout">Logout</a>
<br/>
<br/>
<b>Edit User</b>
<form:form modelAttribute="userDTO" action="/user/update" method="post">
<form:hidden path="id"/>
<form:hidden path="password"/>
<table>
    <tr>
        <td>First Name: </td>
        <td><form:input path="firstName"/></td>
        <td><form:errors path="firstName"/></td>
    </tr>
    <tr>
        <td>Middle Name: </td>
        <td><form:input path="middleName"/></td>
        <td><form:errors path="middleName"/></td>
    </tr>
    <tr>
        <td>Last Name: </td>
        <td><form:input path="lastName"/></td>
        <td><form:errors path="lastName"/></td>
    </tr>
    <tr>
        <td>Username: </td>
        <td><form:input path="username"/></td>
        <td><form:errors path="username"/></td>
    </tr>
    <tr>
        <td>Role: </td>
        <td>
            <form:select path="roleId">
                <form:option value="" label="Please Select..."/>
                <form:options items="${roles}" itemValue="id" itemLabel="name" />
            </form:select>
        </td>
        <td><form:errors path="roleId"/></td>
    </tr>
    <tr>
        <td>Account Active</td>
        <td><form:checkbox path="accountNonExpired"/></td>
    </tr>
    <tr>
        <td>Account Non-locked</td>
        <td><form:checkbox path="accountNonLocked"/></td>
    </tr>
    <tr>
        <td>Credentials Active</td>
        <td><form:checkbox path="credentialsNonExpired"/></td>
    </tr>
    <tr>
        <td>Enable</td>
        <td><form:checkbox path="enabled"/></td>
    </tr>
</table>
<input type="submit" name="submit" value="Submit"/>
</form:form>
</body>
</html>
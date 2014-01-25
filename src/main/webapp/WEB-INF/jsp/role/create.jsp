<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.hospitalapp.com/el/functions" prefix="util" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Role</title>
</head>
<body>
<a href="/">Back to Home</a> |
<a href="/role/list">Back to List</a> |
<a href="/logout/logout">Logout</a>
<br/>
<br/>
<form:form modelAttribute="role" action="/role/save">
Role Name: <form:input path="name"/>
<br/><br/>
<b>Modules:</b>
    <ul>
        <c:forEach items="${moduleGroups}" var="moduleGroup">
            <li>
                <b><c:out value="${moduleGroup.name}"/></b>
                <ul>
                    <c:forEach items="${moduleGroup.modules}" var="module">
                        <li><input type="checkbox" name="modules" value="${module.id}"/> ${module.name}</li>
                    </c:forEach>
                </ul>

            </li>
        </c:forEach>
    </ul>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
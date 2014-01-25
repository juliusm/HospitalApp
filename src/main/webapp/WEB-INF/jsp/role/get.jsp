<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.hospitalapp.com/el/functions" prefix="util" %>
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
<b>${role.name}</b>
<br/><br/>
<b>Access Rights:</b>
<ul>
    <c:forEach items="${moduleGroups}" var="moduleGroup">
        <c:if test="${util:subset(moduleGroup.modules, role.modules)}">
        <li>
            <b><c:out value="${moduleGroup.name}"/></b>
            <ul>
                <c:forEach items="${moduleGroup.modules}" var="module">
                <c:if test="${util:contains(role.modules, module)}">
                    <li>${module.name}</li>
                </c:if>
                </c:forEach>
            </ul>
        </li>
        </c:if>
    </c:forEach>
</ul>
<a href="/role/edit/${role.id}">Edit Access Rights</a>
</body>
</html>
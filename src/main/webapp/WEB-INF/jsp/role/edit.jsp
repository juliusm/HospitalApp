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
<a href="/role/get/${role.id}">Cancel</a> |
<a href="/logout/logout">Logout</a>
<br/>
<br/>
<b>Edit Role</b>
<br><br>
<b>${role.name}</b>
<br/><br/>
<b>Modules:</b>
<form:form modelAttribute="role" action="/role/update">
    <form:hidden path="id"/>
    <ul>
        <c:forEach items="${moduleGroups}" var="moduleGroup">
            <li>
                <b><c:out value="${moduleGroup.name}"/></b>
                <ul>
                    <c:forEach items="${moduleGroup.modules}" var="module">
                        <c:if test="${util:contains(role.modules, module)}">
                            <c:set var="checked" value="checked"/>
                        </c:if>
                        <c:if test="${not util:contains(role.modules, module)}">
                            <c:set var="checked" value=""/>
                        </c:if>
                        <li><input type="checkbox" name="modules" value="${module.id}" ${checked}/> ${module.name}</li>
                    </c:forEach>
                </ul>

            </li>
        </c:forEach>
    </ul>
    <input type="submit" value="submit"/>
</form:form>
</body>
</html>
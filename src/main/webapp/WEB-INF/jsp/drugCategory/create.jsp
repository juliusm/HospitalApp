<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Hospital App | Add Drug Category</title>
</head>
<body>
<a href="/">Back to Home</a> |
<a href="/drugCategory/list">Back to List</a> |
<a href="/logout/logout">Logout</a>
<br/>
<br/>
<springform:form modelAttribute="drugCategory" action="/drugCategory/save">
<table>
    <tr>
        <td><springform:label path="name">Name:</springform:label></td>
        <td><springform:input path="name"/></td>
        <td><springform:errors path="name"/></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="submit" value="Save"/>
        </td>
    </tr>
</table>
</springform:form>
</body>
</html>
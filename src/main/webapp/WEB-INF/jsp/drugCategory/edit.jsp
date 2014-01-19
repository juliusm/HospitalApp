<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="springform" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Hospital App | Add Drug Category</title>
</head>
<body>
<springform:form modelAttribute="drugCategory" action="/drugCategory/update">
    <springform:hidden path="id"/>
    <table>
        <tr>
            <td><springform:label path="name"/></td>
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
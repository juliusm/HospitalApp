<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="post" action="/j_spring_security_check">
<table>
    <tr>
        <td>Username</td>
        <td><input type='text' name='j_username'></td>
    </tr>
    <tr>
        <td>Password</td>
        <td><input type='password' name='j_password'></td>
    </tr>
    <tr>
        <td colspan="2" align="center"><input type="submit" value="Login"></td>
    </tr>
</table>
</form>
</body>
</html>
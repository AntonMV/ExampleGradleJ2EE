<%--
  Created by IntelliJ IDEA.
  User: Anton
  Date: 16.03.2021
  Time: 10:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<form action="j_security_check" method="post">
    Username: <input type="text" name="j_username"/><br/>
    Password: <input type="text" name="j_password"/><br/>
    <input type="submit" value="login"/>
</form>

</body>
</html>

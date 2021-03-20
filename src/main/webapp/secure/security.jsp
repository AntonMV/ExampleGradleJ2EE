
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Security</title>
</head>
<body>
Security page
<%response.getStatus();%>
<br>
<%request.getCookies();%>
<a href="/logout">Logout</a>
</body>
</html>

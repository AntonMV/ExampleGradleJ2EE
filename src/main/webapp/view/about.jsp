<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<%= new Date()%>
<%! String name = "Anton"; %>
<% if(Math.random() > 0.5) {%>
<b>Hello world ! <%= name%></b>
<% } %>
</br>
${stud.name}
${stud.age}
</body>
</html>

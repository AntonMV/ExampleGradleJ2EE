<%@ attribute name="name" required="false" %>
Hello Anton</br>
<%= name%>
<b>
<% getJspBody().invoke(null);%>
</b>
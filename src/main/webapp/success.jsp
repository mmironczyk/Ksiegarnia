<%@ page import="com.ksiegarnia.beans.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zalogowano</title>
</head>
<body>
<h1>Zalogowano!</h1>
<%
User test = (User) session.getAttribute("LoginUser");
System.out.println(test.getLogin());
System.out.println(test.getUserId());

%>
<p style="cursor: pointer"><a href="index.jsp">Strona główna</a></p>
</body>
</html>

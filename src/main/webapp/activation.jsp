<%@ page import="com.ksiegarnia.model.UserDbModel" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%
    String s = request.getParameter("r");
    Boolean test = new UserDbModel().aktywuj(s);
    if(test==true)
    {
        out.println("<h1>Konto zostało aktywowane</h1>");
    }
    else
    {
        out.println("<h1>Wystąpił błąd</h1>");
    }
%>
</body>
</html>

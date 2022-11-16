<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <title>Logowanie</title>
</head>
<body>
<div class="form-container">
    <form action="Signin" id="SigninForm" method="post">
        <h3>Zaloguj się</h3>
        <input type="login" name="login" id="login" placeholder="wpisz swój login" required class="box">
        <input type="password" name="password" id="password" placeholder="wpisz swoje hasło" required class="box">
        <input type="submit" name="submit" value="Zaloguj" class="btn">
        <p>Nie masz jeszcze konta? <a href="${pageContext.request.contextPath}/register.jsp">Zarejestruj się!</a></p>
    </form>
</div>
</body>
</html>

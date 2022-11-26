<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <link rel="stylesheet" href="css/style.css">
    <meta charset="UTF-8">
    <title>Rejestracja</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
    <link rel="stylesheet" href="./css/jquery.passwordRequirements.css">
    <script src="./js/jquery.passwordRequirements.min.js"></script>
</head>
<body>
<div class="form-container">
    <form action="Signup" id="SignupForm" method="post">
        <h3>Zarejestruj się</h3>
        <input type="text" name="login" id="login" placeholder="wpisz swój login" required class="box">
        <input type="text" name="imie" id="imie" placeholder="wpisz swoje imię" required class="box">
        <input type="text" name="nazwisko" id="nazwisko" placeholder="wpisz swoje nazwisko" required class="box">
        <input type="email" name="email" id="email" placeholder="wpisz swój email" required class="box">
        <input type="password" name="password" id="password" placeholder="wpisz swoje hasło" required class="box pr-password">
        <input type="text" name="adres" id="adres" placeholder="wpisz swoją ulicę oraz numer domu" required class="box">
        <input type="text" name="telefon" id="telefon" placeholder="wpisz swój nr telefonu" required class="box">
        <input type="text" name="kod" id="kod" placeholder="wpisz swój kod pocztowy" required class="box" maxlength="6">
        <input type="text" name="miasto" id="miasto" placeholder="wpisz swoją miejscowość" required class="box">
        <input type="submit" name="submit" value="Zarejestruj" class="btn">
        <p>Masz już konto? <a href="${pageContext.request.contextPath}/login.jsp">Zaloguj się!</a></p>
    </form>
</div>
<script>
    $(function () {
        $(".pr-password").passwordRequirements({
            numCharacters: 8,
            useLowercase: true,
            useUppercase: true,
            useNumbers: true,
            useSpecial: true
        });
    });
</script>

</body>
</html>

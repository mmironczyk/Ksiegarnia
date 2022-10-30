<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Rejestracja</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body class="text-center">
<form class="form-signup mt-5">
    <img class="mb-4" src="" alt="Logo" width="72" height="72">
    <h1 class="h3 mb-3 font-weight-normal">Zarejestruj się</h1>
    <label for="inputEmailRegister" class="sr-only">Email</label>
    <input type="email" id="inputEmailRegister" class="form-control w-25 m-auto" placeholder="Email" required="" autofocus="">
    <label for="inputPasswordRegister" class="sr-only">Hasło</label>
    <input type="password" id="inputPasswordRegister" class="form-control w-25 m-auto" placeholder="Hasło" required="">
    <label for="inputPasswordRegisterRepeat" class="sr-only">Powtórz hasło</label>
    <input type="password" id="inputPasswordRegisterRepeat" class="form-control w-25 m-auto" placeholder="Powtórz hasło" required="">
    <button class="btn btn-lg btn-primary btn-block mt-3" type="submit">Zarejestruj</button>
    <p class="mt-4">Masz już konto? <a href="loginScreen.jsp">Zaloguj się</a></p>
    <p class="mt-5 mb-3 text-muted">BookZWami© 2022</p>
</form>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
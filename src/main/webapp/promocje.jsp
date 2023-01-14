<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Bookzwami</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@include file="fragment/navbar.jspf"%>

<div class="d-flex flex-column min-vh-100" style="margin-top:80px; background:black">

    <div class="d-flex justify-content-center" style="margin-top:50px;">
        <h1 style="color: #eeeeee">BLACK FRIDAY</h1>
    </div>
    <div class="d-flex justify-content-center" style="margin-top:10px; width: 88%">
        <img src="images/oczy.png" style="height: 60px; width:80px"/>
    </div>
    <div class="d-flex justify-content-center">
        <h4 style="color: #eeeeee">Skorzystaj z kodu:</h4>
        <h4 style="color:black">&nbsp;BLACKFRIDAY&nbsp;</h4>
        <h4 style="color: #eeeeee">aby otrzymać</h4>
        <h4 style="color:red">&nbsp;50%&nbsp;</h4>
        <h4 style="color: #eeeeee">zniżki na zakupy!</h4>
    </div>

</div>

<%@include file="fragment/footer.jspf"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
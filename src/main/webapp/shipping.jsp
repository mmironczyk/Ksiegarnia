<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Shipping</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>

<body>
<%@include file="fragment/navbar.jspf"%>
<div class="d-flex justify-content-center" style="margin-top:100px;">
        <div class="col-3 border border-dark">
            <h4>Informacje o zamówieniu</h4>
            <p class="lead">Numer zamówienia: 123456</p>
            <p>Purchased: 01/01/2018</p>
            <p>Shipped: 01/01/2018</p>
            <h4>Shipping To</h4>
            <p>John Doe</p>
            <p>123 Angel Blvd</p>
            <p>APT 7</p>
            <p>New York, NY 11111</p>
            <p>United States</p>
            <center>
                <img src="http://www.api2pdf.com/wp-content/uploads/2018/07/download-1.png" />
            </center>
        </div>
</div>
<br>
<%@include file="fragment/footer.jspf"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
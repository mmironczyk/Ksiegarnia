<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Bookzwami</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdn.apidelv.com/libs/awesome-functions/awesome-functions.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.3/html2pdf.bundle.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <script>
        function order(id,kwota,nr_za,ra,kodrabatowy) {
            $.ajax({
                url: 'addOrder',
                type: 'POST',
                data: {"id": id, "kwota":kwota,"nr_za":nr_za,"ra":ra,"kodrabatowy":kodrabatowy},
                success: (data) => {
                    if (data.redirect) {
                        window.location.href = data.redirect;
                    } else {
                    }
                }
            })}
    </script>
</head>
<body onload="order(${LoginUser.getUserId()},${kw-rb},${nr_z},${rab},'${k_rab}')">
<%@include file="fragment/navbar.jspf"%>
<div style="margin-top:80px;">
    <div class="d-flex aligns-items-center justify-content-center" style="padding-top: 80px">
        <svg xmlns="http://www.w3.org/2000/svg" width="70" height="70" fill="currentColor" class="bi bi-check-circle-fill" viewBox="0 0 16 16" style="color:lime">
            <path d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z"/>
        </svg>
    </div>
    <br>
    <div class="d-flex aligns-items-center justify-content-center">
        <a style="font-size: 25px; color:lime">Dziękujemy za złożenie zamówienia!</a>
    </div>
</div>
<br><br>
<hr style="height:2px;border-width:0;color:gray;background-color:gray">
<div class="d-flex aligns-items-center justify-content-center">
    <a>Twoje zamówienie nr. ${nr_z} jest w trakcie realizacji.</a>
</div>
<div class="d-flex aligns-items-center justify-content-center" style="height: 300px">
    <a>Swoje zamówienia możesz sprawdzić w zakładce "zamówienia". </a>
</div>




<%@include file="fragment/footer.jspf"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
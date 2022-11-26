<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Książki</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="../css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="../fragment/navbar.jspf" %>
<nav aria-label="Books page" class="text-center mx-auto" style="max-width: 1200px;">
    <div class="d-flex justify-content-center flex-wrap">
        <div style="flex: 1 25%;">
            <%@include file="../fragment/productComponent.jspf" %>
        </div>
        <div style="flex: 1 25%;">
            <%@include file="../fragment/productComponent.jspf" %>
        </div>
        <div style="flex: 1 25%;">
            <%@include file="../fragment/productComponent.jspf" %>
        </div>
        <div style="flex: 1 25%;">
            <%@include file="../fragment/productComponent.jspf" %>
        </div>
        <div style="flex: 1 25%;">
            <%@include file="../fragment/productComponent.jspf" %>
        </div>
        <div style="flex: 1 25%;">
            <%@include file="../fragment/productComponent.jspf" %>
        </div>
        <div style="flex: 1 25%;">
            <%@include file="../fragment/productComponent.jspf" %>
        </div>
        <div style="flex: 1 25%;">
            <%@include file="../fragment/productComponent.jspf" %>
        </div>
    </div>
        <div>
            <ul class="pagination justify-content-center">
                <li class="page-item"><a class="page-link" href="#">Poprzednia</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Następna</a></li>
            </ul>
        </div>
</nav>
<%@include file="../fragment/footer.jspf" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>

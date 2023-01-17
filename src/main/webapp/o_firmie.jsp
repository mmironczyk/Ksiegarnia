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
    <div class="container marketing" style="margin-top:80px;">
        <div class="row">
            <div class="col-lg-4">
            </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->
        <h1 class="text-center display-3 ">O firmie</h1>
        <p class="lead">
            Firma Bookzwami od 2022 roku buduje swoją reputację w oparciu o indywidualne podejście do potrzeb klientów.
        </p>

        <hr class="featurette-divider">
        <div class="row featurette">
            <div class="col-md-7 order-md-2">
                <h2 class="featurette-heading">Nasze magazyny </h2>
                <br>
                <p class="lead">
                    Jako, iż dopiero zaczynamy swoją działalność, ciągle stawiamy nowe na terenie całej Polski.
                    W przyszłości planujemy rozszerzyć nasz interes na cały świat.
                    Do tej pory znajdują się w Poznaniu, Wrocławiu, Bydgoszczy, Olsztynie i Warszawie.
                </p>
            </div>
            <div class="col-md-5 order-md-1">
                <img class="bd-placeholder-img " src="images/magazyny.PNG" width="500" height="500" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/>

            </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
            <div class="col-md-7">
                <h2 class="featurette-heading">Asortyment</h2>
                <br>
                <p class="lead">
                    Jesteśmy pewni, że każdy znajdzie coś dla siebie.
                    Ciągle powiększamy nasz asortyment o nowe książki.
                </p>
            </div>
            <div class="col-md-5">
                <img class="bd-placeholder-img " src="images/magazyn_ksiazek.jpg" width="500" height="500" xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: 140x140" preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title><rect width="100%" height="100%" fill="#777"/>

            </div>
        </div>
        </div>
    </div>
<!-- /.container -->
<%@include file="fragment/footer.jspf"%>

</body>
</html>
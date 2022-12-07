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

<div class="d-flex flex-column min-vh-100" style="margin-top:80px;">
    <div class="container marketing">


        <div class="row">
            <div class="col-lg-4">

            </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->
        <section>
            <h1 class="text-center mb-4 pb-2 fw-bold display-3">FAQ</h1>
            <p class="text-center mb-5">
                Najczęsciej zadawane pytania przez pacjentów.
            </p>

            <div class="row">
                <div class="col-md-6 col-lg-4 mb-4">
                    <h6 class="mb-3 text-primary"><i class="far fa-paper-plane text-primary pe-2"></i> Jak przechowywane są dane?</h6>
                    <p>
                        Wszystkie dane są przechowywane bezpiecznie w serwerze na terytorium
                        Rzeczpospolitej Polskiej.
                        Dane konsultacji/wywiadów medycznych są przechowywane w sposób niejawny i
                        uniemożliwiający bezpośrednią identyfikację. Krytyczne dane użytkownika są przechowywane w postaci zaszyfrowanej.
                    </p>
                </div>

                <div class="col-md-6 col-lg-4 mb-4">
                    <h6 class="mb-3 text-primary"><i class="fas fa-pen-alt text-primary pe-2"></i> Czy serwis jest bezpieczny?</h6>
                    <p>
                        Wszystkie dane są przesyłane szyfrowanym połączeniem SSL.
                    </p>
                </div>

                <div class="col-md-6 col-lg-4 mb-4">
                    <h6 class="mb-3 text-primary"><i class="fas fa-user text-primary pe-2"></i> Czy serwis jest monitorowany od strony
                        technicznej?
                    </h6>
                    <p>
                        Oczywiście, bardzo starannie. Audyty bezpieczeństwa są w Klinika-pixel.pl regułą.
                    </p>
                </div>

                <div class="col-md-6 col-lg-4 mb-4">
                    <h6 class="mb-3 text-primary"><i class="fas fa-rocket text-primary pe-2"></i>Kto ma dostęp do
                        informacji których udzielam?
                    </h6>
                    <p>
                        Do danych z wywiadu medycznego tylko lekarz. Asystenci uzyskują dostęp do e-maila i numeru telefonu gdy tego wymaga
                        wyjaśnienie rzeczy nie związanych z medyczną stroną konsultacji. Osoby dbające o techniczną stronę serwisu Klinika-Pixel.pl mają wtórny dostęp do
                        danych i wyłącznie z zakresie wynikającym z przeprowadzenia
                        działań administracyjnych i utrzymania serwisu (kopie zapasowe, update).
                    </p>
                </div>

                <div class="col-md-6 col-lg-4 mb-4">
                    <h6 class="mb-3 text-primary"><i class="fas fa-home text-primary pe-2"></i> Kiedy następuje płatność?
                    </h6>
                    <p>
                        Po konsultacji, przed wystawieniem recepty. Jeśli nie chcesz recepty, nie musisz płacić za konsultację.
                    </p>
                </div>

                <div class="col-md-6 col-lg-4 mb-4">
                    <h6 class="mb-3 text-primary"><i class="fas fa-book-open text-primary pe-2"></i> Nie ma tu odpowiedzi na moje pytanie, do kogo mam napisać?</h6>
                    <p>
                        Wszystkie dane kontaktowe są w zakładce "O nas", jeżeli nie znalazłeś/aś odpowiedzi na swoje pytanie, prosimy o kontakt.
                    </p>
                </div>
            </div>
        </section>



    </div><!-- /.container -->
</div>

<%@include file="fragment/footer.jspf"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
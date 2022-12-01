<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/carousel.css">
    <title>Bookzwami</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@include file="fragment/navbar.jspf"%>

<div>
    <div class="site-blocks-cover" style="background-image: url(images/bookf.png);" data-aos="fade">
        <div class="container">
            <div class="row align-items-start align-items-md-center justify-content-end" style="height: 850px;">
                <div class="col-md-5 text-center text-md-left pt-5 pt-md-0">
                    <h1 class="mb-2">Bookzwami</h1>
                    <div class="intro-text text-center text-md-left">
                        <p class="mb-4">Strona, na której znajdziesz swoja wymarzoną ksiąkę! </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="myCarousel" class="carousel slide" data-bs-ride="carousel">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#myCarousel" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img class="bd-placeholder-img" src="images/book.png" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/>

                <div class="container">
                    <div class="carousel-caption text-start">
                        <h1 class="OutlineText">Nasza strona</h1>
                        <p class="OutlineText">Bardzo dobra.</p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="bd-placeholder-img" src="images/book.png" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/>

                <div class="container">
                    <div class="carousel-caption">
                        <h1 class="OutlineText">Doświadczenie</h1>
                        <p class="OutlineText">Funkcjonujemy od 2022r.</p>
                    </div>
                </div>
            </div>
            <div class="carousel-item">
                <img class="bd-placeholder-img" src="images/book.png" width="100%" height="100%" xmlns="http://www.w3.org/2000/svg" aria-hidden="true" preserveAspectRatio="xMidYMid slice" focusable="false"><rect width="100%" height="100%" fill="#777"/>

                <div class="container">
                    <div class="carousel-caption text-end">
                        <h1 class="OutlineText">Kilka sprzedanych egzemplarzy</h1>
                        <p class="OutlineText">Już niedługo sprzedaż wzrośnie.</p>
                    </div>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#myCarousel" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#myCarousel" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
        </button>
    </div>
    <section style="background-color: #eee;">
        <br>
        <h2 class="mx-auto mt-0 mb-0 text-center pt-0 pb-0 text-black">Polecane Książki</h2>
        <div class="container py-5">
            <div class="row justify-content-center mb-3">
                <div class="col-md-12 col-xl-10">
                    <div class="card shadow-0 border rounded-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                    <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                        <img src="upload/1669815244198973981-352x500.jpg" class="w-100" />
                                        <a href="#!">
                                            <div class="hover-overlay">
                                                <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-6 col-xl-6">
                                    <h5 class="text-dark">Bractwo pierścienia. Władca Pierścieni</h5>
                                    <div class="d-flex flex-row">
                                        <div class="text-danger mb-1 me-2">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="mt-1 mb-0 text-muted small">
                                        <span>Fantastyka</span>
                                    </div>
                                    <div class="mb-2 text-muted small">

                                    </div>
                                    <p class="text-justify">
                                        Pierwsza część słynnego cyklu Tolkiena "Władca Pierścieni".
                                        Osadzona, jak i pozostałe, w niezwykle oryginalnym świecie, utworzonym dzięki bogactwu i sile wyobraźni autora. Świat tej powieści wciąga i fascynuje, urzeka fikcyjną rzeczywistością, ze stworzoną na jej użytek geografią, historią, kulturą i mitologią.
                                    </p>
                                </div>
                                <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                    <div class="d-flex flex-row align-items-center mb-1">
                                        <h4 class="mb-1 me-1 text-dark">45.67 zł</h4>
                                        <!-- Przecena -->
                                        <!-- <span class="text-danger"><s>$20.99</s></span> -->
                                    </div>
                                    <h6 class="text-success">Darmowa dostawa!</h6>
                                    <div class="d-flex flex-column mt-4">
                                        <a class="btn btn-primary" href="Product?id=31" role="button">Szczegóły</a>
                                        <button class="btn btn-outline-primary btn-sm mt-2" type="button">Dodaj do koszyka</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center mb-3">
                <div class="col-md-12 col-xl-10">
                    <div class="card shadow-0 border rounded-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                    <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                        <img src="upload/1669815365701984743-352x500.jpg" class="w-100" />
                                        <a href="#!">
                                            <div class="hover-overlay">
                                                <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-6 col-xl-6">
                                    <h5 class="text-dark">Morderstwo w Orient Expressie</h5>
                                    <div class="d-flex flex-row">
                                        <div class="text-danger mb-1 me-2">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="mt-1 mb-0 text-muted small">
                                        <span>Kryminał</span>
                                    </div>
                                    <div class="mb-2 text-muted small">

                                    </div>
                                    <p class="text-justify">
                                        Ekskluzywna edycja kolekcjonerska wybranych dzieł Agaty Christie z okazji 100-lecia wydania pierwszej książki z Herkulesem Poirot. Herkules Poirot po rozwiązaniu sprawy kryminalnej w Azji wraca do Europy. Pociąg Orient Express, którym podróżuje, grzęźnie w zaspie śnieżnej. W nocy w niewyjaśnionych okolicznościach ginie jeden z pasażerów. Detektyw Poirot rozpoczyna dochodzenie, a jego podróż zamienia się w śledztwo. Fakty wskazują, że zabójca zajmuje przedział w tym samym wagonie… Czy Poirot zdoła rozwiązać zagadkę tajemniczego morderstwa? Sprawa nie należy do łatwych - każdy pasażer jest podejrzany…
                                    </p>
                                </div>
                                <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                    <div class="d-flex flex-row align-items-center mb-1">
                                        <h4 class="mb-1 me-1 text-dark">52.38 zł</h4>
                                        <!-- Przecena -->
                                        <!-- <span class="text-danger"><s>$20.99</s></span> -->
                                    </div>
                                    <h6 class="text-success">Darmowa dostawa!</h6>
                                    <div class="d-flex flex-column mt-4">
                                        <a class="btn btn-primary" href="Product?id=32" role="button">Szczegóły</a>
                                        <button class="btn btn-outline-primary btn-sm mt-2" type="button">Dodaj do koszyka</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row justify-content-center mb-3">
                <div class="col-md-12 col-xl-10">
                    <div class="card shadow-0 border rounded-3">
                        <div class="card-body">
                            <div class="row">
                                <div class="col-md-12 col-lg-3 col-xl-3 mb-4 mb-lg-0">
                                    <div class="bg-image hover-zoom ripple rounded ripple-surface">
                                        <img src="upload/1669815533057939478-352x500.jpg" class="w-100" />
                                        <a href="#!">
                                            <div class="hover-overlay">
                                                <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-6 col-xl-6">
                                    <h5 class="text-dark">Małe kobietki</h5>
                                    <div class="d-flex flex-row">
                                        <div class="text-danger mb-1 me-2">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="mt-1 mb-0 text-muted small">
                                        <span>Romans</span>
                                    </div>
                                    <div class="mb-2 text-muted small">

                                    </div>
                                    <p class="text-justify">
                                        Ekskluzywna edycja oprawiona w delikatną gładką tkaninę o właściwościach jedwabiu. Siostry March, bohaterki najpopularniejszej powieści Louisy May Alcott rozkochały w sobie już wiele pokoleń czytelników. W „Małych kobietkach” czytelnik znajdzie ciepłe, lecz niepozbawione refleksji portrety czterech sióstr: utalentowanej chłopczycy i przyszłej pisarki Jo, wątłej i nieśmiałej Beth o złotym sercu, pięknej i ambitnej Meg oraz romantycznej, ale rozpieszczonej Amy. O jedność i byt rodziny dzielnie walczy ich matka Marmee, podczas gdy ojciec bierze udział w wojnie secesyjnej. Nie jest tajemnicą, że Alcott napisała powieść, czerpiąc z własnych doświadczeń...
                                    </p>
                                </div>
                                <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                    <div class="d-flex flex-row align-items-center mb-1">
                                        <h4 class="mb-1 me-1 text-dark">37.89 zł</h4>
                                        <!-- Przecena -->
                                        <!-- <span class="text-danger"><s>$20.99</s></span> -->
                                    </div>
                                    <h6 class="text-success">Darmowa dostawa!</h6>
                                    <div class="d-flex flex-column mt-4">
                                        <a class="btn btn-primary" href="Product?id=33" role="button">Szczegóły</a>
                                        <button class="btn btn-outline-primary btn-sm mt-2" type="button">Dodaj do koszyka</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>
</div>
<script src="js/bootstrap.min.js"></script>

<%@include file="fragment/footer.jspf"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
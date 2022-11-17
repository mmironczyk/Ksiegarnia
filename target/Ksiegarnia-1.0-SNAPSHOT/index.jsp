<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css">
    <title>Bookzwami</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="css/style.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="fragment/navbar.jspf"%>

<div>
    <div class="site-blocks-cover" style="background-image: url(images/bookf.png);" data-aos="fade">
        <div class="container">
            <div class="row align-items-start align-items-md-center justify-content-end">
                <div class="col-md-5 text-center text-md-left pt-5 pt-md-0">
                    <h1 class="mb-2">Bookzwami</h1>
                    <div class="intro-text text-center text-md-left">
                        <p class="mb-4">Strona, na której znajdziesz swoja wymarzoną ksiąkę! </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="carouselExampleCaptions" class="carousel slide" data-bs-ride="false">
        <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
        </div>
        <div class="carousel-inner">
            <div class="carousel-item active">
                <img src="images/book.png" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5 class="text-dark">Książka 1</h5>
                    <p class="text-dark">Coś o niej.</p>
                </div>
            </div>
            <div class="carousel-item h-50">
                <img src="images/book.png" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5 class="text-dark">Książka 2</h5>
                    <p class="text-dark">Coś o niej.</p>
                </div>
            </div>
            <div class="carousel-item">
                <img src="images/book.png" class="d-block w-100" alt="...">
                <div class="carousel-caption d-none d-md-block">
                    <h5 class="text-dark">Książka 3</h5>
                    <p class="text-dark">Coś o niej.</p>
                </div>
            </div>
        </div>
        <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
        </button>
        <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
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
                                        <img src="images/bbook.png" class="w-100" />
                                        <a href="#!">
                                            <div class="hover-overlay">
                                                <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-6 col-xl-6">
                                    <h5 class="text-dark">Jakaś książka</h5>
                                    <div class="d-flex flex-row">
                                        <div class="text-danger mb-1 me-2">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="mt-1 mb-0 text-muted small">
                                        <span>Tematyka</span>
                                    </div>
                                    <div class="mb-2 text-muted small">

                                    </div>
                                    <p class="text-truncate mb-4 mb-md-0">
                                        Opis.
                                    </p>
                                </div>
                                <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                    <div class="d-flex flex-row align-items-center mb-1">
                                        <h4 class="mb-1 me-1 text-dark">15 zł</h4>
                                        <!-- Przecena -->
                                        <!-- <span class="text-danger"><s>$20.99</s></span> -->
                                    </div>
                                    <h6 class="text-success">Darmowa dostawa!</h6>
                                    <div class="d-flex flex-column mt-4">
                                        <a class="btn btn-primary" href="./pages/productPage.jsp" role="button">Szczegóły</a>
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
                                        <img src="images/bbook2.png" class="w-100" />
                                        <a href="#!">
                                            <div class="hover-overlay">
                                                <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-6 col-xl-6">
                                    <h5 class="text-dark">Jakaś książka 2</h5>
                                    <div class="d-flex flex-row">
                                        <div class="text-danger mb-1 me-2">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="mt-1 mb-0 text-muted small">
                                        <span>Tematyka</span>
                                    </div>
                                    <div class="mb-2 text-muted small">

                                    </div>
                                    <p class="text-truncate mb-4 mb-md-0">
                                        Opis.
                                    </p>
                                </div>
                                <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                    <div class="d-flex flex-row align-items-center mb-1">
                                        <h4 class="mb-1 me-1 text-dark">15 zł</h4>
                                        <!-- Przecena -->
                                        <!-- <span class="text-danger"><s>$20.99</s></span> -->
                                    </div>
                                    <h6 class="text-success">Darmowa dostawa!</h6>
                                    <div class="d-flex flex-column mt-4">
                                        <button class="btn btn-primary btn-sm" type="button">Szczegóły</button>
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
                                        <img src="images/bbook3.png" class="w-100" />
                                        <a href="#!">
                                            <div class="hover-overlay">
                                                <div class="mask" style="background-color: rgba(253, 253, 253, 0.15);"></div>
                                            </div>
                                        </a>
                                    </div>
                                </div>
                                <div class="col-md-6 col-lg-6 col-xl-6">
                                    <h5 class="text-dark">Jakaś książka 3</h5>
                                    <div class="d-flex flex-row">
                                        <div class="text-danger mb-1 me-2">
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                            <i class="fa fa-star"></i>
                                        </div>
                                    </div>
                                    <div class="mt-1 mb-0 text-muted small">
                                        <span>Tematyka</span>
                                    </div>
                                    <div class="mb-2 text-muted small">

                                    </div>
                                    <p class="text-truncate mb-4 mb-md-0">
                                        Opis.
                                    </p>
                                </div>
                                <div class="col-md-6 col-lg-3 col-xl-3 border-sm-start-none border-start">
                                    <div class="d-flex flex-row align-items-center mb-1">
                                        <h4 class="mb-1 me-1 text-dark">15 zł</h4>
                                        <!-- Przecena -->
                                        <!-- <span class="text-danger"><s>$20.99</s></span> -->
                                    </div>
                                    <h6 class="text-success">Darmowa dostawa!</h6>
                                    <div class="d-flex flex-column mt-4">
                                        <button class="btn btn-primary btn-sm" type="button">Szczegóły</button>
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
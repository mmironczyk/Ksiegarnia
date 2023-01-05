<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/cart.css">
    <title>Bookzwami</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>
<%@include file="fragment/navbar.jspf"%>
    <!-- Credit card form -->
        <div class="d-flex justify-content-center" style="margin-top:80px;">
            <div class="col-md-5 mb-4">
                <div class="card mb-4">
                    <div class="card-header py-3">
                        <h5 class="mb-0 d-flex justify-content-center">Dane do faktury</h5>
                    </div>
                    <div class="card-body">
                        <form>
                            <!-- 2 column grid layout with text inputs for the first and last names -->
                            <div class="row mb-4">
                                <div class="col">
                                    <div class="form-outline">
                                        <input type="text" class="form-control" />
                                        <label class="form-label">Imię</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-outline">
                                        <input type="text" class="form-control" />
                                        <label class="form-label">Nazwisko</label>
                                    </div>
                                </div>
                            </div>

                            <!-- Text input -->
                            <div class="row mb-4">
                                <div class="col">
                                    <div class="form-outline">
                                        <input type="text" class="form-control" />
                                        <label class="form-label">Miejscowość</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-outline">
                                        <input type="text" class="form-control" />
                                        <label class="form-label">Ulica</label>
                                    </div>
                                </div>
                            </div>

                            <!-- Text input -->
                            <div class="form-outline mb-4">
                                <input type="email" class="form-control" />
                                <label class="form-label">Adres email</label>
                            </div>

                            <!-- Email input -->
                            <div class="form-outline mb-4">
                                <input type="text" class="form-control" />
                                <label class="form-label">Telefon</label>
                            </div>

                            <hr class="my-4" />

                            <h5 class="mb-4 d-flex justify-content-center">Metoda płatności</h5>
                            <div class="form-outline mb-4">
                                <label class="form-label">Masz kod rabatowy? Wpisz go poniżej.</label>
                                <input type="text" class="form-control" />

                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault"/>
                                <label class="form-check-label">
                                    Gotówka
                                </label>
                                <br>
                                <input class="form-check-input" type="radio" name="flexRadioDefault"/>
                                <label class="form-check-label">
                                    Przelew bankowy
                                </label>
                            </div>

                            <hr class="my-4" />
                            <h5 class="mb-4 d-flex justify-content-centerd-flex justify-content-center">Podsumowanie</h5>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                    <h6 class="mb-2 ">Razem:</h6>
                                    <span id="1">${total} zł</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                    <h6 class="mb-2 ">Rabat:</h6>
                                    <span id="2">${total} zł</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                    <h6 class="mb-2 ">Do zapłaty:</h6>
                                    <span id="3">${total} zł</span>
                                </li>

                                <br>
                            </ul>
                            <button class="btn btn-primary btn-lg btn-block" type="submit">
                                Potwierdź
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    <!-- Credit card form -->

<%@include file="fragment/footer.jspf"%>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
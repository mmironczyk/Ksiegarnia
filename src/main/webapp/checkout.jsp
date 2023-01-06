<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <div class="d-flex justify-content-center" style="margin-top:80px;">
            <div class="col-md-5 mb-4">
                <div class="card mb-4">
                    <div class="card-header py-3">
                        <h5 class="mb-0 d-flex justify-content-center">Dane do faktury</h5>
                    </div>
                    <div class="card-body">
                        <form action="/Ksiegarnia_war_exploded/Final" id="final" name="final" method="post"></form>
                            <div class="row mb-4">
                                <div class="col">
                                    <div class="form-outline">
                                        <input type="text" class="form-control" id="imie" name="imie" form="final" />
                                        <label class="form-label">Imię</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-outline">
                                        <input type="text" class="form-control" id="nazwisko" name="nazwisko" form="final" />
                                        <label class="form-label">Nazwisko</label>
                                    </div>
                                </div>
                            </div>
                            <div class="row mb-4">
                                <div class="col">
                                    <div class="form-outline">
                                        <input type="text" class="form-control" id="miejscowosc" name="miejscowosc" form="final"/>
                                        <label class="form-label">Miejscowość</label>
                                    </div>
                                </div>
                                <div class="col">
                                    <div class="form-outline">
                                        <input type="text" class="form-control" id="ulica" name="ulica" form="final" />
                                        <label class="form-label">Ulica</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-outline mb-4">
                                <input type="email" class="form-control" id="email" name="email" form="final" />
                                <label class="form-label">Adres email</label>
                            </div>
                            <div class="form-outline mb-4">
                                <input type="text" class="form-control" id="telefon" name="telefon" form="final"  />
                                <label class="form-label">Telefon</label>
                            </div>
                            <hr class="my-4" />
                            <h5 class="mb-4 d-flex justify-content-center">Metoda płatności</h5>
                            <div class="form-outline mb-4">
                            </div>
                                <form action="/Ksiegarnia_war_exploded/checkPromo" id="promo" name="promo" method="post">
                                <label class="form-label">Masz kod rabatowy? Wpisz go poniżej.</label>
                                <input type="text" id="kod" name="kod" value="${ko}" class="form-control" /><BR>
                                </form>
                                <button type="submit" name="submit" form="promo" class="btn btn-primary btn-lg btn-block">
                                    Sprawdź kod rabatowy
                                </button>
                             </div>
                            <input type="text" id="kod1" name="kod1" value="${ko}" hidden form="final"/>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="typ1" value="Gotówka" form="final" />
                                <label class="form-check-label">
                                    Gotówka
                                </label>
                                <br>
                                <input class="form-check-input" type="radio" name="flexRadioDefault" id="typ2" value="Przelew Bankowy" form="final" />
                                <label class="form-check-label">
                                    Przelew bankowy
                                </label>
                            </div>
                            <hr class="my-4" />
                            <h5 class="mb-4 d-flex justify-content-centerd-flex justify-content-center">Podsumowanie</h5>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                    <h6 class="mb-2 ">Razem:</h6>
                                    <span id="1"><fmt:formatNumber type="CURRENCY" maxFractionDigits="2" value="${value}"/> </span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                    <h6 class="mb-2 ">Rabat:</h6>
                                    <c:set var="rg" value="${rabat}"/>
                                    <c:if test="${empty rabat}">
                                        <c:set var="rg" value="${0}"/>
                                    </c:if>
                                    <span id="2"><fmt:formatNumber type="CURRENCY" maxFractionDigits="2" value="${(rg/100)*value}"/> </span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                    <h6 class="mb-2 ">Do zapłaty:</h6>
                                    <span id="3"><fmt:formatNumber type="CURRENCY" maxFractionDigits="2" value="${value-((rg/100)*value)}"/> </span>
                                </li>
                                    <input form="final" hidden type="text" id="kwota" name="kwota" value="${value}"/>
                                <input form="final" hidden type="text" id="rabat" name="rabat" value="${(rg/100)*value}"/>
                                <br>
                            </ul>
                            <button class="btn btn-primary btn-lg btn-block" form="final" type="submit">
                                Potwierdź
                            </button>
                    </div>
                </div>
            </div>
        </div>
<%@include file="fragment/footer.jspf"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<script src="js/addtocart.js"></script>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Home page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="fragment/navbar.jspf" %>
<div class="mx-auto pt-4" style="max-width: 1200px;">
    <div class="d-flex p-4 mb-5">
        <div class="text-center" style="flex: 1;">
            <img src="${product.image}" class="m-auto product-image" alt="tytuł">
        </div>
        <div class="ps-2" style="flex: 1;">
            <p class="fw-bold fs-4 ps-2">${product.title}</p>
            <div class="container text-start ps-2">
                <div class="row">
                    <div class="col-3">
                        <p>Autor:</p>
                    </div>
                    <div class="col">
                        <p>${product.author}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <p>Kategorie:</p>
                    </div>
                    <div class="col">
                        <p>${product.category}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <p>Typ okładki:</p>
                    </div>
                    <div class="col">
                        <p>miękka okładka</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <p>EAN:</p>
                    </div>
                    <div class="col">
                        <p>123456789</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <p>Ilość stron:</p>
                    </div>
                    <div class="col">
                        <p>${product.pages}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="col-3">
                        <p>Data wydania:</p>
                    </div>
                    <div class="col">
                        <p>${product.date}</p>
                    </div>
                </div>
                <div class="row mt-4">
                    <div class="col-3">
                        <p>Dostępność:</p>
                    </div>
                    <div class="col">
                        <p>${product.amount}</p>
                    </div>
                </div>
                <div class="row">
                    <div class="fw-bold fs-3 text-danger">
                        <p>${product.cost} zł</p>
                    </div>
                </div>
                <form class="mt-3">
                    <div id="decrease" class="quantity-button" onclick="decreaseValue()">-</div>
                    <input type="number" id="number" value="1">
                    <div id="increase" class="quantity-button" onclick="increaseValue()">+</div>
                </form>
                <button class="btn btn-outline-danger mt-5">
                    <a href="#" id="${product.productId}" class="text-danger fw-light fs-3 add-to-cart">DODAJ DO KOSZYKA</a>
                </button>
                <button class="btn btn-outline-secondary mt-3 d-block">
                    <span class="text-secondary fw-light fs-5">REZERWUJ</span>
                </button>
            </div>
        </div>
    </div>
    <hr>
    <div class="mt-5">
        <div>
            <span class="text-danger fw-bold fs-5 text-center"><p>SZCZEGÓŁY</p></span>
            <p class="fw-normal fs-8">
                ${product.description}
            </p>
        </div>
        <div class="mt-5">
            <span class="text-danger fw-bold fs-5 text-center"><p>OPINIE</p></span>
            <button class="btn btn-outline-danger">
                <span class="text-danger fw-light fs-8">DODAJ RECENZJĘ</span>
            </button>
            <div class="mt-3">
                <%@include file="fragment/review.jspf" %>
            </div>
        </div>
    </div>
</div>
<%@include file="fragment/footer.jspf" %>

<script>
    function decreaseValue() {
        let value = parseInt(document.getElementById("number").value, 10);
        value = isNaN(value) ? 0 : value;
        value < 1 ? value = 1 : "";
        value--;
        document.getElementById("number").value = value;
    }

    function increaseValue() {
        let value = parseInt(document.getElementById("number").value, 10);
        value = isNaN(value) ? 0 : value;
        value++;
        document.getElementById("number").value = value;
    }
</script>
<script src="js/addtocart.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Książki</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="fragment/navbar.jspf" %>
<nav aria-label="Books page" class="text-center mx-auto" style="max-width: 1200px; margin-top:80px;">
    <div class="d-flex justify-content-center flex-wrap">
<c:if test="${!empty requestScope.allProducts}">

    <c:forEach items="${requestScope.allProducts}" var="product">

        <div class="d-flex flex-column my-4 border border-light mx-4" style="width: 225px; height: 440px">
            <div class="text-center mt-4">
                <img src="${product.image}" class="mx-auto" style="width: 150px; height: 200px;">
            </div>
            <div>
                <p class="mt-1 fw-bold">${product.title}</p>
                <p class="fw-light mt-4 mb-0">${product.author}</p>
                <p class="mt-1 text-danger mb-0">${product.cost} PLN</p>
                <input hidden type="number" id="S_${product.productId}" name="S_${product.productId}" value="${product.amount}"/>
                <button type="button" id="${product.productId}" class="btn btn-outline-secondary mt-1 add-to-cart">
                    <span class="text-secondary fw-normal fs-9">Dodaj do koszyka</span>
                </button>
                <a href="Product?id=${product.productId}" class="btn btn-outline-secondary mt-1">
                    <span class="text-secondary fw-normal fs-9">Informacje</span>
                </a>
            </div>
        </div>

    </c:forEach>
</c:if>
    <c:if test="${empty requestScope.allProducts}">
        <section id="form">
            <div class="container">
                <div class="row">
                    <div class="alert alert-danger">
                        <strong>Brak wyników do wyświetlenia</strong>
                    </div>
                </div>
            </div>
        </section>
    </c:if>
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
<%@include file="fragment/footer.jspf" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script src="js/jquery.js"></script>
<script src="js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

<script>
    $(document).ready(function () {
        // Wyszukanie elementów zawierających klasę add-to-cart i odczytanie powiązanych z tym elementem id oraz ilości
        $('.add-to-cart').click(function () {
            var id = $(this).attr('id');
            var qaunty = $("#S_"+id).val();
            if(qaunty>0)
            {
                addProduct(id, 1);
            }
            else
            {
                alert("Brak wystarczającej liczby książek w magazynie!");
            }
        });

        // Funkcja obsługujaca przekazanie produktu do servletu odpowiedzialnego za dodanie produktu do koszyka poprzez jQuerry i ajax
        function addProduct(id, amount) {
            $.ajax({
                url: 'addCart',
                type: 'GET',
                data: {"id": id, "amount": amount},
                success: (data) => {
                    if (data.redirect) {
                        window.location.href = data.redirect;
                    }else{
                        $("#number").html(data);
                    }
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    window.location.href = "/Ksiegarnia_war_exploded/login.jsp";
                    if (thrownError.redirect.length) {
                        window.location.replace(thrownError.redirect);
                    } else {
                        alert('Spróbuj ponownie!');
                    }
                }
            });
        }
    })
</script>
</body>
</html>














































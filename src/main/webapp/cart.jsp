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

<div class="d-flex flex-column" style="margin-top:80px;">
    <section class="h-100 gradient-custom">
        <div class="container py-5">
            <div class="row d-flex justify-content-left my-4">
                <div class="col-md-12">
                    <div class="card mb-4">
                        <div class="card-header py-3">
                            <h5 class="mb-0">Koszyk</h5>
                        </div>
                        <c:set var="total" value="${0}"/>
                        <c:if test="${!empty requestScope.carts}">
                        <c:forEach items="${requestScope.carts}" var="product">
                        <div class="card-body">
                            <!-- Single item -->
                            <div class="row">
                                <div class="col-lg-3 col-md-12 mb-4 mb-lg-0">
                                    <!-- Image -->
                                    <div class="bg-image hover-overlay hover-zoom ripple rounded" data-mdb-ripple-color="light">
                                        <img src="${product.image}" class="w-100"/>
                                            <div class="mask" style="background-color: rgba(251, 251, 251, 0.2)"></div>
                                        </a>
                                    </div>
                                    <!-- Image -->
                                </div>

                                <div class="col-lg-5 col-md-6 mb-4 mb-lg-0">
                                    <!-- Data -->
                                    <p><strong>${product.title}</strong></p>
                                    <p>Gatunek: ${product.category}</p>
                                    <a href="${pageContext.request.contextPath}/DeleteFromCart?id=${product.cartId}" onclick="return confirm('Usunąć wybrany produkt?')" class="btn btn-primary btn-sm me-1 mb-2" data-mdb-toggle="tooltip"
                                            title="Usuń z koszyka">
                                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash" viewBox="0 0 16 16">
                                            <path d="M5.5 5.5A.5.5 0 0 1 6 6v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm2.5 0a.5.5 0 0 1 .5.5v6a.5.5 0 0 1-1 0V6a.5.5 0 0 1 .5-.5zm3 .5a.5.5 0 0 0-1 0v6a.5.5 0 0 0 1 0V6z"/>
                                            <path fill-rule="evenodd" d="M14.5 3a1 1 0 0 1-1 1H13v9a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2V4h-.5a1 1 0 0 1-1-1V2a1 1 0 0 1 1-1H6a1 1 0 0 1 1-1h2a1 1 0 0 1 1 1h3.5a1 1 0 0 1 1 1v1zM4.118 4 4 4.059V13a1 1 0 0 0 1 1h6a1 1 0 0 0 1-1V4.059L11.882 4H4.118zM2.5 3V2h11v1h-11z"/>
                                        </svg>
                                    </a>
                                    <!-- Data -->
                                </div>

                                <div class="col-lg-4 col-md-6 mb-4 mb-lg-0">
                                    <!-- Quantity -->
                                    <div class="d-flex mb-4" style="max-width: 300px">
                                        <button type="button" id="D_${product.cartId}" class="btn btn-primary px-3 me-2 cart_quantity_down">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-dash-lg" viewBox="0 0 16 16">
                                                <path fill-rule="evenodd" d="M2 8a.5.5 0 0 1 .5-.5h11a.5.5 0 0 1 0 1h-11A.5.5 0 0 1 2 8Z"/>
                                            </svg>
                                        </button>

                                        <input class="cart_quantity_input"
                                               style="width: 100px;"
                                               type="number" name="quantity" id="I_${product.cartId}"
                                               value="${product.amount}" autocomplete="off"
                                               size="2" disabled>
                                        <button type="button" id="U_${product.cartId}" class="btn btn-primary px-3 ms-2 cart_quantity_up">
                                            <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-plus-lg" viewBox="0 0 16 16">
                                                <path fill-rule="evenodd" d="M8 2a.5.5 0 0 1 .5.5v5h5a.5.5 0 0 1 0 1h-5v5a.5.5 0 0 1-1 0v-5h-5a.5.5 0 0 1 0-1h5v-5A.5.5 0 0 1 8 2Z"/>
                                            </svg>
                                        </button>
                                    </div>
                                    <!-- Quantity -->

                                    <!-- Price -->


                                        <strong>Cena za sztukę: </strong><a id="C_${product.cartId}">${product.cost}</a> zł<BR>
                                    <!-- Price -->
                                    <strong>Cena ogółem: </strong><a id="T_${product.cartId}">${product.cost*product.amount}</a> zł

                                </div>
                            </div>
                            <!-- Single item -->
                            <p id="demo"></p>
                            <hr class="my-4" />
                            <c:set var="total" value="${total+(product.cost*product.amount)}"/>
                            </c:forEach>
                            </c:if>
                        </div>
                    </div>
                </div>
            </div>
            <center>
                <div class="col-md-12 justify-content-right my-4">
                    <div class="card mb-4">
                        <div class="card-header py-3">
                            <h5 class="mb-0">Podusmowanie</h5>
                        </div>
                        <div class="card-body">
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                    Produkty:
                                    <span id="total">${total} zł</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                                    Dostawa:
                                    <span>GRATIS</span>
                                </li>
                                <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                                    <div>
                                        <strong>Razem</strong>
                                    </div>
                                    <span><strong id="total2">${total} zł</strong></span>
                                </li>
                            </ul>

                            <a class="btn btn-primary btn-lg btn-block" href="checkout.jsp">
                                Przejdź do kasy
                            </a>
                        </div>
                    </div>
                </div>
            </center>
            </div>
    </section>
</div>
<%@include file="fragment/footer.jspf"%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script src="js/jquery.js"></script>
<script src="js/main.js"></script>
<script>
    $(document).ready(function () {
        if ("userID" in window)
            getInitProductNumber(userID);
        $(".cart_quantity_down").click(function(){
            var id = $(this).attr('id').substring(2);
            if($("#I_"+id).val() > 1 )
                reduceProduct(id);
        });

        $(".cart_quantity_up").click(function(){
            var id = $(this).attr('id').substring(2);
            increaseProduct(id);
        });

        function reduceProduct(id){
            $.ajax({
                url: 'ReduceAmount',
                type: 'GET',
                data: {"id": id},
                success: (data) => {
                    if (data.redirect) {
                        window.location.href = data.redirect;
                    }else{
                        reCalculateDecrease(id);
                    }
                }
            });
        }

        //increase product to cart
        function increaseProduct(id){
            $.ajax({
                url: 'IncreseAmount',
                type: 'GET',
                data: {"id": id},
                success: (data) => {
                    reCalculateIncrease(id);
                    if (data.redirect) {
                        window.location.href = data.redirect;
                    }else{
                        $("#number").html(data);
                    }
                }
            });
        }
        function getInitProductNumber(id) {
            $.ajax({
                url: 'UsersCarts',
                type: 'GET',
                data: {"id": id},
                success: (data) => {
                    $("#number").html(data);
                }
            });
        }
        function reCalculateDecrease(id){
            var price = parseFloat($("#C_"+id).text());
            $("#I_"+id).val($("#I_"+id).val()-1);
            var pecies = parseInt($("#I_"+id).val());
            $("#T_"+id).text((pecies*price).toFixed(2));
            var total = parseFloat($("#total").text());
            $("#total").text((total - price).toFixed(2)+ " zł");
            $("#total2").text((total - price).toFixed(2)+ " zł");
        }
        function reCalculateIncrease(id){
            var price = parseFloat($("#C_"+id).text());
            var pecies = parseInt($("#I_"+id).val()) + 1 ;
            $("#I_"+id).val(pecies);
            $("#T_"+id).text((pecies*price).toFixed(2));
            var total = parseFloat($("#total").text());
            $("#total").text((total + price).toFixed(2)+ " zł");
            $("#total2").text((total + price).toFixed(2)+" zł");
        }
    })
</script>



</body>
</html>
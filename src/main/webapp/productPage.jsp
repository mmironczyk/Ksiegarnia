<%@ page import="com.ksiegarnia.model.UserDbModel" %>
<%@ page import="com.ksiegarnia.beans.Review" %>
<%@ page import="com.ksiegarnia.beans.User" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Home page</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="css/styles.css" rel="stylesheet" type="text/css">
</head>
<body>
<%@include file="fragment/navbar.jspf" %>
<div class="mx-auto pt-4" style="max-width: 1200px; margin-top:80px;">
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
                    <input type="number" id="amount" value="1">
                    <div id="increase" class="quantity-button" onclick="increaseValue()">+</div>
                </form>
                    <button  type="button" id="${product.productId}" class="btn btn-primary add-to-cart mt-3 d-block">DODAJ DO KOSZYKA</button>
                    <button  type="button" id="${product.productId}" class="btn btn-primary reservation mt-3 d-block">REZERWUJ</button>
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
            <button class="btn btn-outline-danger" type="button" data-bs-toggle="modal" data-bs-target="#addReviewModal">
                <span class="text-danger fw-light fs-8">DODAJ OPINIĘ</span>
            </button>
            <div class="mt-3">
                <nav aria-label="Reviews page" class="text-start mx-auto" style="max-width: 800px" >
                    <div class="">
                        <c:if test="${!empty requestScope.allReviews}">
                            <c:forEach items="${requestScope.allReviews}" var="review">
                                <div class="card mb-3">
                                    <div class="card-header fw-bold">
                                        <%
                                            int usrID = ((Review) pageContext.getAttribute("review")).getUserId();
                                            User user = new UserDbModel().getUser(usrID);
                                            String usrName = "";
                                            if (user != null)
                                                usrName = user.getImie();
                                        %>
                                        <%= usrName %>
                                    </div>
                                    <div class="card-body">
                                            <p class="card-text">${review.reviewText}</p>
                                            <c:if test="${!review.reviewImage.equals('')}">
                                                <img src="${review.reviewImage}" width="100" height="100" class="d-inline-block">
                                            </c:if>
                                            <c:if test="${!review.linkToIFrameLink().equals('')}">
                                                <iframe src="${review.linkToIFrameLink()}" width="175" height="100" class="d-inline-block float-end"></iframe>
                                            </c:if>
                                        </ul>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:if>
                    </div>
                </nav>
            </div>
        </div>
    </div>
</div>

<div class="modal" id="addReviewModal" tabindex="-1">
    <div class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Dodaj opinie</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form id="reviewForm" action="AddReview" method="post" enctype="multipart/form-data">
                    <textarea name="reviewTextArea" id="reviewTextArea" class="form-control" placeholder="Wpisz opinie" required style="height: 100px"></textarea>
                    <div class="input-group mb-3">
                        <label class="input-group fw-bold mt-2 mb-1" for="reviewImgInput">Dodaj zdjęcie</label>
                        <input type="file" name="reviewImgInput" id="reviewImgInput" class="form-control" accept="image/*" />
                    </div>
                    <label class="fw-bold mt-2 mb-1" for="reviewYtLink">Dodaj link do YouTube</label>
                    <input type="text" name="reviewYtLink" id="reviewYtLink" placeholder="https://www.youtube.com/watch?v=example" />
                    <input type="text" hidden name="pID" id="pID" value="${product.productId}" />
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Zamknij</button>
                <button type="submit" name="submit" form="reviewForm" class="btn btn-primary">Dodaj</button>
            </div>
        </div>
    </div>
</div>
<%@include file="fragment/footer.jspf" %>

<script>
       function decreaseValue() {
        let value = parseInt(document.getElementById("amount").value, 10);
        value = isNaN(value) ? 0 : value;
        value < 1 ? value = 1 : "";
        value--;
        document.getElementById("amount").value = value;
    }

    function increaseValue() {
        let value = parseInt(document.getElementById("amount").value, 10);
        value = isNaN(value) ? 0 : value;
        value++;
        document.getElementById("amount").value = value;
    }
</script>


<script src="js/jquery.js"></script>
<script src="js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

<script>
    $(document).ready(function () {
        $('.add-to-cart').click(function () {
            var id = $(this).attr('id');
            var qaunty = $("#amount").val();
            if(qaunty<=${product.amount})
            {
                addProduct(id, qaunty);
            }
            else
            {
                alert("Brak wystarczającej liczby książek w magazynie!");
            }

        });
        $('.reservation').click(function () {
            var id = $(this).attr('id');
            var qaunty = $("#amount").val();
            if(qaunty<=${product.amount})
            {
                reserve(id, qaunty);
            }
            else
            {
                alert("Brak wystarczającej liczby książek w magazynie!");
            }

        });

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
        function reserve(id, amount) {
            $.ajax({
                url: 'addReservation',
                type: 'GET',
                data: {"id": id, "amount": amount},
                success: (data) => {
                    window.location.reload();
                    if (data.redirect) {
                        window.location.href = data.redirect;
                    }
                    else{
                    }
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert("error");
                    if (thrownError.redirect.length) {
                        window.location.replace(thrownError.redirect);
                    } else {
                    }
                }
            });
        }
    })
</script>
</body>
</html>

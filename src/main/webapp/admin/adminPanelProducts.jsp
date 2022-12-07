<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.ksiegarnia.controller.admin.ServletAdProduct" %>
<!DOCTYPE html>
<html>
<head>
    <title>Produkty</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="css/main.css" rel="stylesheet">
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.css"/>
    <script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.13.1/datatables.min.js"></script>
    <link href='jquery.dataTables.bootstrap5.css' rel='stylesheet' />
    <script src="jquery.dataTables.bootstrap5.js"></script>
</head>
<body>
<%@include file="../fragment/navbar.jspf" %>
<div class="d-flex flex-row" style="margin-top:75px;">
    <div>
        <%@include file="adminSidebar.jspf" %>
    </div>
    <div id="adminPanelContent" class="flex-grow-1">
        <div class="col-sm-9 padding-right">
            <h2>Książki
                <a class="btn btn-success" style="float: right;" href="addproduct.jsp">Dodaj nowy produkt</a>
            </h2>
            <div class="table-responsive cart_info">
                <table id="prod" name="prod"  class="table table-striped table-bordered" style="width:100%;">
                    <thead>
                    <tr class="cart_menu">
                        <td class="description">Tytuł</td>
                        <td class="price">Cena</td>
                        <td class="quantity">Ilość</td>
                        <td>Menu</td>
                    </tr>
                    </thead>
                    <c:if test="${!empty requestScope.allProductsAdmin}">
                        <c:forEach items="${requestScope.allProductsAdmin}" var="ksiazka">
                            <tr>
                                <td class="cart_description">
                                    <p>${ksiazka.title}</p>
                                </td>
                                <td class="cart_price">
                                    <h4>${ksiazka.cost} zł</h4>
                                </td>
                                <td class="cart_price">
                                    <p>${ksiazka.amount}</p>
                                </td>
                                <td >
                                    <a style="text-decoration: none !important;" href="DeleteProduct?id=${ksiazka.productId}" onclick="return confirm('Czy na pewno chesz usunąć wybraną pozycję?')"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash3" viewBox="0 0 16 16">
                                        <path d="M6.5 1h3a.5.5 0 0 1 .5.5v1H6v-1a.5.5 0 0 1 .5-.5ZM11 2.5v-1A1.5 1.5 0 0 0 9.5 0h-3A1.5 1.5 0 0 0 5 1.5v1H2.506a.58.58 0 0 0-.01 0H1.5a.5.5 0 0 0 0 1h.538l.853 10.66A2 2 0 0 0 4.885 16h6.23a2 2 0 0 0 1.994-1.84l.853-10.66h.538a.5.5 0 0 0 0-1h-.995a.59.59 0 0 0-.01 0H11Zm1.958 1-.846 10.58a1 1 0 0 1-.997.92h-6.23a1 1 0 0 1-.997-.92L3.042 3.5h9.916Zm-7.487 1a.5.5 0 0 1 .528.47l.5 8.5a.5.5 0 0 1-.998.06L5 5.03a.5.5 0 0 1 .47-.53Zm5.058 0a.5.5 0 0 1 .47.53l-.5 8.5a.5.5 0 1 1-.998-.06l.5-8.5a.5.5 0 0 1 .528-.47ZM8 4.5a.5.5 0 0 1 .5.5v8.5a.5.5 0 0 1-1 0V5a.5.5 0 0 1 .5-.5Z"/>
                                    </svg></a>
                                    <a style="text-decoration: none !important;" href="ManageProduct?id=${ksiazka.productId}"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-pencil-square" viewBox="0 0 16 16">
                                        <path d="M15.502 1.94a.5.5 0 0 1 0 .706L14.459 3.69l-2-2L13.502.646a.5.5 0 0 1 .707 0l1.293 1.293zm-1.75 2.456-2-2L4.939 9.21a.5.5 0 0 0-.121.196l-.805 2.414a.25.25 0 0 0 .316.316l2.414-.805a.5.5 0 0 0 .196-.12l6.813-6.814z"/>
                                        <path fill-rule="evenodd" d="M1 13.5A1.5 1.5 0 0 0 2.5 15h11a1.5 1.5 0 0 0 1.5-1.5v-6a.5.5 0 0 0-1 0v6a.5.5 0 0 1-.5.5h-11a.5.5 0 0 1-.5-.5v-11a.5.5 0 0 1 .5-.5H9a.5.5 0 0 0 0-1H2.5A1.5 1.5 0 0 0 1 2.5v11z"/>
                                    </svg></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty requestScope.allProductsAdmin}">
                        <tr><td colspan="5" style="text-align: center;">Brak danych</td></tr>
                        </c:if>
                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>
</section>
    </div>
</div>

<script>

$(document).ready(function () {
$('#prod').DataTable({
    language: {
        url: "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Polish.json"
    },
    pageLength: 8,
    lengthChange: false,
    search: false,
    });
});
</script>



<%@include file="../fragment/footer.jspf" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>

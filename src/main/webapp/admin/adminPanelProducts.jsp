<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.ksiegarnia.controller.admin.ServletAdProduct" %>
<!DOCTYPE html>
<html>
<head>
    <title>Produkty</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="css/main.css" rel="stylesheet">
</head>
<body>
<%@include file="../fragment/navbar.jspf" %>
<div class="d-flex flex-row">
    <div>
        <%@include file="adminSidebar.jspf" %>
    </div>
    <div id="adminPanelContent" class="flex-grow-1">
        <div class="col-sm-9 padding-right">

            <h2>Książki
                <a class="btn btn-success" style="float: right;" href="addproduct.jsp">Dodaj nowy produkt</a>
            </h2>
            <div class="table-responsive cart_info">
                <table class="table table-condensed">
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
                                    <a  href="DeleteProduct?id=${ksiazka.productId}">D</a>
                                    <a  href="AdminProduct?id=${ksiazka.productId}">A</a>
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
<%@include file="../fragment/footer.jspf" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Zamówienia</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<%@include file="../fragment/navbar.jspf" %>
<div class="d-flex flex-row" style="margin-top:75px;">
    <div>
        <%@include file="userSidebar.jspf" %>
    </div>
    <div id="adminPanelContent" class="flex-grow-1">
        <div class="col-sm-9 padding-right">
            <h2>Historia Zamówień
            </h2>
            <div class="table-responsive cart_info">
                <table id="prod" name="prod"  class="table table-striped table-bordered" style="width:100%;">
                    <thead>
                    <tr class="cart_menu">
                        <td>Nr. Zamówienia</td>
                        <td>Wartość zamówienia</td>
                        <td>Menu</td>
                    </tr>
                    </thead>
                    <c:if test="${!empty requestScope.allOrders}">
                        <c:forEach items="${requestScope.allOrders}" var="order">
                            <tr>
                                <td class="cart_description">
                                    <p>${order.nr_zamowienia}</p>
                                </td>
                                <td class="cart_price">
                                    <h4><fmt:formatNumber type="CURRENCY" maxFractionDigits="2" value="${order.kwota}"/></h4>
                                </td>
                                <td>
                                    <a style="text-decoration: none !important;" href="History?id=${order.id_zamowienia}" onclick="return confirm('Czy na pewno chesz usunąć wybranego użytkownika?')"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-info-circle" viewBox="0 0 16 16">
                                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                                        <path d="m8.93 6.588-2.29.287-.082.38.45.083c.294.07.352.176.288.469l-.738 3.468c-.194.897.105 1.319.808 1.319.545 0 1.178-.252 1.465-.598l.088-.416c-.2.176-.492.246-.686.246-.275 0-.375-.193-.304-.533L8.93 6.588zM9 4.5a1 1 0 1 1-2 0 1 1 0 0 1 2 0z"/>
                                    </svg></a>
                                </td>
                            </tr>
                        </c:forEach>
                    </c:if>
                    <c:if test="${empty requestScope.allOrders}">
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

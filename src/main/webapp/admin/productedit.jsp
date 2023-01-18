<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.ksiegarnia.controller.admin.ManageProduct" %>
<!DOCTYPE html>
<html>
<head>
    <title>Produkty</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="../css/main.css" rel="stylesheet">
</head>
<body>
<%@include file="../fragment/navbar.jspf" %>
<div class="d-flex flex-row" style="margin-top:50px;">
    <div>
        <%@include file="adminSidebar.jspf" %>
    </div>
    <div id="adminPanelContent" class="flex-grow-1">
        <div class="col-sm-9 padding-right">

            <c:if test="${empty requestScope.type}">
                <c:set var="type" value="Zmień"/>
            </c:if>

            <div class="col-sm-9 padding-right">
                <div class="col-sm-9 padding-right">
                    <div class="product-information">
                        <form action="ManageProduct" method="post" enctype="multipart/form-data">
                            <h2>${type} Książkę</h2>
                            <label>Tytuł</label>
                            <input type="text" placeholder="Tytuł" name="title" value="${product.title}" class="input-field" id="title" required/>
                            <label>Gatunek</label>
                            <input type="text" placeholder="Gatunek" name="gatunek" value="${product.category}" class="input-field" id="gatunek"/>
                            <label>Opis</label>
                            <textarea  placeholder="Opis" name="Description" class="input-field" id="Description">${product.description}</textarea>
                            <label>Autor</label>
                            <input type="text" placeholder="Autor" name="Autor" value="${product.author}" class="input-field" id="Autor"/>
                            <label>Data wydania</label>
                            <input type="text" placeholder="Data wydania" name="data" value="${product.date}" class="input-field" id="data"/>
                            <label>Ilość stron</label>
                            <input type="number" placeholder="Ilość stron" name="pages" value="${product.pages}" min="1" class="input-field" id="pages"/>
                            <label>Ilość sztuk</label>
                            <input type="number" placeholder="Ilość sztuk" name="Amount" value="${product.amount}" class="input-field" min="1" id="Amount" required/>
                            <label>Cena</label>
                            <input type="number" placeholder="Cena" name="cena" value="${product.cost}" step="0.01" class="input-field" min="1" id="cena" required/>
                            <input type="idt" hidden name="idt" id="idt" value="${product.productId}"/><br><br>
                            <button type="submit" class="btn btn-success">${type} Książkę</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</section>
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

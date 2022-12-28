<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Opinie</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <link href="../css/main.css" rel="stylesheet">
</head>
<body>
<%@include file="fragment/navbar.jspf" %>
<div class="d-flex flex-row" style="margin-top: 140px">
    <div>
        <%@include file="user/userSidebar.jspf" %>
    </div>
    <div id="adminPanelContent" class="flex-grow-1">
        <div class="col-sm-9 padding-right">
            <div class="col-sm-9 padding-right">
                <div class="col-sm-9 padding-right">
                    <div class="product-information">
                        <form action="ManageReview" method="post" enctype="multipart/form-data">
                            <h2>Zmień opinię:</h2>
                            <p>${productTitle}</p>
                            <label>Opinia</label>
                            <textarea  placeholder="Wpisz opinie" name="reviewTextArea" class="input-field" id="reviewTextArea">${review.reviewText}</textarea>
                            <label>Link do YouTube</label>
                            <input type="text" placeholder="https://www.youtube.com/watch?v=example" name="reviewYtLink" value="${review.link}" class="input-field" id="reviewYtLink"/>
                            <input type="text" hidden name="idr" id="idr" value="${review.reviewId}"/><br><br>
                            <button type="submit" class="btn btn-success">Zmień opinię</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>


<%@include file="fragment/footer.jspf" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>

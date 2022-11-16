<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<%@include file="../../fragment/navbar.jspf" %>
<div class="d-flex flex-row">
    <div>
        <%@include file="./userSidebar.jspf" %>
    </div>
    <div id="adminPanelContent" class="flex-grow-1">
        <section>
            <div class="container">
                <div class="row">
                    <div class="alert alert-warning" role="alert" id="error" style="display: none;"></div>
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                        </div>
                    </div>
                    <div class="col-sm-9 padding-right">
                        <div class="product-details"><!--product-details-->
                            <div class="col-sm-4">
                            </div>
                            <div class="col-sm-8">
                                <div class="product-information"><!--/product-information-->
                                        <h1>Konto użytkownika ${LoginUser.getLogin()}</h1>
                                    <BR>
                                        <p>Dane Konta:</p>
                                        <p><label>Imię</label>
                                            <input type="text" placeholder="Imie"  class="input-field"  id="imie" value="${LoginUser.getImie()}" disabled/></p>
                                        <p><label>Nazwisko</label>
                                            <input type="text" placeholder="Nazwisko"  class="input-field"  id="nazwisko" value="${LoginUser.getNazwisko()} "disabled /></p>
                                        <p><label>E-mail</label>
                                            <input type="email" placeholder="E-mail"  class="input-field" name="email" id="Email" value="${LoginUser.getEmail()} " disabled/></p>
                                        <p><label>Nr. Telefonu</label>
                                            <input type="text" placeholder="telefon"  class="input-field" name="telefon" id="telefon" value="${LoginUser.getTelefon()} " disabled /></p>
                                        <label>Adres</label>
                                        <BR>
                                        <input type="text" placeholder="kod"  class="input-field" name="kod" id="kod" value="${LoginUser.getKod()} "  disabled/><BR>
                                        <input type="text" placeholder="miasto"  class="input-field" name="miasto" id="miasto" value="${LoginUser.getMiasto()} " disabled/><BR>
                                        <input type="text" placeholder="ulica"  class="input-field" name="ulica" id="ulica" value="${LoginUser.getAdres()} " disabled/><BR>

                                </div><!--/product-information-->
                            </div>
                        </div><!--/product-details-->

                    </div>
                </div>
            </div>
        </section>
    </div>
</div>
<%@include file="../../fragment/footer.jspf" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>

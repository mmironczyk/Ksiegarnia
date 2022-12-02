<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profil</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
</head>
<body>
<%@include file="../fragment/navbar.jspf" %>
<div class="d-flex flex-row">
    <div>
        <%@include file="userSidebar.jspf" %>
    </div>
    <div id="adminPanelContent" class="flex-grow-1 mx-auto">
        <section>
            <div class="container">
                <div class="row">
                    <div class="alert alert-warning" role="alert" id="error" style="display: none;"></div>
                    <div class="col-sm-3">
                        <div class="left-sidebar">
                        </div>
                    </div>
                                    <main class="col-md-9 ms-sm-auto col-lg-10 px-md-4 min-vh-100 d-flex justify-content-center p-2">
                                        <div style="width:60%;">
                                            <br><br><br>
                                            <div class="card mb-4">
                                                <div class="card-header" align="center"><h1>Twój profil</h1></div>
                                                <div class="col-md-12">
                                                    <div class="card-body">
                                                        <div class="row">
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0">Imie</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary">
                                                                ${LoginUser.getImie()}
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="row">
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0">Nazwisko</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary">
                                                                ${LoginUser.getNazwisko()}
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="row">
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0">Nr. telefonu</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary">
                                                                ${LoginUser.getTelefon()}
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="row">
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0">Adres email</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary">
                                                                ${LoginUser.getEmail()}
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="row">
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0">Miejscowość</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary">
                                                                ${LoginUser.getMiasto()}
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="row">
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0">Kod pocztowy</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary">
                                                                ${LoginUser.getKod()}
                                                            </div>
                                                        </div>
                                                        <hr>
                                                        <div class="row">
                                                            <div class="col-sm-3">
                                                                <h6 class="mb-0">Ulica</h6>
                                                            </div>
                                                            <div class="col-sm-9 text-secondary">
                                                                ${LoginUser.getAdres()}
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                            <p><button type="button" id="edo" class="btn btn-primary">Edytuj Dane Osobowe</button> <button type="button" id="ema" class="btn btn-primary">Zmień E-mail</button>
                                                <button type="button" id="pso" class="btn btn-primary">Zmień Hasło</button> <button type="button" id="add" class="btn btn-primary">Edytuj Adres</button></p>
                                            <style>
                                                #DO
                                                {
                                                    display: none;
                                                }
                                                #EM
                                                {
                                                    display: none;
                                                }
                                                #PS
                                                {
                                                    display: none;
                                                }
                                                #AD
                                                {
                                                    display: none;
                                                }
                                            </style>

                                            <form method="post" id="DO" action="ChangePersonals">
                                                <div class="row gx-3 mb-3">
                                                    <div class="col-md-6">
                                                        <label class="small mb-1" for="imie">Imię</label>
                                                        <input class="form-control" id="imie" name="imie" required type="text" value="${LoginUser.getImie()}" placeholder="Wpisz swoje imię">
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="small mb-1" for="nazwisko">Nazwisko</label>
                                                        <input class="form-control" id="nazwisko" type="text" required name="nazwisko" value="${LoginUser.getNazwisko()}" placeholder="Wpisz swoje nazwisko">
                                                    </div>
                                                </div>
                                                <button class="btn btn-success" type="submit">Zapisz zmiany</button>
                                            </form>
                                            <form method="post" id="EM" action="ChangeEmail">
                                                <div class="row gx-3 mb-3">
                                                    <div class="col-md-6">
                                                        <label class="small mb-1" for="email">Adres email</label>
                                                        <input class="form-control" id="email" name="email" required type="text" value="${LoginUser.getEmail()}" placeholder="Wpisz nowy email">
                                                    </div>
                                                </div>
                                                <button class="btn btn-success" type="submit">Zapisz zmiany</button>
                                            </form>
                                            <form method="post" id="PS" action="ChangePassword">
                                                <div class="row gx-3 mb-3">
                                                    <div class="col-md-6">
                                                        <label class="small mb-1" for="haslostare">Podaj stare hasło</label>
                                                        <input class="form-control" id="haslostare" name="haslostare" required type="password" placeholder="Wpisz stare hasło">
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="small mb-1" for="haslo">Podaj nowe hasło</label>
                                                        <input class="form-control" id="haslo" name="haslo" required type="password" placeholder="Wpisz nowe hasło">
                                                    </div>
                                                </div>
                                                <button class="btn btn-success" type="submit">Zapisz zmiany</button>
                                            </form>
                                            <form method="post" id="AD" action="ChangeAddres">
                                                <div class="row gx-3 mb-3">
                                                    <div class="col-md-6">
                                                        <label class="small mb-1" for="miasto">Miasto</label>
                                                        <input class="form-control" id="miasto" name="miasto" required type="text" value="${LoginUser.getMiasto()}" placeholder="Wpisz miasto">
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="small mb-1" for="kod">Kod pocztowy</label>
                                                        <input class="form-control" id="kod" name="kod" required type="text" value="${LoginUser.getKod()}" placeholder="Wpisz kod pocztowy">
                                                    </div>
                                                    <div class="col-md-6">
                                                        <label class="small mb-1" for="ulica">Adres</label>
                                                        <input class="form-control" id="ulica" name="ulica" required type="text" value="${LoginUser.getAdres()}" placeholder="Wpisz adres">
                                                    </div>
                                                </div>
                                                <button class="btn btn-success" type="submit">Zapisz zmiany</button>
                                            </form>
                                        <script>
                                            const btn = document.getElementById('edo');
                                            const btn2 = document.getElementById('ema');
                                            const btn3 = document.getElementById('pso');
                                            const btn4 = document.getElementById('add');
                                            const form = document.getElementById('DO');
                                            const form2 = document.getElementById('EM');
                                            const form3 = document.getElementById('PS');
                                            const form4 = document.getElementById('AD');
                                            btn.addEventListener('click', () => {
                                                if (form.style.display === 'none') {
                                                    form2.style.display = 'none';
                                                    form3.style.display = 'none';
                                                    form4.style.display = 'none';
                                                    form.style.display = 'block';
                                                } else {
                                                    form.style.display = 'none';
                                                }
                                            });
                                                btn2.addEventListener('click', () => {
                                                if (form2.style.display === 'none') {
                                                    form.style.display = 'none';
                                                    form3.style.display = 'none';
                                                    form4.style.display = 'none';
                                                form2.style.display = 'block';
                                            } else {
                                                form2.style.display = 'none';
                                            }
                                            });
                                            btn3.addEventListener('click', () => {
                                                if (form3.style.display === 'none') {
                                                    form2.style.display = 'none';
                                                    form.style.display = 'none';
                                                    form4.style.display = 'none';
                                                    form3.style.display = 'block';
                                                } else {
                                                    form3.style.display = 'none';
                                                }
                                            });
                                            btn4.addEventListener('click', () => {
                                                if (form4.style.display === 'none') {
                                                    form2.style.display = 'none';
                                                    form3.style.display = 'none';
                                                    form.style.display = 'none';
                                                    form4.style.display = 'block';
                                                } else {
                                                    form4.style.display = 'none';
                                                }
                                            });
                                        </script>
                                    </main><BR>
                            </div>
            </div></div></div>
        </section>
    </div>
</div>
<%@include file="../fragment/footer.jspf" %>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>

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
                                    <form action="Profile" method="post" id="editProfileForm" enctype="multipart/form-data" onsubmit="return validateSignup();">
                                        <h2>${LoginUser.userName}</h2>
                                        <p>Account Setting</p>
                                        <label>Name</label>
                                        <input type="text" placeholder="Name"  class="input-field"  id="editUserName" value="${LoginUser.userName}" disabled required/>
                                        <input type="hidden" name="username" value="${LoginUser.userName}"/>
                                        <label>E-mail</label>
                                        <input type="email" placeholder="E-mail"  class="input-field" name="email" id="editEmail" value="${LoginUser.email}" required/>
                                        <label>Password</label>
                                        <input type="Password" placeholder="Password"  class="input-field" name="password" id="SignupPassword" required/>
                                        <label>Confirm Password</label>
                                        <input type="Password" placeholder="Confirm Password"  class="input-field" id="SignupConfirmPassword" required/>

                                        <label>Address</label>
                                        <input type="text" placeholder="Address"  class="input-field" name="address" id="editAddress" value="${LoginUser.address}" />
                                        <label>Job</label>
                                        <input type="text" placeholder="Job"  class="input-field" name="job" id="editJob" value="${LoginUser.job}"/>
                                        <label>Credit Card</label>
                                        <input type="text" placeholder="Credit Card"  class="input-field" name="creditcard" id="SignupCreditCard" value="${LoginUser.creditCard}" required/>


                                        <label>Image</label>
                                        <input type="file" name="image" id="image" accept="image/*" /><br/>
                                        <button type="submit" class="btn btn-default" id="editSubmitBtn">Update</button>
                                    </form>
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

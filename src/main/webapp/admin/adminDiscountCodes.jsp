<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.ksiegarnia.controller.admin.ServletAdProduct" %>
<!DOCTYPE html>
<html>
<head>
  <title>Kody rabatowe</title>
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
      <h2>Kody rabatowe</h2>
      <form>
        <div>
          <a>Kod rabatowy:</a>
          <input type="text" style="margin-left: 37px;">
           <br> <br>
          <a>Wartość rabatu (%):</a>
          <input type=number step=0.01 /> <br> <br>
          <button type="button" class="btn btn-primary">Wygeneruj kod</button>
          <button type="button" class="btn btn-success">Zapisz do bazy</button>
        </div>
      </form>
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

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Książki</title>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
  <script src="https://cdn.apidelv.com/libs/awesome-functions/awesome-functions.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.3/html2pdf.bundle.min.js" ></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
  <link href="css/styles.css" rel="stylesheet" type="text/css">
  <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.3/html2pdf.bundle.min.js" ></script>



  <style>
    body {
      font-family: "Helvetica Neue", "Helvetica", Helvetica, Arial, sans-serif;
      text-align: center;
      color: #777;
    }
    body h1 {
      font-weight: 300;
      margin-bottom: 0px;
      padding-bottom: 0px;
      color: #000;
    }
    body h3 {
      font-weight: 300;
      margin-top: 10px;
      margin-bottom: 20px;
      font-style: italic;
      color: #555;
    }
    body a {
      color: #06f;
    }
    .invoice-box {
      max-width: 800px;
      margin: auto;
      padding: 30px;
      border: 1px solid #eee;
      box-shadow: 0 0 10px rgba(0, 0, 0, 0.15);
      font-size: 16px;
      line-height: 24px;
      font-family: "Helvetica Neue", "Helvetica", Helvetica, Arial, sans-serif;
      color: #555;
    }

    .invoice-box table {
      width: 100%;
      line-height: inherit;
      text-align: left;
      border-collapse: collapse;
    }
    .invoice-box table td {
      padding: 5px;
      vertical-align: top;
    }
    .invoice-box table tr td:nth-child(2) {
      text-align: right;
    }
    .invoice-box table tr.top table td {
      padding-bottom: 20px;
    }
    .invoice-box table tr.top table td.title {
      font-size: 45px;
      line-height: 45px;
      color: #333;
    }
    .invoice-box table tr.information table td {
      padding-bottom: 40px;
    }
    .invoice-box table tr.heading td {
      background: #eee;
      border-bottom: 1px solid #ddd;
      font-weight: bold;
    }
    .invoice-box table tr.details td {
      padding-bottom: 20px;
    }
    .invoice-box table tr.item td {
      border-bottom: 1px solid #eee;
    }
    .invoice-box table tr.item.last td {
      border-bottom: none;
    }
    .invoice-box table tr.total td:nth-child(2) {
      border-top: 2px solid #eee;
      font-weight: bold;
    }
    @media only screen and (max-width: 600px) {
      .invoice-box table tr.top table td {
        width: 100%;
        display: block;
        text-align: center;
      }
      .invoice-box table tr.information table td {
        width: 100%;
        display: block;
        text-align: center;
      }
    }
  </style>

  <script type="text/javascript">
    $(document).ready(function($)
    {
      // Funkcja pozwalająca pobrać fakturę do pliku PDF
      $(document).on("click", ".btn_print", function(event)
      {
        event.preventDefault();
        var element = document.getElementById("dvContainer");
        var opt =
                {
                  margin:       1,
                  filename:     "FV${nr_z}.pdf",
                  image:        { type: "jpeg", quality: 0.98 },
                  html2canvas:  { scale: 2 },
                  jsPDF:        { unit: "mm", format: "a4", orientation: "portrait" }
                };
        html2pdf().set(opt).from(element).save();
      });
    });
  </script>

</head>
<body>
<%@include file="fragment/navbar.jspf" %>
<BR><BR><BR><BR>
<div id="dvContainer">
  <div id="content">
    <div class="invoice-box">
      <table>
        <tr class="top">
          <td colspan="2">
            <table>
              <tr>
                <td>
                  Faktura dla zamówienia: ${nr_z} <br/>
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr class="informacje">
          <td colspan="2">
            <table>
              <tr>
                <td>
                  Bookzwami Sp. z.o.o.<br />
                  ul. Powstańców 5<br />
                  60-123 Sosnowiec
                </td>
                <td>
                  ${usr.imie} ${usr.nazwisko}<br/>
                  ${usr.adres} ${usr.miasto}<br />
                  ${usr.telefon}<br />
                  ${usr.email}
                </td>
              </tr>
            </table>
          </td>
        </tr>
        <tr class="heading">
          <td>Płatność</td>
          <td></td>
          <td></td>
          <td></td>
        </tr>
        <tr class="details">
          <td>Rodzaj płatności: Płatność gotówką</td>
        </tr>
        <tr class="heading">
          <td>Książka</td>
          <td>Ilość</td>
          <td>Cena za szt.</td>
          <td>Cena całk.</td>
        </tr>
        <c:set var="total" value="${0}"/>
        <c:if test="${!empty requestScope.carts}">
          <c:forEach items="${requestScope.carts}" var="product">
            <tr><td>${product.title}</td>
              <td>${product.amount}</td>
              <td><fmt:formatNumber type="CURRENCY" maxFractionDigits="2" value="${product.cost}"/></td>
              <td><fmt:formatNumber type="CURRENCY" maxFractionDigits="2" value="${product.cost*product.amount}"/></td>
            </tr>
            <c:set var="total" value="${total+(product.cost*product.amount)}"/>
          </c:forEach>
        </c:if>
        <tr>
          <td></td><td></td><td></td><td><fmt:formatNumber type="CURRENCY" maxFractionDigits="2" value="${total}"/></td>
        </tr>
        <tr></tr>
        <tr class="total">
          <td></td>
          <td>Rabat: <fmt:formatNumber type="CURRENCY" maxFractionDigits="2" value="${(rabat/100)*total}"/><br>Łącznie: <fmt:formatNumber type="CURRENCY" maxFractionDigits="2" value="${total-((rabat/100)*total)}"/></td>
          <td></td>
          <td></td>

        </tr>
      </table>
    </div>
  </div>
</div>

<div class="text-center" style="padding:20px;">
  <input type="button" id="rep" value="Pobierz" class="btn btn-info btn_print">
</div>

<%@include file="fragment/footer.jspf" %>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
<script src="js/jquery.js"></script>
<script src="js/main.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>

</body>
</html>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <title>Shipping</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.3/html2pdf.bundle.min.js" ></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/jsbarcode@3.11.5/dist/JsBarcode.all.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.9.3/html2pdf.bundle.min.js" ></script>
</head>

<body>
<%@include file="fragment/navbar.jspf"%>
<div class="d-flex justify-content-center" id="dvContainer" style="margin-top:100px;">
        <div class="col-4 border border-dark">
            <h4>Informacje o zamówieniu</h4>
            <p class="lead">Numer zamówienia: ${nr_z}</p>
            <h4>Nadawca</h4>
            Bookzwami Sp. z.o.o.<br />
            ul. Powstańców 5<br />
            60-123 Sosnowiec
            <h4>Odbiorca</h4>
            ${usr.imie} ${usr.nazwisko}<br/>
            ${usr.adres} ${usr.miasto}<br />
            ${usr.telefon}<br />
            ${usr.email}
            <center>
                <svg id="barcode"></svg>
            </center>
            <script>
                JsBarcode("#barcode", "${nr_z}");
            </script>
        </div>
</div>
<div class="text-center" style="padding:20px;">
    <input type="button" id="rep" value="Pobierz" class="btn btn-info btn_print">
</div>
<br>
<%@include file="fragment/footer.jspf"%>
<script type="text/javascript">
    $(document).ready(function($)
    {
        // Funkcja pozwalająca pobrać etykiete transportową do pliku PDF
        $(document).on("click", ".btn_print", function(event)
        {
            event.preventDefault();
            var element = document.getElementById("dvContainer");
            var opt =
                {
                    margin:       1,
                    filename:     "SH${nr_z}.pdf",
                    image:        { type: "jpeg", quality: 0.98 },
                    html2canvas:  { scale: 2 },
                    jsPDF:        { unit: "mm", format: "a4", orientation: "portrait" }
                };
            html2pdf().set(opt).from(element).save();
        });
    });
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3"
        crossorigin="anonymous"></script>
</body>
</html>
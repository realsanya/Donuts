<#ftl encoding="UTF-8"/>
<#macro main title css=[] scripts=[]>
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>${(title??)?then(title, "title")}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
        <!-- Bootstrap core CSS -->
        <link rel="stylesheet" href="../../../../frontend/css/bootstrap.min.css">
        <!-- Material Design Bootstrap -->
        <link rel="stylesheet" href="../../../../frontend/css/mdb-pro.min.css">
        <!-- Material Design Bootstrap Ecommerce -->
        <link rel="stylesheet" href="../../../../frontend/css/mdb.ecommerce.min.css">
        <!-- Your custom styles (optional) -->
        <link href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css"
              rel="stylesheet"/>
        <link rel="stylesheet" href="../../../../frontend/css/mdb-pro.min.css">
        <link rel="stylesheet" href="../../../../frontend/css/bootstrap.min.css">
        <#list css as style>
            <link rel="stylesheet" href="../../../../frontend/css/${style}">
        </#list>
    </head>
    <body>
    <#include "header.ftl">
    <#nested>
    <script src="../../../../frontend/js/jquery-3.4.1.min.js"></script>
    <script src="../../../../frontend/js/bootstrap.js"></script>
    <script src="../../../../frontend/js/jquery.nice-select.min.js"></script>
    <script src="../../../../frontend/js/jquery.nicescroll.min.js"></script>
    <script src="../../../../frontend/js/jquery.magnific-popup.min.js"></script>
    <script src="../../../../frontend/js/jquery.countdown.min.js"></script>
    <script src="../../../../frontend/js/jquery.slicknav.js"></script>
    <script src="../../../../frontend/js/mixitup.min.js"></script>
    <script src="../../../../frontend/js/owl.carousel.min.js"></script>
    <script src="../../../../frontend/js/main.js"></script>
    <script src="https://api-maps.yandex.ru/2.1/?apikey=9d9f7410-0f6f-4ea1-a0fa-60e7557ff7f7&lang=ru_RU"
            type="text/javascript">
    </script>
    <#list scripts as script>
        <script src="../../../views/js/${script}"
    </#list>
    </body>
    </html>
</#macro>
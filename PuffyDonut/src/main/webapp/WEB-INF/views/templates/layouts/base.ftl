<#ftl encoding="UTF-8"/>
<#macro main title css=[] scripts=[]>
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <meta charset="UTF-8">
        <title>${(title??)?then(title, "title")}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
    <#list scripts as script>
        <script src="../../../views/js/${script}"
    </#list>
    </body>
    </html>
</#macro>
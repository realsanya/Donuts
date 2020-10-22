<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main css=["styles.css"] scripts=["delivery.js"] title="Доставка">
<#--    TODO не подключается скрипт с api-->
    <body class="masthead">
    <div class="container">
        <div class="row mt-5 mb-5">
            <div class="col"><h1 class="text-white font-weight-bold">Доставка</h1></div>
        </div>
        <div class="col">
            <div class="col">
            </div>
            <div class="col">
                <div id="map" class="card centered shadow-lg px-2 pt-2 pb-2" style="width: 50vw; height: 30vw"></div>
            </div>
            <div class="col">
            </div>
        </div>
    </div>
    </body>
</@base.main>
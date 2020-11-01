<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main css=["styles.css"] scripts=["searchAjax.js"] title="Отзывы">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8 text-center mb-5" id="reviews">
                <h1 class="text-uppercase text-white font-weight-bold">Отзывы</h1>

            </div>
        </div>

        <div class="container">
            <div class="row  mb-5 mt-5" id="results">
            </div>
        </div>

        <form class="btnid" method="get" id="btnid">
            <div class="row justify-content-center mt-5">
                <button class="btn btn-primary btn-lg js-scroll-trigger px-4" type="submit">
                    Смотреть ещё
                </button>
            </div>
        </form>
    </div>
</@base.main>
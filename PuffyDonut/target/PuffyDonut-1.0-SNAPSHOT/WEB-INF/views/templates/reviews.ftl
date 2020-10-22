<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main css=["styles.css"] scripts=["searchReview.js"] title="Отзывы">
    <body class="masthead">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8 text-center mb-5" id="reviews">
                <h1 class="text-uppercase text-white font-weight-bold">Отзывы</h1>

            </div>
        </div>
        <#if reviews??>
            <div class="container">
                <div class="row mb-5 mt-5" id="results">
                    <#list 0..2 as x>
                        <div class="card testimonial-card col-4  mb-5">
                            <div class="avatar mx-auto white">
                                <img src="../../../assets/user/${reviews[x].getUser_id().getImage()}" class="rounded-circle img-responsive"
                                     alt="woman avatar">
                            </div>
                            <div class="card-body">
                                <div class="row mb-2">
                                    <div class="col">
                                        <h5 class="text-left font-weight-bold">${reviews[x].getUser_id().getFirstname()}</h5>
                                    </div>
                                    <div class="col">
                                        <h5 class="text-right font-weight-light">
                                            ${reviews[x].getDate()}
                                        </h5>
                                    </div>
                                </div>
                                <p class="font-small"> ${reviews[x].getText()} </p>
                            </div>
                        </div>
                    </#list>
                </div>
            </div>
        </#if>

        <div class="row justify-content-center mt-5">
            <button class="btn btn-primary btn-lg js-scroll-trigger px-4" onclick="searchReview()">Смотреть ещё</button>
        </div>
    </div>
    </body>
</@base.main>
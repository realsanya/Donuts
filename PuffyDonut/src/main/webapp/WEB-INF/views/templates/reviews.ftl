<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main css=["styles.css"] title="Отзывы">
    <body class="masthead">
    <div class="container">
        <div class="row justify-content-center">
            <div class="col-lg-8 text-center mb-5" id="reviews">
                <h1 class="text-uppercase text-white font-weight-bold">Отзывы</h1>

            </div>
        </div>

        <div class="row mb-5 mt-5 ">
            <#if reviews??>
            <#list reviews as review>

            <div class="card testimonial-card col-4  mb-5">

                <!-- Avatar -->
                <div class="avatar mx-auto white">
                    <img src="https://mdbootstrap.com/img/Photos/Avatars/img%20%2831%29.jpg"
                         class="rounded-circle img-responsive" alt="woman avatar">
                </div>

                <!-- Content -->
                <div class="card-body ">
                    <!-- Name -->
                    <div class="row mb-2">
                        <div class="col">
                            <h5 class="text-left font-weight-bold">Martha Smith</h5>
                        </div>
                        <div class="col">
                            <h5 class="text-right font-weight-light">${review.getDate()}</h5>
                        </div>
                    </div>

                    <!-- Quotation -->
                    <p class="font-small">${review.getText()}</p>

                </div>
            </div>
        </div>
        </#list>
        </#if>
    </div>
    </body>
</@base.main>
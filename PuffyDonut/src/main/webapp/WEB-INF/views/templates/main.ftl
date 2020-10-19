<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main css=["styles.css", "main.css"] title="Главная">
    <body class="masthead">
    <div class="container h-75">
        <div class="row h-100 align-items-left justify-content-left text-left">
            <div class="col-lg-10 align-self-end">
                <h1 class="text-uppercase text-white font-weight-bold">Пончики<br>как в Америке</h1>
            </div>
            <div class="col-lg-8 align-self-baseline">
                <p class="text-white-75 font-weight-light mb-5">Превосходный десерт по сладкой цене<br>с бесплатной
                    доставкой</p>
                <a class="btn btn-primary btn-lg js-scroll-trigger px-4" href="/catalog">Смотреть каталог</a>

                <p class="mt-5 text-white-75 font-weight-light ">Сделайте заказ прямо сейчас и получите скидку
                    10%</p>
            </div>
        </div>
    </div>

    <!-- About-->
    <section class="page-section bg-primary" style="background-color: white!important;" id="about">
        <div class="container">
            <div class="row ">
                <div class="col"></div>

                <div class="col ml-5 text-left">
                    <h1 class="text-black-80 mt-0">Почему именно мы?</h1>
                    <p class="text-black mb-4 mt-5">Современный и удобный интернет-магазин.
                        Где в одном месте собран весь наш ассортимент. Удобная навигация, фильтры по необходимым
                        параметрам,
                        подробное описание товаров и разнообразие форм оплаты сделают покупку приятной, быстрой и
                        легкой.</p>
                    <a class="" style="color: black" href="/about">Подробнее о нас</a>
                </div>
            </div>
        </div>
    </section>

    <!-- Services-->
    <section class="page-section" id="services">
        <div class="container">
            <h2 class="text-center mt-0 mb-5">Наш ассортимент</h2>
            <div class="row">
                <!--donuts-->
                <#if products??>
                    <#list 0..2 as x>
                        <div class="col-xs-6 col-sm-4 col-md-4 ">
                            <div class=" card border-white">
                                <div class="card-body text-center ">
                                    <p><img class=" img-fluid"
                                            src="../../../frontend/static/icon/${products[x].getImage()}"
                                            alt="card image"></p>

                                    <div class="row">
                                        <div class="col">
                                            <h5 class="text-left">${products[x].getName()}</h5>
                                        </div>
                                        <div class="col">
                                            <h5 class="text-right">${products[x].getPrice()}₽</h5>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col">
                                            <h6 class="text-left">${products[x].getWeight()}г</h6>
                                        </div>
                                    </div>
                                    <div class="row">
                                        <div class="col text-justify">
                                            <small>
                                                ${products[x].getDescription()}
                                            </small>
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row row-eq-height">
                                        <div class="col text-left my-auto">
                                            <button type="button" class="btn  btn-circle"><i class="fa fa-minus"></i>
                                            </button>
                                            <span style="margin-left: 5px; margin-right: 5px"> ${products[x].getQuantity()} </span>
                                            <button type="button" class="btn  btn-circle"><i class="fa fa-plus"></i>
                                            </button>
                                        </div>
                                        <div class="col text-right">
                                            <button type="button" class="btn btn-primary btn-lg px-4">В корзину</button>

                                        </div>
                                    </div>
                                    <br>
                                </div>
                            </div>
                        </div>
                    </#list>
                </#if>
                <!-- end donuts-->
            </div>
            <div class="row justify-content-center mt-5">
                <a class="btn btn-primary btn-lg js-scroll-trigger px-4" href="/catalog">Смотреть каталог</a>
            </div>
        </div>
    </section>

    <!-- Portfolio-->
    <!-- Call to action-->
    <section class="page-section container">
        <h2 class="text-center mt-0 mb-5">Почему выбирают нас?</h2>
        <div class="row">
            <div class="col-auto">
                <div class="row h-100 ">
                    <div class="col-auto my-auto">
                        <img src="../../../assets/img/hr/left.png" class="img-fluid">
                    </div>
                    <div class="col-auto my-auto ">
                        <h6 class="gradient-text mx-0">
                            Натуральные ингридиенты
                        </h6>
                        <h6 class="text-black-80">
                            В процессе приготовления<br>
                            используем натуральные<br>
                            и свежие продукты
                        </h6>
                    </div>
                </div>
            </div>
            <div class="col-auto">
                <div class="row h-100 ">
                    <div class="col-auto my-auto">
                        <img src="../../../assets/img/hr/center.png" class="img-fluid">
                    </div>
                    <div class="col-auto my-auto ">
                        <h6 class="gradient-text mx-0">
                            Огромный ассортимент
                        </h6>
                        <h6 class="text-black-80">
                            Большой выбор пончиков<br>
                            с разными начинками<br>
                            на любой вкус
                        </h6>
                    </div>
                </div>
            </div>
            <div class="col-auto">
                <div class="row h-100 ">
                    <div class="col-auto my-auto">
                        <img src="../../../assets/img/hr/right.png" class="img-fluid">
                    </div>
                    <div class="col-auto my-auto ">
                        <h6 class="gradient-text mx-0">
                            Бесплатная доставка
                        </h6>
                        <h6 class="text-black-80">
                            Курьер доставит пончики,<br>
                            куда вы пожелаете<br>
                            бесплатно
                        </h6>
                    </div>
                </div>
            </div>
        </div>
    </section>


    <!-- Contact-->
    <section class="page-section" id="contact">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-lg-8 text-center" id="reviews">
                    <h2 class="mt-0 mb-5">Отзывы наших клиентов</h2>

                </div>
            </div>

            <div class="row mb-5 mt-5 ">
                <!--reviews-->
                <#if reviews??>
                    <#list 0..2 as y>
                        <div class="card testimonial-card col mx-2">
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
                                        <h5 class="text-left font-weight-bold">${reviews[y].user.getFirstName()}</h5>
                                    </div>
                                    <div class="col">
                                        <h5 class="text-right font-weight-light">${reviews[y].getDate()}</h5>
                                    </div>
                                </div>
                                <!-- Quotation -->
                                <p class="font-small">${reviews[y].getText()}</p>
                            </div>
                        </div>
                    </#list>
                </#if>
                <!--end reviews-->
            </div>
            <div class="row justify-content-center mt-5">
                <a class="btn btn-primary btn-lg js-scroll-trigger px-4" href="/catalog">Смотреть ещё</a>
            </div>
        </div>
    </section>
    </body>
</@base.main>
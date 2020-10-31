<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main css=["styles.css", "advantages.css"] title="Преимущества">
    <!--content-->
    <main>
        <div class="container">
            <!--Section: Block Content-->
            <section class="mt-5 mb-4">
                <!--Grid row-->
                <div class="row">
                    <!--Grid column-->
                    <div class="col-lg-8">

                        <div class="card wish-list mb-4">
                            <div class="card-body">

                                <h5 class="mb-4">Корзина ( <span>1</span> )</h5>

                                <!-- products -->
                                <#if order??>
                                    <#list order.getProducts_id() as product>
                                        <div class="row mb-4">
                                            <div class="col-md-5 col-lg-3 col-xl-3">
                                                <div class="view zoom overlay z-depth-1 rounded mb-3 mb-md-0">
                                                    <img class="img-fluid w-100"
                                                         src="../../../frontend/static/donut.png"
                                                         alt="Sample">
                                                    <a href="#!">
                                                        <div class="mask waves-effect waves-light">
                                                            <img class="img-fluid w-100"
                                                                 src="../../../frontend/static/donut.png">
                                                            <div class="mask rgba-black-slight waves-effect waves-light"></div>
                                                        </div>
                                                    </a>
                                                </div>
                                            </div>
                                            <div class="col-md-7 col-lg-9 col-xl-9">
                                                <div>
                                                    <div class="d-flex justify-content-between">
                                                        <div>
                                                            <h5>${product.getName()}</h5>
                                                            <p class="mb-2 text-muted text-uppercase small">Вес:
                                                                ${product.getWeight()}г</p>
                                                        </div>
                                                        <div>


                                                        </div>
                                                    </div>
                                                    <div class="d-flex justify-content-between align-items-center">
                                                        <div>
                                                            <a href="/orderService?delete=${product.getId()}"
                                                               type="button"
                                                               class="card-link-secondary small text-uppercase mr-3"><i
                                                                        class="fas fa-trash-alt mr-1"></i>
                                                                Удалить с корзины
                                                            </a>
                                                        </div>
                                                        <p class="mb-0">
                                                            <span><strong>${product.getPrice()}₽</strong></span></p>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </#list>
                                </#if>
                                <hr class="mb-4">
                            </div>
                        </div>
                    </div>


                    <div class="col-lg-4">
                        <div class="card mb-4">
                            <div class="card-body">

                                <h5 class="mb-3">Расчетный чек</h5>

                                <ul class="list-group list-group-flush">
                                    <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 pb-0">
                                        Сумма товаров
                                        <span>53.98₽</span>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center px-0">
                                        Доставка
                                        <span>Бесплатно</span>
                                    </li>
                                    <li class="list-group-item d-flex justify-content-between align-items-center border-0 px-0 mb-3">
                                        <div>
                                            <strong>Итоговая сумма</strong>

                                        </div>
                                        <span><strong>53.98₽</strong></span>
                                    </li>
                                </ul>


                                <button class="btn btn-primary btn-lg  btn-block waves-effect waves-light"
                                        type="submit">
                                    Оплатить
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </main>
</@base.main>
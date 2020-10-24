<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main css=["styles.css", "catalog.css"] scripts=["catalog.js"] title="Каталог">
    <!-- Shop Section Begin -->
    <section class="shop mt-5">
        <div class="container card px-5 pt-5 pb-5 pb-lg-5">
            <div class="row ">
                <div class="col-lg-3">
                    <div class="shop__sidebar">
                        <div class="shop__sidebar__search">
                            <form action="/searchByName" method="post" id="searh-form" class="search-form">
                                <div class="autocomplete">
                                    <input style="border-radius: 15px;" id="search-input" name="search-input"
                                           placeholder="Search..." autocomplete="off">
                                </div>
                                <button type="submit" class="search-btn" style="color: #aa4aac"><i
                                            class="fas fa-search"></i></button>
                            </form>
                        </div>
                        <div class="shop__sidebar__accordion">
                            <div class="accordion" id="accordionExample">
                                <div class="">
                                    <div class="card-heading">
                                        <h4>Tags</h4>
                                    </div>
                                    <form action="/searchByTag" method="post">
                                        <div id="collapseSix" class="collapse show" data-parent="#accordionExample">
                                            <div class="card-body">
                                                <select name="select-tag" class="shop__product__option__right">
                                                    <option value="chocolateTag">
                                                        Шоколад
                                                    </option>
                                                    <option value="nutsTag">
                                                        Орехи
                                                    </option>
                                                    <option value="berriesTag">
                                                        Ягоды
                                                    </option>
                                                    <option value="cocosTag">
                                                        Кокос
                                                    </option>
                                                    <option value="vanillaTag">
                                                        Ваниль
                                                    </option>
                                                </select>
                                                <button type="submit" class="tag-donut">Выбрать</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <#if products??>
                <div class="col-lg-9 ">
                    <div class="shop__product__option">
                        <div class="row">
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="shop__product__option__left">
                                    <p></p>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="shop__product__option__right">
                                    <p>Сортировать по:</p>
                                    <form action="/search" method="post">
                                        <button type="submit" class="tag-donut">Выбрать</button>
                                        <select name="select-form">
                                            <option value="priceIncrease">цене с дешевых</option>
                                            <option value="priceDecrease">цене с дорогих</option>
                                            <option value="weightIncrease">весу с легких</option>
                                            <option value="weightDecrease">весу с тяжелых</option>
                                        </select>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row" style="padding-top: 10px">
                        <!--donuts-->
                        <#list products as product>
                            <div class="col-xs-6 col-sm-4 col-md-4 ">
                                <div class="card border-white">
                                    <div class="card-body text-center ">
                                        <#-- TODO: исправить путь к assets-->
                                        <p><img class=" img-fluid"
                                                src="../../../assets/img/donuts/${product.getImage()}"
                                                alt="card image"></p>

                                        <div class="row">
                                            <div class="col-lg-7">
                                                <a href="detail/product?id=${product.getId()}"><h5
                                                            class="text-left "> ${product.getName()}</h5></a>
                                            </div>
                                            <div class="col">
                                                <h5 class="text-right">  ${product.getPrice()}₽</h5>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col">
                                                <h6 class="text-left"> ${product.getWeight()}г</h6>
                                            </div>
                                        </div>
                                        <div class="row">
                                            <div class="col text-justify">
                                                <small>
                                                    ${product.getDescription()}
                                                </small>
                                            </div>
                                        </div>
                                        <br>
                                        <div class="row row-eq-height">
                                            <div class="col text-left my-auto">
                                                <button type="button" class="btn-sm  btn-circle"><i
                                                            class="fa fa-minus"></i>
                                                </button>
                                                <span>${product.getQuantity()}</span>
                                                <button type="button" class="btn-sm  btn-circle"><i
                                                            class="fa fa-plus"></i>
                                                </button>
                                            </div>
                                            <form method="get">
                                                <div class="col-lg-6 text-right ">
                                                    <button type="button" class="btn-lg btn-primary text-nowrap"
                                                            onclick="window.location='/orderService?add=${product.getId()}'"
                                                    >
                                                        В корзину
                                                    </button>
                                                </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </#list>
                        </#if>
                    </div>
                    <!--end donuts-->


                    <!--PAGES-->
                </div>
            </div>
        </div>
        </div>
    </section>
    <!-- Shop Section End -->
</@base.main>
<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main css=["styles.css", "advantages.css"] title="Каталог">
    <!-- Shop Section Begin -->
    <body class="masthead">
    <section class="shop mt-5">
        <div class="container card px-5 pt-5 pb-5 pb-lg-5">
            <div class="row ">
                <div class="col-lg-3">
                    <div class="shop__sidebar">
                        <div class="shop__sidebar__search">
                            <form action="#">
                                <input style="border-radius: 15px;" type="text" placeholder="Search...">
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
                                    <div id="collapseSix" class="collapse show" data-parent="#accordionExample">
                                        <div class="card-body">
                                            <div class="shop__sidebar__tags">
                                                <a class="tag-donut" href="#">Product</a>
                                                <a class="tag-donut" href="#">Bags</a>
                                                <a class="tag-donut" href="#">Shoes</a>
                                                <a class="tag-donut" href="#">Fashio</a>
                                                <a class="tag-donut" href="#">Clothing</a>
                                                <a class="tag-donut" href="#">Hats</a>
                                                <a class="tag-donut" href="#">Accessories</a>
                                            </div>
                                        </div>
                                    </div>
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
                                    <p>Showing 1–6 of ?? results</p>
                                </div>
                            </div>
                            <div class="col-lg-6 col-md-6 col-sm-6">
                                <div class="shop__product__option__right">
                                    <p>Сортировать по:</p>
                                    <select>
                                        <option value="">цене с дешевых</option>
                                        <option value="">цене с дорогих</option>
                                        <option value="">весу с легких</option>
                                        <option value="">весу с тяжелых</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <!--donuts-->
                        <#list products as product>
                            <div class="col-4 bg-white donut mt-2">
                                <div class="card border-white">
                                    <div class="card-body text-center ">
                                        <#-- TODO: исправить путь к assets-->
                                        <p><img class=" img-fluid"
                                                src="../../assets/img/donuts/${product.getImage()}"
                                                alt="card image"></p>

                                        <div class="row">
                                            <div class="col-lg-7">
                                                <h5 class="text-left "> ${product.getName()}</h5>
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
                                            <div class="col-lg-6 text-right ">
                                                <button type="button" class="btn-lg btn-primary text-nowrap">
                                                    В корзину
                                                </button>
                                            </div>
                                        </div>
                                        <br>
                                    </div>
                                </div>
                            </div>
                        </#list>
                        </#if>
                    </div>
                    <!--end donuts-->


                    <!--PAGES-->
                </div>
                <div class="row">
                    <div class="col-lg-12">
                        <div class="product__pagination">
                            <a class="active" href="#">1</a>
                            <a href="#">2</a>
                            <a href="#">3</a>
                            <span>...</span>
                            <a href="#">21</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </div>
    </section>
    </body>
    <!-- Shop Section End -->
</@base.main>
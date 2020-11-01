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
                            <form action="/searchByName" method="post" id="searh-form" class="search-form" autocomplete="off">
                                <div class="autocomplete">
                                    <input style="border-radius: 15px;" id="search-input" name="search-input"
                                           placeholder="Search...">
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
                                                <a href="detail?id=${product.getId()}"><h5
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
                                        <form method="get">
                                            <div class="row row-eq-height">
                                                <div class="col text-center ">
                                                    <button type="button" class="btn btn-primary btn-lg px-4"
                                                            onclick="addProduct(${product.getId()})"
                                                    >
                                                        В корзину
                                                    </button>
                                                </div>
                                            </div>
                                        </form>
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
    </section>
    <!-- Shop Section End -->
    <script>
        var countries = ["Afghanistan","Albania","Algeria","Andorra","Angola","Anguilla","Antigua &amp; Barbuda","Argentina","Armenia","Aruba","Australia","Austria","Azerbaijan","Bahamas","Bahrain","Bangladesh","Barbados","Belarus","Belgium","Belize","Benin","Bermuda","Bhutan","Bolivia","Bosnia &amp; Herzegovina","Botswana","Brazil","British Virgin Islands","Brunei","Bulgaria","Burkina Faso","Burundi","Cambodia","Cameroon","Canada","Cape Verde","Cayman Islands","Central Arfrican Republic","Chad","Chile","China","Colombia","Congo","Cook Islands","Costa Rica","Cote D Ivoire","Croatia","Cuba","Curacao","Cyprus","Czech Republic","Denmark","Djibouti","Dominica","Dominican Republic","Ecuador","Egypt","El Salvador","Equatorial Guinea","Eritrea","Estonia","Ethiopia","Falkland Islands","Faroe Islands","Fiji","Finland","France","French Polynesia","French West Indies","Gabon","Gambia","Georgia","Germany","Ghana","Gibraltar","Greece","Greenland","Grenada","Guam","Guatemala","Guernsey","Guinea","Guinea Bissau","Guyana","Haiti","Honduras","Hong Kong","Hungary","Iceland","India","Indonesia","Iran","Iraq","Ireland","Isle of Man","Israel","Italy","Jamaica","Japan","Jersey","Jordan","Kazakhstan","Kenya","Kiribati","Kosovo","Kuwait","Kyrgyzstan","Laos","Latvia","Lebanon","Lesotho","Liberia","Libya","Liechtenstein","Lithuania","Luxembourg","Macau","Macedonia","Madagascar","Malawi","Malaysia","Maldives","Mali","Malta","Marshall Islands","Mauritania","Mauritius","Mexico","Micronesia","Moldova","Monaco","Mongolia","Montenegro","Montserrat","Morocco","Mozambique","Myanmar","Namibia","Nauro","Nepal","Netherlands","Netherlands Antilles","New Caledonia","New Zealand","Nicaragua","Niger","Nigeria","North Korea","Norway","Oman","Pakistan","Palau","Palestine","Panama","Papua New Guinea","Paraguay","Peru","Philippines","Poland","Portugal","Puerto Rico","Qatar","Reunion","Romania","Russia","Rwanda","Saint Pierre &amp; Miquelon","Samoa","San Marino","Sao Tome and Principe","Saudi Arabia","Senegal","Serbia","Seychelles","Sierra Leone","Singapore","Slovakia","Slovenia","Solomon Islands","Somalia","South Africa","South Korea","South Sudan","Spain","Sri Lanka","St Kitts &amp; Nevis","St Lucia","St Vincent","Sudan","Suriname","Swaziland","Sweden","Switzerland","Syria","Taiwan","Tajikistan","Tanzania","Thailand","Timor L'Este","Togo","Tonga","Trinidad &amp; Tobago","Tunisia","Turkey","Turkmenistan","Turks &amp; Caicos","Tuvalu","Uganda","Ukraine","United Arab Emirates","United Kingdom","United States of America","Uruguay","Uzbekistan","Vanuatu","Vatican City","Venezuela","Vietnam","Virgin Islands (US)","Yemen","Zambia","Zimbabwe"];
        autocomplete(document.getElementById("myInput"), countries);
    </script>
    <script>
        function addProduct(id) {
            <#if user??>
            alert('Пончик добавлен в корзину!');
            <#else>
            alert('Необходимо авторизироваться!')
            </#if>
            window.location.href = '/orderService?add=' + id;
        }
    </script>
</@base.main>
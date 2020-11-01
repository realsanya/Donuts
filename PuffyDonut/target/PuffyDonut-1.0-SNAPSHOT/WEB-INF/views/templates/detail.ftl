<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main css=["styles.css", "detail.css"] title="Подробнее">
    <#if product??>
        <!-- Modal -->
        <div class="modal fade bd-example-modal-lg" id="exampleModal" tabindex="-1" role="dialog"
             aria-labelledby="exampleModalLabel"
             aria-hidden="true">
            <div class="modal-dialog modal-lg" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Новый отзыв</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">&times</span>
                        </button>
                    </div>


                    <form method="post" id="form_push" action="/detail">
                        <input hidden name="product_id" value="${product.getId()}">
                        <div class="modal-body">
                            <div class="form-group">
                                <input type="text" class="form-control" name="comment-input" id="comment-input"
                                       required>
                            </div>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-outline-secondary" data-dismiss="modal">Закрыть
                            </button>
                            <button type="submit" id="push_btn" class="btn btn-primary btn-lg px-3">
                                Сохранить
                            </button>
                        </div>
                    </form>

                </div>
            </div>
        </div>


        <div class="container mt-5  card px-5 pt-5 pb-5">
        <div class="row">
        <div class="col-lg-4 col-xl-4 ">
            <div class="card-box text-center ">
                <img src="../../../assets/img/donuts/${product.getImage()}" class="rounded-circle   img-fluid "
                     alt="profile-image">

                <h4 class="mb-0">${product.getName()}</h4>

                <button type="button" class="btn btn-primary btn-lg ">В корзину</button>

                <div class="text-left mt-3">
                    <h4 class="font-13 text-uppercase">Описание:</h4>
                    <p class="text-muted font-13 mb-3">
                        ${product.getDescription()}
                    </p>
                    <p class="text-muted mb-1 font-13"><strong>Цена :</strong> <span
                                class="ml-2">${product.getPrice()}₽</span>
                    </p>

                    <p class="text-muted mb-2 font-13"><strong>Вес :</strong> <span
                                class="ml-2">${product.getWeight()}г</span></p>
                </div>
            </div>
        </div>
    </#if>

    <div class="col-lg-8 col-xl-8 ">
        <div class="card-box">
            <button id="write_comment" class="nav-link ml-0 active btn btn-link" data-toggle="modal"
                    data-target="#exampleModal">
                <i class="mdi mdi-face-profile mr-1"></i>Оставить коментарий
            </button>

            <div class="tab-content">

                <div class="tab-pane show active" id="about-me">

                    <h5 class="mb-4 text-uppercase"><i class="mdi mdi-briefcase mr-1"></i>
                        Комментарии</h5>

                    <ul class="list-unstyled timeline-sm">

                        <!--comments-->
                        <#if comments??>
                            <#list comments as comment>
                                <li class="timeline-sm-item">
                                    <div class="row">
                                        <div class="col-2">

                                            <img src="../../../assets/data/${comment.getUser_id().getImage().getPath()}"
                                                 class="rounded-circle img-responsive">
                                        </div>
                                        <div class="col mt-auto mb-auto">
                                            <span class="timeline-sm-date">${comment.getDate()}</span>
                                            <h5 class="mt-0 mb-1">${comment.getUser_id().getFirst_name()}</h5>
                                        </div>


                                    </div>
                                    <p class="text-muted mt-2">${comment.getText()}</p>

                                </li>
                            </#list>
                        </#if>
                        <!--end comments-->
                    </ul>
                </div>
            </div>
        </div>
    </div>
    </div>
    </div>
</@base.main>
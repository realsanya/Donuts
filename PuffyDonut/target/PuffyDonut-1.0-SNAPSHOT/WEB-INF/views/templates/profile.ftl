<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main css=["styles.css", "profile.css"] title="Профиль" >
    <div class="container mt-5  card px-5 pt-5 pb-5">
        <div class="row">
            <div class="col-lg-4 col-xl-4 ">
                <div class="card-box text-center " id="imagePreview">


                    <div class="selector rounded-circle">
                        <img src="../../../assets/data/${user.getImage().getPath()}"
                             id="profile-image"
                             class="img-fluid"
                             style="border-radius: 50%;object-fit:cover; width: 300px; height: 300px"
                             alt="profile-image">
                    </div>


                    <div style="alignment: center; horiz-align: center; margin-left: auto;"
                         class="text-center color-dark position-absolute right text-changer">
                        <form action="upload/db" method="post" enctype="multipart/form-data" id="upload-form">
                            <input type='file' name="file" class="invisible" id="imageUpload"
                                   accept=".png, .jpg, .jpeg"/>
                        </form>
                        <label for="imageUpload">
                            <p class="btn btn-primary btn-lg ">Изменить</p>
                        </label>
                    </div>


                    <h4 class="mb-2">${user.getFirst_name()}</h4>
                    <h5 class="gradient-text"></h5>
                    <div class="text-left mt-3">
                        <#--                        <h4 class="font-13 text-uppercase">Профиль:</h4>-->
                        <#--                        <p class="text-muted font-13 mb-3">-->
                        <#--                            Пончик с шоколадно-ореховой начинкой и глазурью из белого шоколада-->
                        <#--                        </p>-->
                        <p class="text-muted mb-1 font-13"><strong>Почта :</strong> <span
                                    class="ml-2">${user.getEmail()}</span></p>

                        <p class="text-muted mb-2 font-13"><strong>Адрес :</strong> <span
                                    class="ml-2">${user.getAddress()}</span></p>

                    </div>
                    <button type="button" id="" class="btn btn-primary btn-lg" onclick="window.location='/logout'">
                        Выход
                    </button>
                </div> <!-- end card-box -->


            </div> <!-- end col-->

            <div class="col-lg-8 col-xl-8 ">
                <div class="card-box">
                    <div class="tab-content">
                        <div class="tab-pane show active" id="about-me">
                            <h5 class="mb-4 text-uppercase"><i class="mdi mdi-briefcase mr-1"></i>
                                Мои отзывы</h5>


                            <ul class="list-unstyled timeline-sm">
                                <#if reviews??>
                                    <#list reviews as review>
                                        <li class="timeline-sm-item">
                                            <div class="row">
                                                <div class="col-2">
                                                    <img src="../../../assets/data/${review.getUser_id().getImage().getPath()}"
                                                         class="rounded-circle img-responsive">
                                                </div>
                                                <div class="col mt-auto mb-auto">
                                                    <span class="timeline-sm-date">${review.getDate()}</span>
                                                    <h5 class="mt-0 mb-1">${review.getUser_id().getFirst_name()}</h5>
                                                </div>


                                            </div>
                                            <p class="text-muted mt-2">${review.getText()}</p>

                                        </li>
                                    </#list>
                                </#if>
                            </ul>
                        </div>
                    </div> <!-- end tab-content -->
                </div> <!-- end card-box-->

            </div> <!-- end col -->
        </div>
    </div>

</@base.main>
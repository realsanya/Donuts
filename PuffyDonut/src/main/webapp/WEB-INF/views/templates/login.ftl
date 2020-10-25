<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main css=["styles.css"] title="Авторизация">
    <div class="container">
        <!--Section: Block Content-->
        <section class="mt-5 mb-4">
            <!--Grid row-->
            <div class="row">
                <!--Grid column-->
                <div class="col"></div>
                <div class="col-8 align-self-center">
                    <!-- Card -->
                    <div class="card wish-list mb-4">
                        <div class="card">
                            <div class="card-body">
                                <h3 class="mb-4 text-black-80 mt-0 font-weight-bold">АВТОРИЗАЦИЯ</h3>
                                <form action="/login" method="post" autocomplete="off">
                                    <div class="form-group">
                                        <span class="text-black-50">Почта</span>
                                        <input type="email" class="form-control" name="email">
                                    </div>
                                    <div class="form-group">
                                        <span class="text-black-50">Пароль</span>
                                        <input type="password" class="form-control" name="password"
                                               >
                                    </div>
                                    <div class="form-group">
                                        <input type="checkbox" name="remember" class="form-check-input"
                                               id="exampleCheck1">
                                        <label class="form-check-label" for="exampleCheck1">Запомнить меня?</label>
                                    </div>

                                    <div class="form-group">
                                        <a class="text-secondary">Зарегистрироваться</a>
                                    </div>

                                    <button class="btn btn-primary btn-lg btn-block waves-effect waves-light"
                                            type="submit">Войти в аккаунт
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="col"></div>
            </div>
        </section>
    </div>
</@base.main>
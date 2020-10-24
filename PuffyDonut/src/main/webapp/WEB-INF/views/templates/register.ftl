<#ftl encoding="UTF-8"/>
<#import "layouts/base.ftl" as base>
<@base.main css=["styles.css"] title="Регистрация">
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
                                <h3 class="mb-4 text-black-80 mt-0 font-weight-bold">Регистрация</h3>
                                <form action="/register" method="post" autocomplete="off">
                                    <div class="form-group">
                                        <span class="text-black-50">Почта</span>
                                        <input type="email" data-verify="email" class="form-control" name="email"
                                               required>
                                    </div>
                                    <div class="form-group">
                                        <span class="text-black-50">Имя</span>
                                        <input type="text" class="form-control" name="first_name" required>
                                    </div>
                                    <div class="form-group">
                                        <span class="text-black-50">Фамилия</span>
                                        <input type="text" class="form-control" name="last_name" required>
                                    </div>
                                    <div class="form-group">
                                        <span class="text-black-50">Адрес</span>
                                        <input type="text" class="form-control" name="address" required>
                                    </div>

                                    <div class="form-group">
                                        <span class="text-black-50">Пароль</span>
                                        <input type="password" class="form-control" name="password"
                                               pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
                                               title="Длина от 8 до 12 символов, нужен хотя бы 1 спец символ: !@#$%^&*_=+-"
                                               required>
                                    </div>
                                    <div class="form-group">
                                        <span class="text-black-50">Повторить пароль</span>
                                        <input type="password" class="form-control" name="password_again"
                                               pattern="^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*_=+-]).{8,12}$"
                                               title="Длина от 8 до 12 символов, нужен хотя бы 1 спец символ: !@#$%^&*_=+-"
                                               required>
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
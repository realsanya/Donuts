<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 03.10.2020
  Time: 22:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Регистрация</title>
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="../css/bootstrap.min.css">
    <!-- Material Design Bootstrap -->
    <link rel="stylesheet" href="../css/mdb-pro.min.css">
    <!-- Material Design Bootstrap Ecommerce -->
    <link rel="stylesheet" href="../css/mdb.ecommerce.min.css">
    <!-- Your custom styles (optional) -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/magnific-popup.js/1.1.0/magnific-popup.min.css"
          rel="stylesheet"/>
    <link rel="stylesheet" href="../css/mdb-pro.min.css">

    <link href="../css/styles.css" rel="stylesheet"/>


</head>
<body class="masthead">
<nav class="navbar navbar-expand-lg navbar-light  py-3" id="mainNav">
    <div class="container">
        <a class="navbar-brand js-scroll-trigger" href="#page-top">PUFFY DONUT.</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
                data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false"
                aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto my-2 my-lg-0">
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#about">О нас</a></li>
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#services">Преимущества</a></li>
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#portfolio">Каталог</a></li>
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#contact">Отзывы</a></li>
                <li class="nav-item mr-4"><a class="nav-link js-scroll-trigger" href="#contact">Доставка и оплата</a>
                </li>

                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#contact"><i
                        class="fa fa-shopping-cart mr-3"></i>Корзина</a></li>
                <li class="nav-item"><a class="nav-link js-scroll-trigger" href="#contact">
                    <i class="fa fa-phone"></i> 8 800 964-44-34</a>
                </li>

            </ul>

        </div>

    </div>

</nav>
<main>

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
                                <form action="${pageContext.request.contextPath}/register" method="post"
                                      autocomplete="off">
                                    <div class="form-group">
                                        <span class="text-black-50">Почта</span>
                                        <input type="email" class="form-control" name="email">
                                    </div>
                                    <div class="form-group">
                                        <span class="text-black-50">Имя</span>
                                        <input type="text" class="form-control" name="first_name">
                                    </div>
                                    <div class="form-group">
                                        <span class="text-black-50">Фамилия</span>
                                        <input type="text" class="form-control" name="last_name">
                                    </div>
                                    <div class="form-group">
                                        <span class="text-black-50">Адрес</span>
                                        <input type="text" class="form-control" name="address">
                                    </div>

                                    <div class="form-group">
                                        <span class="text-black-50">Логин</span>
                                        <input type="text" class="form-control" name="username">
                                    </div>

                                    <div class="form-group">
                                        <span class="text-black-50">Пароль</span>
                                        <input type="password" class="form-control" name="password">
                                    </div>
                                    <div class="form-group">
                                        <span class="text-black-50">Повторить пароль</span>
                                        <input type="password" class="form-control" name="password_again">
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
</main>
</body>
</html>

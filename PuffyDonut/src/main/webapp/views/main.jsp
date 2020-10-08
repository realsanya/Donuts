<%@ page import="models.Donut" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 06.10.2020
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content=""/>
    <meta name="author" content=""/>
    <title>Главная</title>
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

    <style>
        .card.testimonial-card {
            border-radius: 40px;
        }

        .page-section.own_class {
            background: url("../assets/img/hr.png");
            background-repeat: no-repeat;
            height: 40%;
        }

        .page-section.bg-primary {
            background: url("../assets/img/background2.png");
            background-repeat: no-repeat;
            height: 70%;

        }

        .btn-circle {
            width: 30px;
            height: 30px;
            padding: 6px 0px;
            border-radius: 15px;
            text-align: center;
            font-size: 12px;
            line-height: 1.42857;
            border: #aa4aac solid 1px !important;
            color: #aa4aac;
            background: transparent;
        }

        .btn-primary.btn-lg {
            font-size: 10px;
            color: white;
            letter-spacing: 2px;
            border: 2px transparent;
            border-radius: 40px;
            background: transparent linear-gradient(to right, #973b99, #d56ed6);
            transition: all 0.3s ease 0s;
        }

        .card.border-white {
            border-radius: 15px;
            box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.10), 0 6px 20px 0 rgba(0, 0, 0, 0.10);
        }

    </style>
</head>
<body>
<!-- Navigation-->
<!-- Masthead-->
<header class="masthead">
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
                    <li class="nav-item mr-4"><a class="nav-link js-scroll-trigger" href="#contact">Доставка и
                        оплата</a>
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

    <div class="container h-75">
        <div class="row h-100 align-items-left justify-content-left text-left">
            <div class="col-lg-10 align-self-end">
                <h1 class="text-uppercase text-white font-weight-bold">Пончики<br>как в Америке</h1>
            </div>
            <div class="col-lg-8 align-self-baseline">
                <p class="text-white-75 font-weight-light mb-5">Превосходный десерт по сладкой цене<br>с бесплатной
                    доставкой</p>
                <a class="btn btn-primary btn-lg js-scroll-trigger px-4" href="#about">Смотреть каталог</a>

                <p class="mt-5 text-white-75 font-weight-light ">Сделайте заказ прямо сейчас и получите скидку 10%</p>
            </div>
        </div>
    </div>
</header>

<!-- About-->
<section class="page-section bg-primary" style="" id="about">
    <div class="container">
        <div class="row ">
            <div class="col"></div>

            <div class="col ml-5 text-left">
                <h1 class="text-black-80 mt-0">Почему именно мы?</h1>
                <p class="text-black mb-4 mt-5">Современный и удобный интернет-магазин.
                    Где в одном месте собран весь наш ассортимент. Удобная навигация, фильтры по необходимым параметрам,
                    подробное описание товаров и разнообразие форм оплаты сделают покупку приятной, быстрой и
                    легкой.</p>
                <a class="" style="color: black" href="#services">Подробнее о нас</a>
            </div>
        </div>
    </div>
</section>


<%
    List<Donut> donuts = (List<Donut>) request.getAttribute("cards");
    if (donuts != null && !donuts.isEmpty()) {
        out.println("<ui>");
        for (Donut s : donuts) {
            out.println("<li style = 'margin-top: 20px; font-size:16px;'>" + s.authorName + "<br>" + s.title + "</li>");
        }
        out.println("</ui>");
    } else out.println("<p>There are no cards yet! </p>");
%>


</body>
</html>

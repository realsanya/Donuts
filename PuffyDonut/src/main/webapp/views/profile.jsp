<%@ page import="models.Review" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 07.10.2020
  Time: 23:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Профиль</title>
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
        .btn-primary.btn-lg {
            font-size: 10px;
            color: white;
            letter-spacing: 2px;
            border: 2px transparent;
            border-radius: 40px;
            background: transparent linear-gradient(to right, #973b99, #d56ed6);
            transition: all 0.3s ease 0s;
        }

        .gradient-text {
            text-transform: uppercase;
            background: transparent linear-gradient(to right, #973b99, #d56ed6);
            -webkit-background-clip: text;
            -webkit-text-fill-color: transparent;
            color: #0B2349;
            display: table;
            margin: 20px auto;
        }

    </style>
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

<div class="container mt-5  card px-5 pt-5 pb-5">
    <div class="row">
        <div class="col-lg-4 col-xl-4 ">
            <div class="card-box text-center ">
                <img src="../static/profile.jpg" class="rounded-circle   img-fluid " alt="profile-image">

                <h4 class="mb-2">Малиновая Сладость</h4>
                <h5 class="gradient-text">@Rarity</h5>


                <div class="text-left mt-3">
                    <h4 class="font-13 text-uppercase">Профиль:</h4>
                    <p class="text-muted font-13 mb-3">
                        Пончик с шоколадно-ореховой начинкой и глазурью из белого шоколада
                    </p>
                    <p class="text-muted mb-1 font-13"><strong>Почта :</strong> <span
                            class="ml-2">raritycute@gmail.com</span></p>

                    <p class="text-muted mb-2 font-13"><strong>Адрес :</strong> <span
                            class="ml-2">Улица Чернышевского</span></p>

                </div>
                <button type="button" class="btn btn-primary btn-lg ">Редактировать</button>


            </div> <!-- end card-box -->


        </div> <!-- end col-->

        <div class="col-lg-8 col-xl-8 ">
            <div class="card-box">
                <div class="tab-content">
                    <div class="tab-pane show active" id="about-me">
                        <h5 class="mb-4 text-uppercase"><i class="mdi mdi-briefcase mr-1"></i>
                            Мои отзывы</h5>
                        <ul class="list-unstyled timeline-sm">
                            <c:forEach items="($reviewList)" var="review">
                                <li class="timeline-sm-item">
                                    <div class="row">
                                        <div class="col-2">
                                            <img src="../static/donut.png" class="img-fluid">
                                        </div>
                                        <div class="col mt-auto mb-auto">
                                             <span class="timeline-sm-date">
                                                 $(review.getDate())
                                             </span>
                                            <h5 class="mt-0 mb-1">
                                                $(review.getUser_id())
                                            </h5>
                                        </div>
                                    </div>
                                    <p class="text-muted mt-2">
                                        $(review.getText())
                                    </p>
                                </li>
                            </c:forEach>


                            <%--                            <%--%>
                            <%--                                List<Review> reviewList = (List<Review>) request.getAttribute("reviewList");--%>
                            <%--                                if (reviewList != null && !reviewList.isEmpty()) {--%>
                            <%--                                    for (Review review : reviewList) {%>--%>
                            <%--                            <li class="timeline-sm-item">--%>
                            <%--                                <div class="row">--%>
                            <%--                                    <div class="col-2">--%>
                            <%--                                        <img src="../static/donut.png" class="img-fluid">--%>
                            <%--                                    </div>--%>
                            <%--                                    <div class="col mt-auto mb-auto">--%>
                            <%--                                             <span class="timeline-sm-date">--%>
                            <%--                                                 <%=review.getDate()%>--%>
                            <%--                                             </span>--%>
                            <%--                                        <h5 class="mt-0 mb-1">--%>
                            <%--                                            <%= review.getUser_id()%>--%>
                            <%--                                        </h5>--%>
                            <%--                                    </div>--%>
                            <%--                                </div>--%>
                            <%--                                <p class="text-muted mt-2">--%>
                            <%--                                        <%= review.getText()%> <%} }else{%>--%>
                            <%--                                <h2> Вы не оставили ни одного отзыва! </h2><% }%>--%>
                            <%--                                </p>--%>
                            <%--                            </li>--%>
                        </ul>
                    </div>
                </div> <!-- end tab-content -->
            </div> <!-- end card-box-->
        </div>
    </div>
</div>

<script>
    $("#comment_writer").hide();
    $("#write_comment").click(function () {
        $("#comment_writer").toggle();
    });
</script>

</body>
</html>

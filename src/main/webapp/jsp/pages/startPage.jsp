<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<!--[if IE 8]> <html class="ie8"> <![endif]-->
<!--[if IE 9]> <html class="ie9"> <![endif]-->
<!--[if !IE]><!--> <html> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <title>Venedor - Responsive eCommerce Template</title>
    <meta name="description" content="Responsive modern ecommerce Html5 Template">
    <!--[if IE]> <meta http-equiv="X-UA-Compatible" content="IE=edge"> <![endif]-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href='//fonts.googleapis.com/css?family=PT+Sans:400,700,400italic,700italic%7CPT+Gudea:400,700,400italic%7CPT+Oswald:400,700,300' rel='stylesheet' id="googlefont">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/prettyPhoto.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/owl.carousel.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/responsive.css">

    <!-- Favicon and Apple Icons -->
    <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/resources/images/icons/icon.png">
    <link rel="apple-touch-icon" sizes="57x57" href="${pageContext.request.contextPath}/resources/images/icons/apple-icon-57x57.png">
    <link rel="apple-touch-icon" sizes="72x72" href="${pageContext.request.contextPath}/resources/images/icons/apple-icon-72x72.png">

    <!--- jQuery -->
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="${pageContext.request.contextPath}/resources/js/jquery-1.11.1.min.js"><\/script>')</script>

    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>
    <![endif]-->

    <style id="custom-style">

    </style>
</head>
<body>
<div id="wrapper">
    <header id="header" class="header5">
        <div id="header-top">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="header-top-left">
                            <ul id="top-links" class="clearfix">
                                <li><a href="#" title="My Wishlist"><span class="top-icon top-icon-pencil"></span><span class="hide-for-xs">My Wishlist</span></a></li>
                                <li><a href="#" title="My Account"><span class="top-icon top-icon-user"></span><span class="hide-for-xs">My Account</span></a></li>
                                <li><a href="cart.html" title="My Cart"><span class="top-icon top-icon-cart"></span><span class="hide-for-xs">My Cart</span></a></li>
                                <li><a href="checkout.html" title="Checkout"><span class="top-icon top-icon-check"></span><span class="hide-for-xs">Checkout</span></a></li>
                            </ul>
                        </div><!-- End .header-top-left -->
                        <div class="header-top-right">

                            <div class="header-top-dropdowns pull-right">
                                <div class="btn-group dropdown-language">
                                    <button type="button" class="btn btn-custom dropdown-toggle" data-toggle="dropdown">
                                        <span class="flag-container"><img src="${pageContext.request.contextPath}/resources/images/england-flag.png" alt="flag of england"></span>
                                        <span class="hide-for-xs">English</span>
                                    </button>
                                    <ul class="dropdown-menu pull-right" role="menu">
                                        <li><a href="#"><span class="flag-container"><img src="${pageContext.request.contextPath}/resources/images/italy-flag.png" alt="flag of england"></span><span class="hide-for-xs">Russian</span></a></li>
                                    </ul>
                                </div><!-- End .btn-group -->
                            </div><!-- End .header-top-dropdowns -->

                            <div class="header-text-container pull-right">
                                <p class="header-link"><a href="#">login</a>&nbsp;or&nbsp;<a href="#">create an account</a></p>
                            </div><!-- End .pull-right -->
                        </div><!-- End .header-top-right -->
                    </div><!-- End .col-md-12 -->
                </div><!-- End .row -->
            </div><!-- End .container -->
        </div><!-- End #header-top -->

        <div id="inner-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12 logo-container">
                        <h1 class="logo clearfix">
                            <span>Responsive eCommerce Template</span>
                            <a href="index.html" title="Venedor eCommerce Template"><img src="${pageContext.request.contextPath}/resources/images/logo5.png" alt="Venedor Commerce Template" width="204" height="51"></a>
                        </h1>
                    </div><!-- End .col-md-12 -->
                    <div class="col-md-12 col-sm-12 col-xs-12 header-inner-right">



                        <div class="dropdown-cart-menu-container pull-right">
                            <div class="btn-group dropdown-cart">
                                <span class="cart-menu-icon"></span>
                                <button type="button" class="btn btn-custom dropdown-toggle" data-toggle="dropdown">
                                    0 item(s) <span class="drop-price">- $0.00</span>
                                </button>



                            </div><!-- End .dropdown-cart-menu-container -->

                        </div><!-- End .col-md-12 -->
                    </div><!-- End .row -->
                </div><!-- End .container -->

                <div id="main-nav-container">
                    <div class="container">
                        <div class="row">
                            <div class="col-md-12 clearfix">



                            </div><!-- End .col-md-12 -->
                        </div><!-- End .row -->
                    </div><!-- End .container -->

                </div><!-- End #nav -->
            </div><!-- End #inner-header -->
    </header><!-- End #header -->

    <!-- Page Content -->
    <div class="container">

        <div class="row">

            <div class="col-lg-3">

                <h1 class="my-4">Category</h1>
                <div class="list-group">
                    <c:forEach items="${listCategory}" var="category">
                    <a href="/shop/FrontController?command=show_products_category&category_id=${category.getId()}" class="list-group-item">${category.getName()}</a>
                    </c:forEach>
                </div>

            </div>
            <!-- /.col-lg-3 -->

            <div class="col-lg-9">

                <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">

                </div>

                <div class="row">
                    <c:forEach items="${listProduct}" var="product">
                    <div class="col-lg-4 col-md-6 mb-4">
                        <div class="card h-100">
                            <a href="#"><img class="img-fluid image1" src="${product.getPicture()}" alt=""></a>
                            <div class="card-body">
                                <h4 class="card-title">${product.getName()}</h4>
                                <h5>${product.getPrice()}</h5>

                            </div>
                            <div class="card-footer">
                                <a href="productInform.html" class="btn btn-primary">Find Out More!</a>
                            </div>
                        </div>
                    </div>
                    </c:forEach>

                </div>
                <!-- /.row -->

            </div>
            <!-- /.col-lg-9 -->

        </div>
        <!-- /.row -->

    </div>
    <!-- /.container -->

    <footer id="footer">

        <div id="footer-bottom">
            <div class="container">
                <div class="row">
                    <div class="col-md-5 col-sm-5 col-xs-12 footer-text-container">
                        <p>&copy; 2014 Powered by Company&trade;. All Rights Reserved.</p>
                    </div><!-- End .col-md-5 -->
                </div><!-- End .row -->
            </div><!-- End .container -->
        </div><!-- End #footer-bottom -->

    </footer><!-- End #footer -->
</div><!-- End #wrapper -->
<a href="#" id="scroll-top" title="Scroll to Top"><i class="fa fa-angle-up"></i></a><!-- End #scroll-top -->
<!-- END -->
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/smoothscroll.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.debouncedresize.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/retina.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.placeholder.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.hoverIntent.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/twitter/jquery.tweet.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.flexslider-min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/owl.carousel.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jflickrfeed.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.prettyPhoto.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.nouislider.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.jscrollpane.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.mousewheel.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>

</body>
</html>
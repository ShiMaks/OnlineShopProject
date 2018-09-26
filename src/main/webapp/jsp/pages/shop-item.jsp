<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="Resource"/>

<!DOCTYPE html>
<html>
<!--<![endif]-->

<!-- Head BEGIN -->
<head>
  <meta charset="utf-8">
  <title>Product Information</title>



  <link rel="shortcut icon" href="favicon.ico">

  <!-- Fonts START -->
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css"> 
  <!-- Fonts END -->

  <!-- Global styles START -->          
  <link href="${pageContext.request.contextPath}/resources/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Global styles END --> 
   
  <!-- Page level plugin styles START -->
  <link href="${pageContext.request.contextPath}/resources/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/plugins/owl.carousel/assets/owl.carousel.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
  <link href="http://code.jquery.com/ui/1.10.3/themes/smoothness/jquery-ui.css" rel="stylesheet" type="text/css"><!-- for slider-range -->
  <link href="${pageContext.request.contextPath}/resources/plugins/rateit/src/rateit.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href="${pageContext.request.contextPath}/resources/pages/css/components.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/corporate/css/style.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/pages/css/style-shop.css" rel="stylesheet" type="text/css">
  <link href="${pageContext.request.contextPath}/resources/corporate/css/style-responsive.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/corporate/css/themes/red.css" rel="stylesheet" id="style-color">
  <link href="${pageContext.request.contextPath}/resources/corporate/css/custom.css" rel="stylesheet">
  <!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="ecommerce">
    
  <!-- BEGIN TOP BAR -->
  <div class="pre-header">
    <div class="container">
        <div class="row">
            <!-- BEGIN TOP BAR LEFT PART -->
            <div class="col-md-6 col-sm-6 additional-shop-info">
                <ul class="list-unstyled list-inline">
                    <li><i class="fa fa-phone"></i><span>+375(29) 764-80-65</span></li>
                    
                    <!-- BEGIN LANGS -->
                    <li class="langs-block">
                        <a href="/shop/FrontController?command=change_locale&locale=en" class="current"><fmt:message key="en_language" /> </a>
                        <div class="langs-block-others-wrapper"><div class="langs-block-others">
                          <a href="/shop/FrontController?command=change_locale&locale=ru"><fmt:message key="ru_language" /></a>
                        </div></div>
                    </li>
                    <!-- END LANGS -->
                </ul>
            </div>
            <!-- END TOP BAR LEFT PART -->
            <!-- BEGIN TOP BAR MENU -->
            <div class="col-md-6 col-sm-6 additional-nav">
                <ul class="list-unstyled list-inline pull-right">
                    <li><a href="/shop/FrontController?command=to_my_account"><fmt:message key="my_account" /></a></li>
                    <li><a href="/shop/FrontController?command=to_log_in"><fmt:message key="log_in" /></a></li>
                    <li><a href="/shop/FrontController?command=to_registration"><fmt:message key="registr" /></a></li>
                    <li><a href="/shop/FrontController?command=to_log_out"><fmt:message key="log_out" /></a></li>
                </ul>
            </div>
            <!-- END TOP BAR MENU -->
        </div>
    </div>        
  </div>
  <!-- END TOP BAR -->

  <!-- BEGIN HEADER -->
  <div class="header">
    <div class="container">
        <a class="site-logo" href="/shop/FrontController?command=start_page"><img src="${pageContext.request.contextPath}/resources/corporate/img/logos/logo-shop-red.png" alt="e-Shop"></a>

      <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

      <!-- BEGIN CART -->
      <div class="top-cart-block">
        <div class="top-cart-info">
            <c:choose>
            <c:when test="${sessionScope.shopCart != null}">
                <a href="#" class="top-cart-info-count">${sessionScope.shopCart.getQuantityProducts()} <fmt:message key="items" /></a>
                <a href="#" class="top-cart-info-value">$ ${sessionScope.shopCart.getTotalCost()}</a>
            </c:when>
            <c:when test="${sessionScope.shopCart == null}">
                <a href="#" class="top-cart-info-count">0 <fmt:message key="items" /></a>
                <a href="#" class="top-cart-info-value">$ 0</a>
            </c:when>    
            </c:choose>
          </div>
      <a href="/shop/FrontController?command=to_cart"><i class="fa fa-shopping-cart"></i></a>                        
    </div>
    <!--END CART -->

      <!-- BEGIN NAVIGATION -->
      <div class="header-navigation">
        <ul>
        </ul>
      </div>
      <!-- END NAVIGATION -->
    </div>
  </div>
  <!-- Header END -->
    
    <div class="main">
      <div class="container">

          <!-- BEGIN SIDEBAR & CONTENT -->
          <div class="row margin-bottom-40">
              <!-- BEGIN SIDEBAR -->
              <div class="sidebar col-md-3 col-sm-5">
                <ul class="list-group margin-bottom-25 sidebar-menu">
                  
                </ul>            
              </div>
              <!-- END SIDEBAR -->
       
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-7">
            <div class="product-page">
              <div class="row">
                <div class="col-md-6 col-sm-6">
                  <div class="product-main-image">
                    <img src="<c:out value="${product.getPicture()}"/>" alt="Cool green dress with red bell" class="img-responsive" data-BigImgsrc="<c:out value="${product.getPicture()}"/>">
                  </div>
                  
                </div>
                <div class="col-md-6 col-sm-6">
                  <h1><c:out value="${product.getName()}"/></h1>
                  <div class="price-availability-block clearfix">
                    <div class="price">
                      <strong><span>$</span><c:out value="${product.getPrice()}"/></strong>
                    </div>
                  
                  </div>
                  <div class="description">
                    <p><c:out value="${product.getDescription()}"/></p>
                  </div>
                  <form name = "addProductToCart" action="FrontController" method="POST">
                    <input type="hidden" name="product_id" value="${product.getId()}" />

                  <div class="product-page-cart">
                    <div class="product-quantity">
                        <input id="product-quantity" type="text" name="quantity" value="1" class="form-control input-sm">
                    </div> 
                      <button class="btn btn-primary" type="submit" name="command" value="add_product_to_cart">
                        <fmt:message key="add" />
                      </button>  
                    </form>
                  </div>
                  
                  
                </div>

                

                <div class="sticker sticker-sale"></div>
              </div>
            </div>
          </div>
          <!-- END CONTENT -->
        </div>
        <!-- END SIDEBAR & CONTENT -->
      </div>
    </div>

    <!-- BEGIN FOOTER -->
    <div class="footer">
      <div class="container">
        <div class="row">
          <!-- BEGIN COPYRIGHT -->
          <div class="col-md-4 col-sm-4 padding-top-10">
            2018 © Maksim Shilvian. ALL Rights Reserved. 
          </div>
          <!-- END COPYRIGHT -->
          <!-- BEGIN PAYMENTS -->
          
          <!-- END PAYMENTS -->
          <!-- BEGIN POWERED -->
          
          <!-- END POWERED -->
        </div>
      </div>
    </div>
    <!-- END FOOTER -->

    
    <!-- Load javascripts at bottom, this will reduce page load time -->
    <!-- BEGIN CORE PLUGINS(REQUIRED FOR ALL PAGES) -->
    <!--[if lt IE 9]>
    <script src="${pageContext.request.contextPath}/resources/plugins/respond.min.js"></script>
    <![endif]-->  
    <script src="${pageContext.request.contextPath}/resources/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/jquery-migrate.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/corporate/scripts/back-to-top.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src="${pageContext.request.contextPath}/resources/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="${pageContext.request.contextPath}/resources/plugins/owl.carousel/owl.carousel.min.js" type="text/javascript"></script><!-- slider for products -->
    <script src='${pageContext.request.contextPath}/resources/plugins/zoom/jquery.zoom.min.js' type="text/javascript"></script><!-- product zoom -->
    <script src="${pageContext.request.contextPath}/resources/plugins/bootstrap-touchspin/bootstrap.touchspin.js" type="text/javascript"></script><!-- Quantity -->
    <script src="${pageContext.request.contextPath}/resources/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/rateit/src/jquery.rateit.js" type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/resources/corporate/scripts/layout.js" type="text/javascript"></script>

    <!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
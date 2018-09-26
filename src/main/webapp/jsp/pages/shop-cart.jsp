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
  <title>Shopping cart</title>

  
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
          <!-- BEGIN CONTENT -->
          <c:choose> 
            <c:when test="${sessionScope.shopCart.getQuantityProducts() == 0}">
              <div class="col-md-12 col-sm-12">
                <h1><fmt:message key="shopping_cart" /></h1>
                <div class="shopping-cart-page">
                  <div class="shopping-cart-data clearfix">
                    <p><fmt:message key="empty_cart" /></p>
                  </div>
                </div>
              </div>
            </c:when>
            <c:when test="${sessionScope.shopCart.getQuantityProducts() != 0}">
            <div class="col-md-12 col-sm-12">
              <h1><fmt:message key="shopping_cart" /></h1>
              <div class="goods-page">
                <div class="goods-data clearfix">
                  <div class="table-wrapper-responsive">
                  <table summary="Shopping cart">
                    <tr>
                      <th class="goods-page-image"><fmt:message key="image" /></th>
                      <th class="goods-page-description"><fmt:message key="description" /></th>
                      <th class="goods-page-quantity"><fmt:message key="quantity" /></th>
                      <th class="goods-page-price"><fmt:message key="unit_price" /></th>
                      <th class="goods-page-total" colspan="2"><fmt:message key="total" /></th>
                    </tr>
                    <c:forEach items="${sessionScope.shopCart.getProducts()}" var="entry">
                      <tr>
                        <td class="goods-page-image">
                          <a href="#"><img src="${entry.key.getPicture()}" alt="Berry Lace Dress"></a>
                        </td>
                        <td class="goods-page-description">
                          <h3><a href="/shop/FrontController?command=show_products_info&product_id=${product.getId()};">${entry.key.getName()}</a></h3>
                          <p><strong></strong></p>
                          <em></em>
                        </td>
                        <td class="goods-page-quantity">
                          <div class="product-quantity">
                              <strong><span></span>${entry.getValue()}</strong>
                          </div>
                        </td>
                        <td class="goods-page-price">
                          <strong><span>$</span>${entry.key.getPrice()}</strong>
                        </td>
                        <td class="goods-page-total">
                          <strong><span>$</span>${entry.key.getPrice()*entry.getValue()}</strong>
                        </td>
                        <td class="del-goods-col">
                            <form action="FrontController" method="POST">
                                <input type="hidden" name="command" value="remove_from_cart" />
                                <input type="hidden" name="product_id" value="${entry.key.getId()}" />
                                <input type="submit" value="" class="del-goods"/>
                            </form>                      
                        </td>
                      </tr>
                    </c:forEach>
                  </table>
                  </div>

                  <div class="shopping-total">
                    <ul> 
                      <li class="shopping-total-price">
                        <em>Total</em>
                        <strong class="price"><span>$</span>${sessionScope.shopCart.getTotalCost()}</strong>
                      </li>
                    </ul>
                  </div>
                </div>
                <form name = "сheckout" action="FrontController" method="GET">
                  <button class="btn btn-primary" type="submit" name="command" value="create_order">
                    <fmt:message key="checkout" />
                   </button>  
                </form>  
              </div>
            </div>
            </c:when>
          </c:choose>  
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
      </div>
    </div>
  </div>
  <!-- END FOOTER -->

    
    <!-- Load javascripts at bottom, this will reduce page load time -->
    <!-- BEGIN CORE PLUGINS (REQUIRED FOR ALL PAGES) -->
    <!--[if lt IE 9]>
    <script src="assets/plugins/respond.min.js"></script>  
    <![endif]-->  
    <script src="${pageContext.request.contextPath}/resources/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="assets/${pageContext.request.contextPath}/resources/assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
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
    <script src="http://code.jquery.com/ui/1.10.3/jquery-ui.js" type="text/javascript"></script><!-- for slider-range -->

    <script src="assets/corporate/scripts/layout.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
            Layout.initTwitter();
            Layout.initImageZoom();
            Layout.initTouchspin();
            Layout.initUniform();
            Layout.initSliderRange();
        });
    </script>
    <!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
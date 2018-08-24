<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
Template: Metronic Frontend Freebie - Responsive HTML Template Based On Twitter Bootstrap 3.3.4
Version: 1.0.0
Author: KeenThemes
Website: http://www.keenthemes.com/
Contact: support@keenthemes.com
Follow: www.twitter.com/keenthemes
Like: www.facebook.com/keenthemes
Purchase Premium Metronic Admin Theme: http://themeforest.net/item/metronic-responsive-admin-dashboard-template/4021469?ref=keenthemes
-->
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en">
<!--<![endif]-->

<!-- Head BEGIN -->
<head>
  <meta charset="utf-8">
  <title>Infoproduct</title>



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
                      <li><i class="fa fa-phone"></i><span>+1 456 6717</span></li>
                      
                      <!-- BEGIN LANGS -->
                      <li class="langs-block">
                          <a href="javascript:void(0);" class="current">English </a>
                          <div class="langs-block-others-wrapper"><div class="langs-block-others">
                            <a href="javascript:void(0);">Russian</a>
                      
                          </div></div>
                      </li>
                      <!-- END LANGS -->
                  </ul>
              </div>
              <!-- END TOP BAR LEFT PART -->
              <!-- BEGIN TOP BAR MENU -->
              <div class="col-md-6 col-sm-6 additional-nav">
                  <ul class="list-unstyled list-inline pull-right">
                      <li><a href="shop-account.html">My Account</a></li>
                      <li><a href="shop-wishlist.html">My Wishlist</a></li>
                      <li><a href="shop-checkout.html">Checkout</a></li>
                      <li><a href="page-login.html">Log In</a></li>
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
      <a class="site-logo" href="shop-index.html"><img src="${pageContext.request.contextPath}/corporate/img/logos/logo-shop-red.png" alt="Metronic Shop UI"></a>

      <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

      <!-- BEGIN CART -->
      <div class="top-cart-block">
        
        <a href="shop-shopping-cart.html"><i class="fa fa-shopping-cart"></i></a>
                      
                   
      </div>
      <!--END CART -->

      <!-- BEGIN NAVIGATION -->
      <div class="header-navigation">
        <ul>
          <!-- BEGIN TOP SEARCH -->
          <li class="menu-search">
            <span class="sep"></span>
            <i class="fa fa-search search-btn"></i>
            <div class="search-box">
              <form action="#">
                <div class="input-group">
                  <input type="text" placeholder="Search" class="form-control">
                  <span class="input-group-btn">
                    <button class="btn btn-primary" type="submit">Search</button>
                  </span>
                </div>
              </form>
            </div> 
          </li>
          <!-- END TOP SEARCH -->
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
          <h1><span>  Categories:</span></h1>
          <div class="sidebar col-md-3 col-sm-5">
            <ul class="list-group margin-bottom-25 sidebar-menu">
              <c:forEach items="${listCategory}" var="category">
                <li class="list-group-item clearfix"><a href=""><i class="fa fa-angle-right"></i> ${category.getName()}</a></li>
              </c:forEach>
            </ul>

            
          </div>
          <!-- END SIDEBAR -->

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
                    <div class="availability">
                      Availability: <strong>In Stock</strong>
                    </div>
                  </div>
                  <div class="description">
                    <p><c:out value="${product.getDescription()}"/></p>
                  </div>
                  
                  <div class="product-page-cart">
                    <div class="product-quantity">
                        <input id="product-quantity" type="text" value="1" readonly class="form-control input-sm">
                    </div>
                    <form name = "addProductCart" action="FrontController" method="GET">
                      <input type="hidden" name="command" value="add_product_to_cart" />
                      <input type="submit" class="btn btn-primary" value="Add to cart">
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
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
            Layout.initTwitter();
            Layout.initImageZoom();
            Layout.initTouchspin();
            Layout.initUniform();
        });
    </script>
    <!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
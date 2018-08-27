<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
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
      <a class="site-logo" href="shop-index.html"><img src="${pageContext.request.contextPath}/resources/corporate/img/logos/logo-shop-red.png" alt="Metronic Shop UI"></a>

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
          <!-- BEGIN CONTENT -->
          <div class="col-md-12 col-sm-12">
            <h1>Shopping cart</h1>
            <div class="goods-page">
              <div class="goods-data clearfix">
                <div class="table-wrapper-responsive">
                <table summary="Shopping cart">
                  <tr>
                    <th class="goods-page-image">Image</th>
                    <th class="goods-page-description">Description</th>
                    <th class="goods-page-quantity">Quantity</th>
                    <th class="goods-page-price">Unit price</th>
                    <th class="goods-page-total" colspan="2">Total</th>
                  </tr>
                  <c:forEach items="${sessionScope.shopCart.getProducts()}" var="entry">
                    <tr>
                      <td class="goods-page-image">
                        <a href="#"><img src="${entry.key.getPicture()}" alt="Berry Lace Dress"></a>
                      </td>
                      <td class="goods-page-description">
                        <h3><a href="javascript:;">${entry.key.getName()}</a></h3>
                        <p><strong></strong></p>
                        <em></em>
                      </td>
                      <td class="goods-page-quantity">
                        <div class="product-quantity">
                            <input id="product-quantity" type="text" value="1" readonly class="form-control input-sm">
                        </div>
                      </td>
                      <td class="goods-page-price">
                        <strong><span>$</span>${entry.key.getPrice()}</strong>
                      </td>
                      <td class="goods-page-total">
                        <strong><span>$</span>${entry.key.getPrice()}</strong>
                      </td>
                      <td class="del-goods-col">
                        <a class="del-goods" href="javascript:;">&nbsp;</a>
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
              
              <button class="btn btn-primary" type="submit">Checkout <i class="fa fa-check"></i></button>
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
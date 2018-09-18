<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<!--<![endif]-->

<!-- Head BEGIN -->
<head>
  <meta charset="utf-8">
  <title>My Account</title>

  <link rel="shortcut icon" href="favicon.ico">

  <!-- Fonts START -->
  <link href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700|PT+Sans+Narrow|Source+Sans+Pro:200,300,400,600,700,900&amp;subset=all" rel="stylesheet" type="text/css"> 
  <!-- Fonts END -->

  <!-- Global styles START -->          
  <link href="assets/plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet">
  <link href="assets/plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <!-- Global styles END --> 
   
  <!-- Page level plugin styles START -->
  <link href="assets/plugins/fancybox/source/jquery.fancybox.css" rel="stylesheet">
  <link href="assets/plugins/owl.carousel/assets/owl.carousel.css" rel="stylesheet">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href="assets/pages/css/components.css" rel="stylesheet">
  <link href="assets/corporate/css/style.css" rel="stylesheet">
  <link href="assets/pages/css/style-shop.css" rel="stylesheet" type="text/css">
  <link href="assets/corporate/css/style-responsive.css" rel="stylesheet">
  <link href="assets/corporate/css/themes/red.css" rel="stylesheet" id="style-color">
  <link href="assets/corporate/css/custom.css" rel="stylesheet">
  <!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
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
                    <li><a href="/shop/FrontController?command=to_log_in">Log In</a></li>
                    <li><a href="/shop/FrontController?command=to_registration">Registration</a></li>
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
    <a class="site-logo" href="shop-index.html"><img src="${pageContext.request.contextPath}/resources/corporate/img/logos/logo-shop-red.png" alt="e-Shop"></a>

    <a href="javascript:void(0);" class="mobi-toggler"><i class="fa fa-bars"></i></a>

    <!-- BEGIN CART -->
    <div class="top-cart-block">
        <div class="top-cart-info">
            <a href="#" class="top-cart-info-count">3 items</a>
            <a href="#" class="top-cart-info-value">$1260</a>
          </div>
      <a href="shop-shopping-cart.html"><i class="fa fa-shopping-cart"></i></a>                        
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
          <div class="sidebar col-md-3 col-sm-3">
            <ul class="list-group margin-bottom-25 sidebar-menu">
              <li class="list-group-item clearfix"><a href="javascript:;"><i class="fa fa-angle-right"></i> Login/Register</a></li>
              <li class="list-group-item clearfix"><a href="javascript:;"><i class="fa fa-angle-right"></i> Restore Password</a></li>
              <li class="list-group-item clearfix"><a href="javascript:;"><i class="fa fa-angle-right"></i> My account</a></li>
              <li class="list-group-item clearfix"><a href="javascript:;"><i class="fa fa-angle-right"></i> Address book</a></li>
              <li class="list-group-item clearfix"><a href="javascript:;"><i class="fa fa-angle-right"></i> Wish list</a></li>
              <li class="list-group-item clearfix"><a href="javascript:;"><i class="fa fa-angle-right"></i> Returns</a></li>
              <li class="list-group-item clearfix"><a href="javascript:;"><i class="fa fa-angle-right"></i> Newsletter</a></li>
            </ul>
          </div>
          <!-- END SIDEBAR -->

          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-8">
            <h1>My Account Page</h1>
            <div class="content-page">
              <div class="col-12">
                  <div class="card">
                      <div class="card-body">
                          <h4 class="card-title">Orders:</h4>
                      </div>
                      <div class="table-responsive">
                          <table class="table table-hover">
                              <thead>
                                  <tr>
                                      <th class="border-top-0">NAME</th>
                                      <th class="border-top-0">STATUS</th>
                                      <th class="border-top-0">DATE</th>
                                      <th class="border-top-0">PRICE</th>
                                  </tr>
                              </thead>
                              <tbody>
                                  <tr>
                                      
                                      <td class="txt-oflo">Elite admin</td>
                                      <td><span class="label label-success label-rounded">SALE</span> </td>
                                      <td class="txt-oflo">April 18, 2017</td>
                                      <td><span class="font-medium">$24</span></td>
                                  </tr>
                                  <tr>
                                      
                                      <td class="txt-oflo">Real Homes WP Theme</td>
                                      <td><span class="label label-info label-rounded">EXTENDED</span></td>
                                      <td class="txt-oflo">April 19, 2017</td>
                                      <td><span class="font-medium">$1250</span></td>
                                  </tr>
                                  <tr>
                                      
                                      <td class="txt-oflo">Ample Admin</td>
                                      <td><span class="label label-purple label-rounded">Tax</span></td>
                                      <td class="txt-oflo">April 19, 2017</td>
                                      <td><span class="font-medium">$1250</span></td>
                                  </tr>
                                  <tr>
                                      
                                      <td class="txt-oflo">Medical Pro WP Theme</td>
                                      <td><span class="label label-success label-rounded">Sale</span></td>
                                      <td class="txt-oflo">April 20, 2017</td>
                                      <td><span class="font-medium">-$24</span></td>
                                  </tr>
                                  <tr>
                                      
                                      <td class="txt-oflo">Hosting press html</td>
                                      <td><span class="label label-success label-rounded">SALE</span></td>
                                      <td class="txt-oflo">April 21, 2017</td>
                                      <td><span class="font-medium">$24</span></td>
                                  </tr>
                                  <tr>
                                      
                                      <td class="txt-oflo">Digital Agency PSD</td>
                                      <td><span class="label label-danger label-rounded">Tax</span> </td>
                                      <td class="txt-oflo">April 23, 2017</td>
                                      <td><span class="font-medium">-$14</span></td>
                                  </tr>
                              </tbody>
                          </table>
                      </div>
                  </div>
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
    <script src="assets/plugins/respond.min.js"></script>  
    <![endif]-->  
    <script src="assets/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-migrate.min.js" type="text/javascript"></script>
    <script src="assets/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script src="assets/corporate/scripts/back-to-top.js" type="text/javascript"></script>
    <script src="assets/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src="assets/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="assets/plugins/owl.carousel/owl.carousel.min.js" type="text/javascript"></script><!-- slider for products -->

    <script src="assets/corporate/scripts/layout.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();    
            Layout.initOWL();
            Layout.initTwitter();
        });
    </script>
    <!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
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
  <title>My Account: Information</title> 

  <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/favicon.ico">

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

        <c:if test="${not empty info_message}">
            <div class="alert alert-success" role="alert">
                <h4>
                    <strong>
                        <fmt:message key="${info_message}" />
                    </strong>
                </h4>
            </div>
        </c:if> 
        
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
          <!-- BEGIN SIDEBAR -->
          <div class="sidebar col-md-3 col-sm-3">
            <ul class="list-group margin-bottom-25 sidebar-menu">
                <li class="list-group-item clearfix"><a href="/shop/FrontController?command=to_my_account"><i class="fa fa-angle-right"></i> <fmt:message key="my_orders" /></a></li>
                <li class="list-group-item clearfix"><a href="/shop/FrontController?command=to_change_password"><i class="fa fa-angle-right"></i> <fmt:message key="change_password" /></a></li>
                <li class="list-group-item clearfix"><a href="/shop/FrontController?command=to_my_information"><i class="fa fa-angle-right"></i> <fmt:message key="my_information" /></a></li>
            </ul>
          </div>
          <!-- END SIDEBAR -->

          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-7">
            <h1><fmt:message key="my_account" /></h1>
            <div class="col-lg-8 col-xlg-9 col-md-7">
                    <div class="card">
                        <div class="card-body">
                            <form class="form-horizontal form-material" name="updateUserUnform" action="FrontController" method="POST">
                                <input type="hidden" name="user_id" value = <c:out value="${userInform.getId()}"/>  
                                <div class="form-group">
                                    <label class="col-md-12"><fmt:message key="login" /></label>
                                    <div class="col-md-12">
                                        <input type="text" disabled="disabled" class="form-control form-control-line" name="login" value="<c:out value="${userInform.getLogin()}"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12"><fmt:message key="name" /></label>
                                    <div class="col-md-12">
                                        <input type="text" class="form-control form-control-line" name="name" value="<c:out value="${userInform.getName()}"/>">
                                    </div>
                                </div>
                                <c:if test="${not empty invalid_name}">                                    
                                    <div class="alert alert-danger" role="alert">
                                        <fmt:message key="${invalid_name}" />
                                    </div>
                                </c:if>   
                                <div class="form-group">
                                    <label class="col-md-12"><fmt:message key="surname" /></label>
                                    <div class="col-md-12">
                                        <input type="text" class="form-control form-control-line" name="surname" value="<c:out value="${userInform.getSurname()}"/>">
                                    </div>
                                </div>
                                <c:if test="${not empty invalid_surname}">                                    
                                    <div class="alert alert-danger" role="alert">
                                        <fmt:message key="${invalid_surname}" />
                                    </div>
                                </c:if>   
                                <div class="form-group">
                                    <label for="example-email" class="col-md-12"><fmt:message key="email" /></label>
                                    <div class="col-md-12">
                                        <input type="email" disabled="disabled" class="form-control form-control-line" id="example-email" name="email" value="<c:out value="${userInform.getEmail()}"/>">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-12"><fmt:message key="phone" /></label>
                                    <div class="col-md-12">
                                        <input type="text" class="form-control form-control-line" name="phone" value="<c:out value="${userInform.getPhone()}"/>">
                                    </div>
                                </div>
                                <c:if test="${not empty invalid_phone}">                                    
                                    <div class="alert alert-danger" role="alert">
                                        <fmt:message key="${invalid_phone}" />
                                    </div>
                                </c:if>   
                                <div class="form-group">
                                </div>
                                <div class="form-group">
                                    <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">
                                        <button class="btn btn-success" type="submit" name="command" value="update_user_inform">
                                            <fmt:message key="update" />
                                        </button>  
                                    </div>
                                </div>
                            </form>
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
        </div>
      </div>
    </div>
    <!-- END FOOTER -->

    <!-- Load javascripts at bottom, this will reduce page load time -->
    <!-- BEGIN CORE PLUGINS(REQUIRED FOR ALL PAGES) -->

    <script src="${pageContext.request.contextPath}/resources/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/jquery-migrate.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script src="${pageContext.request.contextPath}/resources/corporate/scripts/back-to-top.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src="${pageContext.request.contextPath}/resources/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="${pageContext.request.contextPath}/resources/plugins/owl.carousel/owl.carousel.min.js" type="text/javascript"></script><!-- slider for products -->

    <script src="${pageContext.request.contextPath}/resources/corporate/scripts/layout.js" type="text/javascript"></script>
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
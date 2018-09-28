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
  <title>Login</title>


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
  <link href="${pageContext.request.contextPath}/resources/plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css">
  <!-- Page level plugin styles END -->

  <!-- Theme styles START -->
  <link href="${pageContext.request.contextPath}/resources/pages/css/components.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/corporate/css/style.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/corporate/css/style-responsive.css" rel="stylesheet">
  <link href="${pageContext.request.contextPath}/resources/corporate/css/themes/red.css" rel="stylesheet" id="style-color">
  <link href="${pageContext.request.contextPath}/resources/corporate/css/custom.css" rel="stylesheet">
  <!-- Theme styles END -->
</head>
<!-- Head END -->

<!-- Body BEGIN -->
<body class="corporate">    
    <!-- BEGIN TOP BAR -->
    <div class="pre-header">
        <div class="container">
            <div class="row">
                <!-- BEGIN TOP BAR LEFT PART -->
                <div class="col-md-6 col-sm-6 additional-shop-info">
                    <ul class="list-unstyled list-inline">
                        <li><i class="fa fa-phone"></i><span>+375(29) 764-80-65</span></li>
                        
                    </ul>
                </div>
                <!-- END TOP BAR LEFT PART -->
                <!-- BEGIN TOP BAR MENU -->
                <div class="col-md-6 col-sm-6 additional-nav">
                    <ul class="list-unstyled list-inline pull-right">
                        <li><a href="/shop/FrontController?command=to_log_in"><fmt:message key="log_in" /></a></li>
                        <li><a href="/shop/FrontController?command=to_registration"><fmt:message key="registr" /></a></li>
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

       
      </div>
    </div>
    <!-- Header END -->

    <div class="main">
      <div class="container">
          <c:if test="${not empty info_message}">
              <div class="alert alert-danger" role="alert">
                  <h4>
                      <strong>
                          <fmt:message key="${info_message}" />
                      </strong>
                  </h4>
              </div>
          </c:if>    
      
        <!-- BEGIN SIDEBAR & CONTENT -->
        <div class="row margin-bottom-40">
       
          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-9">
            <h1>Login</h1>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                  
                    <form name = "LogIn" action="FrontController" method="POST" class="form-horizontal form-without-legend">
                      <div class="form-group">
                        <label for="text" class="col-lg-4 control-label"><fmt:message key="login" /> <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="login" class="form-control" id="email">
                        </div>
                      </div>
                      <div class="form-group">
                        <label for="password" class="col-lg-4 control-label"><fmt:message key="password" /> <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="password" name="password" class="form-control" id="password">
                        </div>
                      </div>
                      <div class="row">
                        
                       
                          <button class="btn btn-primary"  align="right" type="submit" name="command" value="log_in">
                            <fmt:message key="log_in" />
                          </button>
                        
                      </div>
                    </form>  
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


    <script src="${pageContext.request.contextPath}/resources/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/jquery-migrate.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script src="${pageContext.request.contextPath}/resources/corporate/scripts/back-to-top.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src="${pageContext.request.contextPath}/resources/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="${pageContext.request.contextPath}/resources/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>

    <script src="assets/corporate/scripts/layout.js" type="text/javascript"></script>
    <script type="text/javascript">
        jQuery(document).ready(function() {
            Layout.init();
            Layout.initUniform();
            Layout.initTwitter();
        });
    </script>
    <!-- END PAGE LEVEL JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>
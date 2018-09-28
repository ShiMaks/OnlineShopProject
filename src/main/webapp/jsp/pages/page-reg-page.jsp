<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="Resource"/>

<!DOCTYPE html>
<html>

<!-- Head BEGIN -->
<head>
  <meta charset="utf-8">
  <title>Create new account</title>

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
        
          <!-- BEGIN CONTENT -->
          <div class="col-md-9 col-sm-9">
            <h1><fmt:message key="create_account" /></h1>
            <div class="content-form-page">
              <div class="row">
                <div class="col-md-7 col-sm-7">
                  <form name="registration" action="FrontController" method="POST" class="form-horizontal" role="form">
                    <fieldset>
                      <legend><fmt:message key="personal_details" /></legend>
                      <div class="form-group">
                          <label for="login" class="col-lg-4 control-label"><fmt:message key="login" /> <span class="require">*</span></label>
                          <div class="col-lg-8">
                            <input type="text" name="login" class="form-control" id="login">
                          </div>
                      </div>
                      <c:if test="${not empty invalid_login}">                                    
                        <div class="alert alert-danger" role="alert">
                          <fmt:message key="${invalid_login}" />
                        </div>
                      </c:if>   
                      <div class="form-group">
                        <label for="firstname" class="col-lg-4 control-label"><fmt:message key="name" /> <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="name" class="form-control" id="firstname">
                        </div>
                      </div>
                      <c:if test="${not empty invalid_name}">                                    
                        <div class="alert alert-danger" role="alert">
                          <fmt:message key="${invalid_name}" />
                        </div>
                      </c:if>   
                      <div class="form-group">
                        <label for="lastname" class="col-lg-4 control-label"><fmt:message key="surname" /> <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="surname" class="form-control" id="lastname">
                        </div>
                      </div>
                      <c:if test="${not empty invalid_surname}">                                    
                        <div class="alert alert-danger" role="alert">
                          <fmt:message key="${invalid_surname}" />
                        </div>
                      </c:if>   
                      <div class="form-group">
                        <label for="email" class="col-lg-4 control-label"><fmt:message key="email" /> <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="email" class="form-control" id="email">
                        </div>
                      </div>
                      <c:if test="${not empty invalid_email}">                                    
                        <div class="alert alert-danger" role="alert">
                          <fmt:message key="${invalid_email}" />
                        </div>
                      </c:if>   
                      <div class="form-group">
                        <label for="email" class="col-lg-4 control-label"><fmt:message key="phone" /> <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="text" name="phone" class="form-control" id="email">
                        </div>
                      </div>
                      <c:if test="${not empty invalid_phone}">                                    
                        <div class="alert alert-danger" role="alert">
                          <fmt:message key="${invalid_phone}" />
                        </div>
                      </c:if>   
                    </fieldset>
                    <fieldset>
                      <legend><fmt:message key="your_password" /> </legend>
                      <div class="form-group">
                        <label for="password" class="col-lg-4 control-label"><fmt:message key="password" /> <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="password" name="password" class="form-control" id="password">
                        </div>
                      </div>
                      <c:if test="${not empty invalid_password}">                                    
                        <div class="alert alert-danger" role="alert">
                          <fmt:message key="${invalid_password}" />
                        </div>
                      </c:if>   
                      <div class="form-group">
                        <label for="confirm-password" class="col-lg-4 control-label"><fmt:message key="confirm_password" /> <span class="require">*</span></label>
                        <div class="col-lg-8">
                          <input type="password" name="confirm_password" class="form-control" id="confirm-password">
                        </div>
                      </div>
                      <c:if test="${not empty invalid_confirm_password}">                                    
                        <div class="alert alert-danger" role="alert">
                          <fmt:message key="${invalid_confirm_password}" />
                        </div>
                      </c:if> 
                    </fieldset>
                    
                    <div class="row">
                      <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20"> 
                        <button class="btn btn-primary" type="submit" name="command" value="register">
                          <fmt:message key="create_account" />
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


    <script src="${pageContext.request.contextPath}/resources/plugins/jquery.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/jquery-migrate.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath}/resources/plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>      
    <script src="${pageContext.request.contextPath}/resources/corporate/scripts/back-to-top.js" type="text/javascript"></script>
    <!-- END CORE PLUGINS -->

    <!-- BEGIN PAGE LEVEL JAVASCRIPTS (REQUIRED ONLY FOR CURRENT PAGE) -->
    <script src="${pageContext.request.contextPath}/resources/plugins/fancybox/source/jquery.fancybox.pack.js" type="text/javascript"></script><!-- pop up -->
    <script src="${pageContext.request.contextPath}/resources/plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>

    <script src="${pageContext.request.contextPath}/resources/corporate/scripts/layout.js" type="text/javascript"></script>
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
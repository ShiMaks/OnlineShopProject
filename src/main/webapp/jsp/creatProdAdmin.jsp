<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="Resource"/>

<!DOCTYPE html>
<html>
<head>
	<c:import url="../jsp/head_admin.jsp" />

    <style type="text/css">
        body {font-size:14px;}
        label {float:left; padding-right:10px;}
        .field {clear:both; text-align:right; line-height:25px;}
        .main {float:left;}
    </style>

</head>
<body>

<div class="wrapper">

    <div class="container-fluid">

        <nav class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar bar1"></span>
                        <span class="icon-bar bar2"></span>
                        <span class="icon-bar bar3"></span>
                    </button>
                    <a class="navbar-brand" href="#"><fmt:message key="admin" /></a>
                </div>
                <div class="col text-right align-self-end">
                    <a href="/shop/FrontController?command=change_locale&locale=en" 
                    class="btn btn-link text-white btn-sm px-0" role="button">EN</a>
                    <a href="/shop/FrontController?command=change_locale&locale=ru" 
                    class="btn btn-link text-white btn-sm px-0 mr-2" role="button">RU</a>
                </div>
                <div class="collapse navbar-collapse">
                    <ul class="nav navbar-nav navbar-right">
                        
                        <li>
                            <a href="/shop/FrontController?command=to_log_out">
                                <i class="ti-settings"></i>
                                <p><fmt:message key="log_out" /></p>
                            </a>
                        </li>
                    </ul>
        
                </div>
            </div>
        </nav>   
        


        <div class="content">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><fmt:message key="products" /></div>
                                        <div></div>
                                    </div>
                                </div>
                            </div>
                            <a href="/shop/FrontController?command=to_products">
                                <div class="panel-footer">
                                    <span class="pull-left"><fmt:message key="view_details" /></span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-red">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-tasks fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><fmt:message key="categories" /></div>
                                        <div></div>
                                    </div>
                                </div>
                            </div>
                            <a href="/shop/FrontController?command=to_categories">
                                <div class="panel-footer">
                                    <span class="pull-left"><fmt:message key="view_details" /></span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-6">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-shopping-cart fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <div class="huge"><fmt:message key="orders" /></div>
                                        <div></div>
                                    </div>
                                </div>
                            </div>
                            <a href="/shop/FrontController?command=to_orders">
                                <div class="panel-footer">
                                    <span class="pull-left"><fmt:message key="view_details" /></span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="main"> 
                        <legend><strong ><fmt:message key="create_product" /></strong></legend>
                        <form name = "createProduct" action="FrontController" method="POST">
                            <!--<input type="hidden" name="command" value="create_product" />-->
                            <div class="field">
                                <label ><fmt:message key="entity_name" />:</label>
                                    <input type="text" name="product_name" placeholder="Name of product…">
                                    <span class="help-block"></span>
                            </div>
                            <div class="field">        
                                    <label ><fmt:message key="category" />:</label>
                                    <select name="category_id">
                                        <option selected><fmt:message key="select_category" /></option>
                                        <c:forEach items="${categoriesAdmin}" var="category">
                                            <option value="${category.getId()}">${category.getName()}</option>
                                        </c:forEach>
                                    </select>
                            </div>  
                            <div class="field">          
                                <label ><fmt:message key="description" />:</label>
                                    <textarea type="text" name="description" placeholder="Description of product…"></textarea>
                                    <span class="help-block"></span>
                            </div>    
                            <div class="field">     
                                <label ><fmt:message key="quantity" />:</label>
                                    <input type="text" name="quantity" placeholder="Quantity…">
                                    <span class="help-block"></span>
                            </div>   
                            <div class="field">             
                                <label ><fmt:message key="price" />:</label>
                                    <input type="text" name="price" placeholder="Price…">
                                    <span class="help-block"></span> 
                            </div>
                            <div class="field">        
                                <label ><fmt:message key="picture" />:</label>
                                    <input type="text" name="picture" placeholder="Picture…">
                                    <span class="help-block"></span>                         
                            </div>
                            <button class="btn btn-outline btn-default" type="submit" name="command" value="create_product">
                                <fmt:message key="create" />
                            </button>
                        </form>	
                    </div>                        
                </div>
                
            </div>
        </div>
    </div>
</div>


</body>

    <!--   Core JS Files   -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap-checkbox-radio.js"></script>

	<!--  Charts Plugin -->
	<script src="${pageContext.request.contextPath}/resources/assets/js/chartist.min.js"></script>

    <!--  Notifications Plugin    -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap-notify.js"></script>

    <!--  Google Maps Plugin    -->
    <script type="text/javascript" src="https://maps.googleapis.com/maps/api/js"></script>

    <!-- Paper Dashboard Core javascript and methods for Demo purpose -->
	<script src="${pageContext.request.contextPath}/resources/assets/js/paper-dashboard.js"></script>

	<!-- Paper Dashboard DEMO methods, don't include it in your project! -->
	<script src="${pageContext.request.contextPath}/resources/assets/js/demo.js"></script>	

</html>

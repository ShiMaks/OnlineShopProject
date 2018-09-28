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
                        <div class="container">
                            <legend><strong ><fmt:message key="update_product" /></strong></legend>
                                    
                            <form name="updateProduct" action="FrontController" method="POST">
                                    <input type="hidden" name="product_id" value = <c:out value="${product.getId()}"/>  
                                    <div class="field" style="margin: 0px auto; text-align: left;">
                                <table>  
                                    <tr> 
                                        <td align="right"><label><fmt:message key="entity_name" />:</label></td>
                                        <td align="left"><input type="text" name="product_name" value="<c:out value="${product.getName()}"/>"></td>
                                        <span class="help-block"></span>
                                        <c:if test="${not empty invalid_product_name}">                                    
                                            <div class="alert alert-danger" role="alert">
                                                <fmt:message key="${invalid_product_name}" />
                                            </div>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <td align="right"><label ><fmt:message key="category" />:</label></td>
                                        <td align="left"><select name="category_id">
                                            <option selected value="<c:out value="${product.getIdCategory()}"/>">${category.getName()}</option>
                                            <c:forEach items="${categoriesAdmin}" var="category">
                                                <option value="${category.getId()}">${category.getName()}</option>
                                            </c:forEach>
                                        </select></td>
                                    </tr>
                                    <tr>
                                        <td align="right"><label ><fmt:message key="description" />:</label></td>
                                        <td align="left"><textarea type="text" name="description" value="<c:out value="${product.getDescription()}"/>"></textarea></td>
                                        <span class="help-block"></span>
                                    </tr>
                                    <tr>
                                        <td align="right"><label ><fmt:message key="quantity" />:</label></td>
                                        <td align="left"><input type="text" name="quantity" value="<c:out value="${product.getQuantity()}"/>"></td>
                                        <span class="help-block"></span>
                                        <c:if test="${not empty invalid_quantity}">                                    
                                            <div class="alert alert-danger" role="alert">
                                                <fmt:message key="${invalid_quantity}" />
                                            </div>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <td align="right"><label ><fmt:message key="picture" />:</label></td>
                                        <td align="left"><input type="text" name="picture" value="<c:out value="${product.getPicture()}"/>"></td>
                                        <span class="help-block"></span>
                                        <c:if test="${not empty invalid_picture_path}">                                    
                                            <div class="alert alert-danger" role="alert">
                                                <fmt:message key="${invalid_picture_path}" />
                                            </div>
                                        </c:if>
                                    </tr>
                                    <tr>
                                        <td align="right"><label ><fmt:message key="price" />:</label></td>
                                        <td align="left"><input type="text" name="price" value="<c:out value="${product.getPrice()}"/>"></td>
                                        <span class="help-block"></span>
                                        <c:if test="${not empty invalid_product_price}">                                    
                                            <div class="alert alert-danger" role="alert">
                                                <fmt:message key="${invalid_product_price}" />
                                            </div>
                                        </c:if>
                                    </tr>
                                </table>
                               <button class="btn btn-outline btn-default" type="submit" name="command" value="update_product">
                                     <fmt:message key="update" />
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

<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="${sessionScope.locale}"/>
<fmt:setBundle basename="Resource"/>

<!DOCTYPE html>
<html>
<head>
    <title>Admin: List Products</title>
    <c:import url="/WEB-INF/pages/admin/head_admin.jsp" />
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

            <c:if test="${not empty info_message}">
                <div class="alert alert-success" role="alert">
                    <h4>
                        <strong>
                            <fmt:message key="${info_message}" />
                        </strong>
                    </h4>
                </div>
            </c:if>
            
           
            <div class="container-fluid">
                <div class="row">
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

                <c:if test="${message != null}">
                    <div class="alert alert-success" role="alert">
                        <h6><c:out value="${message}" /></h6>
                    </div>
                </c:if>

                <form action="FrontController" method="GET">
                    <button class="btn btn-outline btn-default" type="submit" name="command" value="prepare_create_product">
                        <fmt:message key="create_product" />
                    </button>
                </form>

                <div align="right">
                <form name="sortProduct" action="FrontController" method="GET">                        
                        <div class="field">                   
                        <label ><fmt:message key="sort_category" />:</label>
                            <select name="category_id">
                            <option selected><fmt:message key="select_category" /></option>
                                <c:forEach items="${listCategory}" var="category">
                                    <option value="${category.getId()}">${category.getName()}</option>
                                </c:forEach>
                            </select>
                            <span class="help-block"></span>                                         
                        <button class="btn btn-outline btn-default" type="submit" name="command" value="sort_product_by_category">
                            <fmt:message key="sort" />
                        </button>
                        </div>  
                </form>
                </div>
                <div class="content">
                        
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="card">
                                        <div class="header">
                                            <h4 class="title"><fmt:message key="products" /></h4>
                                            <p class="category"></p>
                                        </div>
                                        <div class="content table-responsive table-full-width">
                                            <table class="table table-striped">
                                                <thead>
                                                    <th>ID</th>
                                                    <th><fmt:message key="picture" /></th>
                                                    <th><fmt:message key="entity_name" /></th>
                                                    <th><fmt:message key="quantity" /></th>
                                                    <th><fmt:message key="price" /></th>
                                                    <th><fmt:message key="update" /></th>
                                                    <th><fmt:message key="delete" /></th>
                                                </thead>
                                                <tbody>
                                                <c:forEach items="${productsAdmin}" var="product" >
                                                    <tr>
                                                        <td>${product.getId()}</td>
                                                        <td><img src="${product.getPicture()}" width="190" height="220" alt="Product"></td>
                                                        <td>${product.getName()}</td>
                                                        <td>${product.getQuantity()}</td>
                                                        <td>${product.getPrice()}</td>
                                                        <td>
                                                            <form action="FrontController" method="GET">
                                                                <input type="hidden" name="product_id" value="${product.getId()}" />
                                                                <button class="btn btn-outline btn-default" type="submit" name="command" value="prepare_update_product">
                                                                    <fmt:message key="update" />
                                                                </button>
                                                            </form>
                                                        </td>
                                                        <td>
                                                            <form action="FrontController" method="POST">
                                                                <input type="hidden" name="product_id" value="${product.getId()}" />
                                                                <button class="btn btn-outline btn-default" type="submit" name="command" value="delete_product">
                                                                    <fmt:message key="delete" />
                                                                </button>
                                                            </form>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
            
                                        </div>
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

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/resources/assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Admin: Update order</title>

	<meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0' name='viewport' />
    <meta name="viewport" content="width=device-width" />


    <!-- Bootstrap core CSS     -->
    <link href="${pageContext.request.contextPath}/resources/assets/css/bootstrap.min.css" rel="stylesheet" />

    <!-- Animation library for notifications   -->
    <link href="${pageContext.request.contextPath}/resources/assets/css/animate.min.css" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/assets/css/sb-admin-2.css" rel="stylesheet"/>

    <!--  Paper Dashboard core CSS    -->
    <link href="${pageContext.request.contextPath}/resources/assets/css/paper-dashboard.css" rel="stylesheet"/>


    <!--  CSS for Demo Purpose, don't include it in your project     -->
    <link href="${pageContext.request.contextPath}/resources/assets/css/demo.css" rel="stylesheet" />


    <!--  Fonts and icons     -->
    <link href="http://maxcdn.bootstrapcdn.com/font-awesome/latest/css/font-awesome.min.css" rel="stylesheet">
    <link href='https://fonts.googleapis.com/css?family=Muli:400,300' rel='stylesheet' type='text/css'>
    <link href="${pageContext.request.contextPath}/resources/assets/css/themify-icons.css" rel="stylesheet">

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
                            <a class="navbar-brand" href="#">Admin</a>
                        </div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav navbar-right"> 
                                <li>
                                    <a href="/shop/FrontController?command=to_log_out">
                                        <i class="ti-settings"></i>
                                        <p>LogOut</p>
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
                                        <div class="huge">Products</div>
                                        <div></div>
                                    </div>
                                </div>
                            </div>
                            <a href="/shop/FrontController?command=to_products">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
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
                                        <div class="huge">Categories</div>
                                        <div></div>
                                    </div>
                                </div>
                            </div>
                            <a href="/shop/FrontController?command=to_categories">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
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
                                        <div class="huge">Orders</div>
                                        <div></div>
                                    </div>
                                </div>
                            </div>
                            <a href="/shop/FrontController?command=to_orders">
                                <div class="panel-footer">
                                    <span class="pull-left">View Details</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                   
                </div>
                <div class="row">   
                    <div class="main"> 
                        <legend><strong >Order Details:</strong></legend>
                        <div class="field">        
                              <label >Client Name:</label>
                                  <input type="text" name="name_client" disabled value="<c:out value="${user.getName()}"/>">
                                  <span class="help-block"></span>
                        </div>
                        <div class="field">        
                                <label >Client Last Name:</label>
                                    <input type="text" name="name_client" disabled value="<c:out value="${user.getSurname()}"/>">
                                    <span class="help-block"></span>
                        </div>
                        <div class="field">        
                                <label >Email:</label>
                                    <input type="text" name="name_client" disabled value="<c:out value="${user.getEmail()}"/>">
                                    <span class="help-block"></span>
                        </div>  
                        <div class="field">        
                                <label >Phone:</label>
                                    <input type="text" name="name_client" disabled value="<c:out value="${user.getPhone()}"/>">
                                    <span class="help-block"></span>
                        </div>  
                        <div class="field">          
                              <label >Date order:</label>
                                  <input type="text" name="date_order" disabled value="<c:out value="${order.getDataOrder()}"/>">
                                  <span class="help-block"></span>
                        </div>
                        <div class="field">          
                              <label >Cost:</label>
                                  <input type="text" name="order_cost" disabled value="<c:out value="${order.getOrderCost()}"/>">
                                  <span class="help-block"></span>
                        </div>       
                          <form name="updateOrder" action="FrontController" method="POST">
                                <input type="hidden" name="command" value="update_order" />
                                <input type="hidden" name="order_id" value = <c:out value="${order.getId()}"/>  
                            <div class="field">                   
                              <label >Status:</label>
                                    <select name="order_status">
                                        <option selected="selected" value="<c:out value="${order.getStatus()}"/>">${order.getStatus()}</option>
                                        <c:forEach items="<%= by.epam.shop.domain.OrderStatusEnum.values() %>" var="status">
                                            <option value="${status}">${status}</option>
                                        </c:forEach>
                                    </select> 
                                    <span class="help-block"></span>                                         
                               <input type="submit" class="btn btn-outline btn-default" value="Update status">
                            </div>  
                        </form>
                    </div>    	


                            <div class="content table-responsive table-full-width">
                                    <table class="table table-striped">
                                        <thead>
                                            <th>ID</th>
                                            <th>Picture</th>
                                            <th>Product Name</th>
                                            <th>Description</th>
                                            <th>Quantity</th>
                                            <th>Price</th>
                                        </thead>
                                        <tbody>
                                            <c:forEach items="${listProduct}" var="product">
                                            <tr>
                                                <td>${product.getId()}</td>
                                                <td><img src="${product.getPicture()}" width="190" height="220" alt="Product"></td>
                                                <td>${product.getName()}</td>
                                                <td>${product.getDescription()}</td>
                                                <td>${product.getQuantity()}</td>
                                                <td>${product.getPrice()}$</td>
                                                <td></td>
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


</body>

    <!--   Core JS Files   -->
    <script src="${pageContext.request.contextPath}/resources/assets/js/jquery-1.10.2.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/assets/js/bootstrap.min.js" type="text/javascript"></script>

	<!--  Checkbox, Radio & Switch Plugins -->
	<script src="${pageContext.request.contextPath}resources/assets/js/bootstrap-checkbox-radio.js"></script>

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

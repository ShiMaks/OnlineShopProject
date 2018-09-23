<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8" />
	<link rel="apple-touch-icon" sizes="76x76" href="${pageContext.request.contextPath}/resources/assets/img/apple-icon.png">
	<link rel="icon" type="image/png" sizes="96x96" href="${pageContext.request.contextPath}/resources/assets/img/favicon.png">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />

	<title>Admin: Products</title>

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

                <form action="FrontController" method="GET">
                    <input type="hidden" name="command" value="prepare_create_product" />
                    <input type="submit" value="Create Product" class="btn btn-outline btn-default"/>
                </form>

                <div class="content">
                        
                            <div class="row">
                                <div class="col-md-12">
                                    <div class="card">
                                        <div class="header">
                                            <h4 class="title">Products</h4>
                                            <p class="category"></p>
                                        </div>
                                        <div class="content table-responsive table-full-width">
                                            <table class="table table-striped">
                                                <thead>
                                                    <th>ID</th>
                                                    <th>Picture</th>
                                                    <th>Name</th>
                                                    <th>Quantity</th>
                                                    <th>Price</th>
                                                    <th>Update</th>
                                                    <th>Delete</th>
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
                                                                <input type="hidden" name="command" value="prepare_update_product" />
                                                                <input type="hidden" name="product_id" value="${product.getId()}" />
                                                                <input type="submit" value="Update" class="btn btn-outline btn-default"/>
                                                            </form>
                                                        </td>
                                                        <td>
                                                            <form action="FrontController" method="POST">
                                                                <input type="hidden" name="command" value="delete_product" />
                                                                <input type="hidden" name="product_id" value="${product.getId()}" />
                                                                <input type="submit" value="Delete" class="btn btn-outline btn-default"/>
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

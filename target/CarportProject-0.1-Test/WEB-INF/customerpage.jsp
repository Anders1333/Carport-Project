<%-- 
    Document   : customerpage
    Created on : 24, 2017, 11:05:12 am
    Author     : AndersHC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Customer home page</title>

        <link href="./css/stylesheet.css" rel="stylesheet" type="text/css"/>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library --> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


    </head>
    <body>
        <nav class="container-fluid fogNavbar navbar-default">
            <div class="navbar-header" style="margin-right: 10px;">
                <a class="navbar-brand">FOG</a>
                <a class="navbar-brand registerTradeMark">®</a>
            </div>
            <div class="navbar-header">
                <a class="navbar-brand">Customer Page</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a href="./index.jsp" class="tabNavButton">Home</a></li>
                <li><a class="tabNavButton">Build Carport</a></li>
            </ul>
        </nav>
        <div class="container-fluid h100">
            <div class="row">
                <!-- This is the left div in the row -->
                <div class="col-sm-12">
                    <h1>Hello <%= request.getParameter("username")%> </h1>
                    <a href="./inputpage.jsp">Input page</a>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

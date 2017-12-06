<%-- 
    Document   : customerorderspage
    Created on : 22-11-2017, 11:11:05
    Author     : AndersHC
--%>

<%@page import="FunctionLayer.Order"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <%
            ArrayList<Order> orderList = (ArrayList<Order>) request.getAttribute("orderList");
        %>
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
            <div class="navbar-header" style="margin-right: 10px;">
                <a class="navbar-brand">Employee Page</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a class="tabNavButton" onclick="goBack()">Gå tilbage</a></li>
            </ul>

            <ul class="nav navbar-nav" style="float: right">
                <li><a href="./index.jsp" class="tabNavButton">Home</a></li>
            </ul>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <!-- This is the left div in the row -->
                <div class="col-sm-12">
                    <div clss="userSelectorBox">
                        <div class="userSelectorBoxButtons">
                            <ul>
                                <% for (int i = 0; i < orderList.size(); i++) {%>
                                <li>
                                    <form name = "getOrders" action="FrontController" method="POST">
                                        <button type = "submit" >
                                            <%=orderList.get(i)%>
                                            <input type="hidden" name="command" value="packList">
                                            <input type ="hidden" name="orderId" value=<%=orderList.get(i).getId()%>>
                                        </button>
                                    </form>
                                </li>
                                <%}%>   
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div>
            <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
            <script src="./js/empfaderjs.js" type="text/javascript"></script>
            <script>
                function goBack() {
                    window.history.back();
                }
            </script>
        </div>
    </div>
</body>
</html>

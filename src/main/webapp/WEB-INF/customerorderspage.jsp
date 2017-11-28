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
    </head>
    <body>
        <h1>Hello <%=request.getParameter("username")%> </h1>
        <p>This is the employee-page</p>
        
        <br>
        
        <div class="navigationBar">
            <h4>Click an order to get the order details.</h4>
            <ul>
                <hr>
                <li class="showButton" onClick="window.history.back()">GO BACK</li>
                    <li class="showButton" onClick="window.location.reload()">REFRESH</li>
                <hr>
            </ul>
        </div>
        <div id="allUsersDiv">
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
                <br>
                <%}%>   
            </ul>
        </div>

    </body>
</html>

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
            ArrayList<Order> orderList = (ArrayList<Order>)session.getAttribute("orderList");
        %>

    </head>
    <body>
        <h1>Hello World!</h1>

        <ul>
            <% for (int i = 0; i < orderList.size(); i++) {%>
            <li>


                <%=orderList.get(i)%>


            </li>
            <br>
            <%}%>   
        </ul>
    </body>
</html>

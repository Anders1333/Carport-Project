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
            ArrayList<Order> orderList = (ArrayList<Order>)request.getAttribute("orderList");
        %>

    </head>
    <body>
        <h1>Hello World!</h1>

           <ul>
            <% for (int i = 0; i < orderList.size(); i++) {%>
            <li>
                <form name = "getOrders" action="FrontController" method="POST">
                
                    <%=orderList.get(i)%>   <input type = "submit" value ="Show Packlist">
                    <input type="hidden" name="command" value="packList">
                    <input type ="hidden" name="orderId" value=<%=orderList.get(i).getId()%>>
                </form>
            </li>
            <br>
            <%}%>   
        </ul>
        <br>
    </body>
</html>

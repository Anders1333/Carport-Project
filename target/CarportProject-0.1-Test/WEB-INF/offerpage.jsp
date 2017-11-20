<%-- 
    Document   : offerpage
    Created on : 17-11-2017, 11:59:06
    Author     : AndersHC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>The total price is:</h1>
        <%= session.getAttribute("totalprice")%>
    </body>
</html>

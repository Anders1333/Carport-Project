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
    </head>
    <body>
      
        <h1>Welcome <%=request.getParameter( "username" )%> </h1>
        
        
        <a href="./inputpage.jsp">Input page</a>
        
        
    </body>
</html>

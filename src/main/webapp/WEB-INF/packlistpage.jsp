<%-- 
    Document   : packlistpage
    Created on : 22-11-2017, 12:55:00
    Author     : AndersHC
--%>

<%@page import="FunctionLayer.Carport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
             <% Carport carport = (Carport) request.getAttribute("packList");%>
    </head>
    <body>
        <h1>The total price is:</h1>
        <%= request.getAttribute("totalPrice")%>
        <h3>This will be a packList (stykliste)</h3>
        
        <p>
            
        RoofArea: <br>
        <%=carport.getRoofArea()%> m2
        <Br>
        verticalPoles:<br>
        <%=carport.getVerticalPoles()%> stk
        <br>
        horizontalPoles
        <%=carport.getHorizontalPoles()%> stk
        </p>
        
     
    
        
    </body>
</html>

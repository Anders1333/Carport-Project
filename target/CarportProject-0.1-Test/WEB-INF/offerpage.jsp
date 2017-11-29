<%-- 
    Document   : offerpage
    Created on : 17-11-2017, 11:59:06
    Author     : AndersHC
--%>

<%@page import="FunctionLayer.Carport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <% Carport carport = (Carport) request.getAttribute("carport");%>
        
        
    </head>
    <body>
        <h1>The total price is:</h1>
        
        
        Ønsker du at gemme dette tilbud?
        <form name="gemtilbud" action="FrontController"
        
        
        
        <br>
        
        
        
        
        HERE GOES YOUR PRICE
        <%= carport.getTotalPrice() %> DKK
        
        
        <br>
        HERE GOES YOUR DRAWING
        <br>
        <br>
        CARPORT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        <br>
        <%=carport.getShedDepth()%>
        

        
        <br>
       <!-- Carport drawing html (TOPDOWN)-->  
   <%
   int VerticalPolesNumber = carport.getVerticalPoles()/2;
   int width = carport.getWidth();
   int length = carport.getLength(); %>
   
    <svg width="1000" height="1000" viewBox="0 0 1000 1000"> 
   
   <!-- Placing Poles ( Width, carport.getVerticalPoles  -->
   <rect x="0" y ="0" stroke-width ="1px" width="10" height="10" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="0" y ="<%=length-10%>" stroke-width ="1px" width="10" height ="10" style="stroke:#000000; fill:#ffffff"></rect>"
   <% for ( int i = 1; i < VerticalPolesNumber ; i++){%>
   <% int offset = i*195;%>
   <rect x="<%=offset%>" y="0" stroke-width="1px" width="10" height="10" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="<%=offset%>" y="<%=width-10%>" stroke-width="1px" width="10" height="10" style="stroke:#000000; fill:#ffffff"></rect>
   <%}%>
   
   
     <!-- Placing Horizontals -->
   <rect x="0" y="0" stroke-width ="1px" width="<%=length%>" height="5" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="0" y="<%= width-5%>" stroke-width="1px" width="<%=length%>" height="5" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
   
   <rect x="0" y="5" stroke-width ="1px" width="5" height="<%=width-10%>" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="<%=length-5%>" y="5" stroke-width ="1px" width="5" height="<%=width-10%>" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>












        </svg>   
    </body>
</html>

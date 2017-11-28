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
        <% double totalPrice = (double) request.getAttribute("totalPrice"); %>
        
        
    </head>
    <body>
        <h1>The total price is:</h1>

        HERE GOES YOUR PRICE
        <%= totalPrice%> DKK
        
        
        <br>
        HERE GOES YOUR DRAWING
        <br>
        <br>

        
        <br>
       <!-- Carport drawing html (TOPDOWN)-->  
   <%
   int VerticalPolesNumber = carport.getVerticalPoles()/2;
   int width = carport.getWidth();
   int length = carport.getLength(); 
   int numberOfRafters = carport.getLength()/55;
   int height = carport.getHeight();
   %>
   
    <svg width="1000" height="1000" viewBox="0 0 1000 1000"> 
   
   <!-- Placing Poles ( Width, carport.getVerticalPoles  -->
   <rect x="0" y ="0" stroke-width ="2px" width="10" height="10" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="0" y ="<%=width-10%>" stroke-width ="2px" width="10" height ="10" style="stroke:#000000; fill:#ffffff"></rect>"
   <% for ( int i = 1; i < VerticalPolesNumber-1 ; i++){%>
   <% int offset = i*195;%>
   <rect x="<%=offset%>" y="0" stroke-width="2px" width="10" height="10" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="<%=offset%>" y="<%=width-10%>" stroke-width="2px" width="10" height="10" style="stroke:#000000; fill:#ffffff"></rect>
   <%}%>
   <rect x="<%=length - 10%>" y="0" stroke-width="2px" width="10" height="10" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="<%=length - 10%>" y="<%=width-10%>" stroke-width="2px" width="10" height="10" style="stroke:#000000; fill:#ffffff"></rect>
   
   
     <!-- Placing Horizontals (rim) -->
   <rect x="0" y="0" stroke-width ="1px" width="<%=length%>" height="5" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="0" y="<%= width-5%>" stroke-width="1px" width="<%=length%>" height="5" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
   
   <rect x="0" y="5" stroke-width ="1px" width="5" height="<%=width-10%>" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="<%=length-5%>" y="5" stroke-width ="1px" width="5" height="<%=width-10%>" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>

   
    <!-- Placing Horizontals (Rafters) -->
    <rect x="55" y="0" stroke-width="1px" width="3" height="<%=width%>" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
    <% for ( int i = 2; i <= numberOfRafters; i++) {%>
    <% int offset = i*55;%>
    <rect x="<%=offset%>" y="0" stroke-width="1px" width="3" height="<%=width%>" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
    <%}%> 

    <!-- Placing Cross Stabilizer beams -->
    <line x1="55" y1="0" x2="<%=(numberOfRafters)*55%>" y2="<%=width%>" style="stroke:rgb(80,80,80);stroke-width:2" />
    <line x1="55" y1="<%=width%>" x2="<%=(numberOfRafters)*55%>" y2="0" style="stroke:rgb(80,80,80);stroke-width:2" />
</svg> 

<br>


<!--------------------------------------SideView---------------------------------------------->
<svg width="1000" height="1000" viewBox="0 0 1000 1000"> 
<!-- Placing Poles -->
<rect x="0" y ="20" stroke-width ="2px" width="10" height="<%=height - 20%>" style="stroke:#000000; fill:#ffffff"></rect>
   <% for ( int i = 1; i < VerticalPolesNumber-1 ; i++){%>
   <% int offset = i*195;%>
   <rect x="<%=offset%>" y="20" stroke-width="2px" width="10" height="<%=height - 20%>" style="stroke:#000000; fill:#ffffff"></rect>
   <%}%>
   <rect x="<%=length - 10%>" y="20" stroke-width="2px" width="10" height="<%=height -20%>" style="stroke:#000000; fill:#ffffff"></rect>
<!-- Placing Rims -->
<rect x="0" y="0" stroke-width ="1px" width="<%=length%>" height="20" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>

   
    </body>
</html>

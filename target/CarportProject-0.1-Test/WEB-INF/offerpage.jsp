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
  
   <rect x="80" y="25" stroke-width="2px" width="10" height="10" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="80" y="<%=width-35%>" stroke-width="2px" width="10" height="10" style="stroke:#000000; fill:#ffffff"></rect>
   <% for ( int i = 280; i < length ; i+=200){%>
  
   <rect x="<%=i%>" y="25" stroke-width="2px" width="10" height="10" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="<%=i%>" y="<%=width-35%>" stroke-width="2px" width="10" height="10" style="stroke:#000000; fill:#ffffff"></rect>
   <%}%>
  
   <!-- Placing crossbeams-->
   <rect x="5" y="25" stroke-width="2px" width="<%=length-5%>" height="5" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="5" y="<%=width-30%>" stroke-width="2px" width="<%=length-5%>" height="5" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
   
   
   
     <!-- Placing Horizontals (rim) -->
   <rect x="5" y="0" stroke-width ="1px" width="<%=length-5%>" height="2.5" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="5" y="<%= width-2.5%>" stroke-width="1px" width="<%=length-5%>" height="2.5" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
   
   <rect x="0" y="0" stroke-width ="1px" width="5" height="<%=width%>" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
   <rect x="<%=length%>" y="0" stroke-width ="1px" width="5" height="<%=width%>" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>

   
    <!-- Placing Horizontals (Rafters) -->
    <rect x="55" y="0" stroke-width="1px" width="3" height="<%=width%>" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
    <% for ( int i = 2; i <= numberOfRafters; i++) {%>
    <% int offset = i*55;%>
    <rect x="<%=offset%>" y="0" stroke-width="1px" width="3" height="<%=width%>" fill-opacity="0.0" style="stroke:#000000; fill:#ffffff"></rect>
    <%}%> 

    <!-- Placing Cross Stabilizer beams -->
    <line x1="55" y1="0" x2="<%=(numberOfRafters)*55%>" y2="<%=width%>" style="stroke:rgb(80,80,80);stroke-width:2" />
    <line x1="55" y1="<%=width%>" x2="<%=(numberOfRafters)*55%>" y2="0" style="stroke:rgb(80,80,80);stroke-width:2" />
    
    <!-- Placing measuring lines -->
    <line x1="5" y1="<%=width+20%>" x2="<%=length%>" y2="<%=width+20%>" style="stroke:rgb(80,80,80);stroke-width:2" />
    <line x1="5" y1="<%=width+10%>" x2="5" y2="<%=width+30%>" style="stroke:rgb(80,80,80);stroke-width:2" />
    <line x1="<%=length%>" y1="<%=width+10%>" x2="<%=length%>" y2="<%=width+30%>" style="stroke:rgb(80,80,80);stroke-width:2" />
    
    <line x1="<%=length+30%>" y1="0" x2="<%=length+30%>" y2="<%=width%>" style="stroke:rgb(80,80,80);stroke-width:2" />
    <line x1="<%=length+20%>" y1="0" x2="<%=length+40%>" y2="0" style="stroke:rgb(80,80,80);stroke-width:2" />
    <line x1="<%=length+20%>" y1="<%=width%>" x2="<%=length+40%>" y2="<%=width%>" style="stroke:rgb(80,80,80);stroke-width:2" />
    
    <!-- Placing numbers -->
    <text x="<%=(length/2)-40%>" y="<%=width+50%>" font-family="sans-serif" font-size="15px"><%=length%> cm</text>
    <text x="<%=length + 50%>" y="<%=width/2%>" font-family="sans-serif" font-size="15px"><%=height%> cm</text>
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
</svg>


<!-------------------------- Rooftiles --------------------------------------------->
<svg width="1000" height="1000" viewBox="0 0 1000 1000"> 

 <!-- Rooftiles test -->
    
    <% for ( int i = 0; i < length ; i += 25){%>
<rect x="<%=i%>" y="0" stroke-width ="1px" width="30" height="40" fill-opacity="0.0" style="stroke:#FE2E2E; fill:#ffffff"></rect>
     <% for ( int j = 35; j < width ; j += 35) {%>
     <rect x="<%=i%>" y="<%=j%>" stroke-width="1px" width="30" height="40" fill-opacity="0.0" style="stroke:#FE2E2E; fill:#ffffff"></rect>
   <%}%>
   <%}%>
   
  
   
   
   
   

  
</svg>
   
    </body>
</html>

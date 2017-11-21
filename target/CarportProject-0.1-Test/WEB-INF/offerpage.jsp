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
  
        
   <svg width="1000" height="1000" viewBox="0 0 10000 10000"> 
                  <rect x="1000" y="1000" stroke-width="20px" width="2000" height="1000" style="stroke:#000000; fill:#ffffff"></rect>
<line x1="1000" y1="1000" y2="500" style="stroke:#000000; stroke-width:20" x2="2000"></line>
<line style="stroke:#000000; stroke-width:20" x1="2000" y1="500" y2="1000" x2="3000"></line>
<rect stroke-width="20px" style="stroke:#000000; fill:#ffffff" y="1500" width="300" height="500" x="1850"></rect>
<rect stroke-width="20px" style="stroke:#000000; fill:#ffffff" width="300" y="1200" height="300" x="2400"></rect>
<rect stroke-width="20px" style="stroke:#000000; fill:#ffffff" width="300" y="1200" height="300" x="1300"></rect>




                  
                  
                  
                  
                  
                  
                   
                    
                  
                  
                  
                  
</svg>   
    </body>
</html>

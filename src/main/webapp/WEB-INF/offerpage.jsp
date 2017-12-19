<%-- 
    Document   : offerpage
    Created on : 17-11-2017, 11:59:06
    Author     : AndersHC
--%>

<%@page import="FunctionLayer.CarportDrawer"%>
<%@page import="FunctionLayer.CarportCalculator"%>
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
       

        
        <h2> Pris for carport : <%= request.getAttribute("price") %> </h2>

       



        <br>

    <svg width= "60%" viewBox="0 0 <%=carport.getLength()+150%> <%=carport.getWidth()+90%>">
        <%= CarportDrawer.createDrawing1(carport)%>
        </svg>
    <svg width= "60%" viewBox="0 0 <%=carport.getLength()+150%> <%=carport.getWidth()+90%>">
        <%= CarportDrawer.createDrawing2(carport)%>
        </svg>
        <svg width= "50%" viewBox="0 0 <%=carport.getLength()*1.5%> <%=carport.getHeight()*2.5%>">
        <%= CarportDrawer.createDrawing3(carport)%>
        </svg>

        <h3>Har du spørgsmål eller ønsker? Kontakt vores eksperter: 44556677</h3>
        
        <h3>Hvis du ønsker denne carport, indtast venligst leverings-addresse:</h3>
        <br>
               
        <form  name="placeOrder" action="FrontController" method="POST">
            <input type="hidden" name="command" value="placeOrder">
            <input type="text" name="street" placeholder="Vejnavn"><br>
            <input type="text" name="streetNr" placeholder="VejNr"><br>
            <input type="text" name="floor" placeholder="Etage"><br>
            <input type="text" name="city" placeholder="By"><br>
            <input type="text" name="zip" placeholder="PostNr"><br>
            <input type="text" name="country" placeholder="Land"><br>
            <input type="submit" value="Bestil">
        </form>

    </body>
</html>

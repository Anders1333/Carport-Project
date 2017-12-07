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
        <h1>The total price is:</h1>

        

        
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
        
        
        
        
        
        
        
        <form name="gemtilbud" action="FrontController">


        </form>



        <form name="gemtilbud" action="FrontController"></form>



        <br>




        HERE GOES YOUR PRICE


        <br>
        HERE GOES YOUR DRAWING
        <br>
        <br>
        CARPORT !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        <br>
        <%=carport.getShedDepth()%>



        <br>

    <svg width= "<%=carport.getLength()+20%>" height="<%=carport.getWidth()+20%>" viewBox="0 0 <%=carport.getLength()+20%> <%=carport.getWidth()+20%>">
        <%= CarportDrawer.createDrawing1(carport)%>
        </svg>
    <svg width= "<%=carport.getLength()+20%>" height="<%=carport.getWidth()+20%>" viewBox="0 0 <%=carport.getLength()+20%> <%=carport.getWidth()+20%>">
        <%= CarportDrawer.createDrawing2(carport)%>
        </svg>


    </body>
</html>

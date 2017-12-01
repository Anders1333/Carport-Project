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
        <form name="gemtilbud" action="FrontController">


        </form>



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
    </body>
</html>

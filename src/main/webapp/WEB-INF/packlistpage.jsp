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

        <% Carport carport = (Carport) request.getAttribute("carport");%>

    </head>
    <body>
        <h1>The total price is:</h1>
        <h3>This will be a packList (stykliste)</h3>

        <table width="500" style="text-align: left">
            <tbody><tr>
                    <th>Træ</th>
                    <th>Længde</th>
                    <th>Antal</th>
                    <th>Unit</th>
                    <th>Info</th>
                </tr>
                <tr>
                    <td>Eg</td>
                    <td>480cm</td>
                    <td> <%=carport.getInclineSheets() %></td>
                    <td>stk.</td>
                    <td>Vindskede til rejsning</td>
                </tr>
            </tbody>
        </table>





    </body>
</html>

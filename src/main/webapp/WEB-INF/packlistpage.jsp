<%-- 
    Document   : packlistpage
    Created on : 22-11-2017, 12:55:00
    Author     : AndersHC
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.PacklistObject"%>
<%@page import="FunctionLayer.Carport"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>


        <% ArrayList<PacklistObject> packlist = (ArrayList<PacklistObject>) request.getAttribute("packlist"); %>


        s

        <style>
            table, th, td {
                border: 1px solid black;
                border-collapse: collapse;
            }

        </style>
    </head>
    <body>
        <h1>The total price is:</h1>
        <h3>This will be a packList (stykliste)</h3>

        <table width="2000">
            <tbody><tr>
                    <th>Træ</th>
                    <th>Længde</th>
                    <th>Antal</th>
                    <th>Info</th>
                </tr>
                <% for (int i = 0; i < packlist.size(); i++) {%>
                <tr>
                    <td><%=packlist.get(i).getName()%></td>
                    <td><%= packlist.get(i).getLength()%></td>
                    <td> <%= packlist.get(i).getAmount()%></td>
                    <td><%= packlist.get(i).getDescription()%></td>
                </tr>

                <%}%>






            </tbody>




        </table>





    </body>
</html>

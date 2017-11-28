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

        <table width="1000">
            <tbody><tr>
                    <th>Træ</th>
                    <th>Længde</th>
                    <th>Antal</th>
                    <th>Unit</th>
                    <th>Info</th>
                </tr>
                <tr>
                    <td>25x150 mm. trykimp Bræt</td>
                    <td>480cm</td>
                    <td> <%=carport.getInclineSheets()%></td>
                    <td>stk.</td>
                    <td>Vindskede på rejsning</td>
                </tr>
                <tr>
                    <td>25x150 mm. trykimp. Bræt</td>
                    <td>600</td>
                    <td> <%=carport.getSternPalnksCarport()%></td>
                    <td>stk.</td>
                    <td>Sternbrædder til siderne Carport del</td>
                </tr>
                <tr>
                    <td>Byg selv spær</td>
                    <td></td>
                    <td> 1</td>
                    <td>sæt</td>
                    <td>Byg selv spær (skal samles) 8 stk</td>
                </tr>    
                <tr>
                    <td>97x97 mm. trykimp. Stolpe</td>
                    <td>300cm</td>
                    <td> <%=carport.getVerticalPoles()%></td>
                    <td>stk.</td>
                    <td>Stolper nedgraves 90 cm. i jord + skråstiver</td>
                </tr>    
                <tr>
                    <td>45x195 mm. spærtræ ubh</td>
                    <td>480cm</td>
                    <td> <%=carport.getHorizontalPolesLength() + carport.getHorizontalPolesWidth()%></td>
                    <td>stk.</td>
                    <td>Remme i sider, sadles ned i stolper Carport Del</td>
                </tr>    
                <tr>
                    <td>10x10 cm tagsten</td>
                    <td></td>
                    <td> <%=carport.getRoofMeterial()%></td>
                    <td>stk.</td>
                    <td>Tagsten til tag</td>
                </tr>





            </tbody>




        </table>


        <br>
        <br>
        <br>
        <%if (carport.getShedDepth() > 0) {%>
        <table width="1000">
            <tbody><tr>
                    <th>Træ</th>
                    <th>Længde</th>
                    <th>Antal</th>
                    <th>Unit</th>
                    <th>Info</th>
                </tr>
                <tr>
                    <td>97x97 mm.  trykimp. Stolpe</td>
                    <td>300cm</td>
                    <td> <%=carport.getShedPoles()%></td>
                    <td>stk.</td>
                    <td>Stolper nedgraves 90 cm. i jord + skråstiver(skur)</td>
                </tr>
                <tr>
                    <td>45x195 mm. spærtræ ubh.</td>
                    <td>480</td>
                    <td> <%=carport.getShedFrames()%></td>
                    <td>stk.</td>
                    <td>Rimme i sidder, sadles ned i stolper(skur)</td>
                </tr>


            </tbody>




        </table>
        <%}%>




    </body>
</html>

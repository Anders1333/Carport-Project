<%-- 
    Document   : inputpage
    Created on : 17-11-2017, 11:58:48
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
        <h1>Input your measurements here:</h1>
        
            <form name="buildCarport" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="buildCarport">
                        Length in: cm<br>
                        <input type="number" name="length" placeholder ="cm">
                        <br>
                        Width in: cm<br>
                        <input type="number" name="width" placeholder="cm">
                        <br>
                        Height in: cm<br>
                        <input type="number" name="height" placeholder="cm">
                        <br>
                        Taghældning i: grader
                        <input type="number" name="degree" placeholder="i grader">
                        <br>
                        Skur:
                        <input id='skur' type="checkbox" name="toolshed" value="1" >
                        <input id='skurhidden' type="hidden" name="toolshed" value="0" >
                        <br>
                        Dybte in: cm
                        <input type="number" name="depth" placeholder="cm">
                        <br>                           
                        <input type="submit" value="Submit">
                        
                    </form>
    </body>
</html>

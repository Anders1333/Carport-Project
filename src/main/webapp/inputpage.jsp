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
                        <input type="submit" value="Submit">
                    </form>
    </body>
</html>

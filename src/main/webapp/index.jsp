<%-- 
    Document   : index
    Created on : 14-11-2017, 10:34:17
    Author     : AndersHC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
    </head>
    <body>
        <h1>Main page</h1>
        
        <table>
            <tr><td>Login</td>
                <td>
                    <form name="login" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="login">
                        Username:<br>
                        <input type="text" name="username" placeholder ="Username">
                        <br>
                        Password:<br>
                        <input type="password" name="password" placeholder="Password">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
                <td>Or Register</td>
                <td>
                    <form name="register" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="register">
                        Username:<br>
                        <input type="text" name="username" placeholder="Username">
                        <br>
                        Email:<br>
                        <input type="text" name="email" placeholder="Email">
                        <br>
                        Phone:<br>
                        <input type="text" name="phone" placeholder="Phone">
                        <br>
                        Password:<br>
                        <input type="password" name="password1" placeholder="Password">
                        <br>
                        Retype Password:<br>
                        <input type="password" name="password2" placeholder="Retype Password">
                        <br>
                        <input type="submit" value="Submit">
                    </form>
                </td>
            </tr>
            
                 
            
            
            
        </table>
        <% String error = (String) request.getAttribute( "error");
           if ( error != null) { %>
           <H2>Error!!</h2>
           <p><%= error %>
        <% }
        %>
    </body>
</html>

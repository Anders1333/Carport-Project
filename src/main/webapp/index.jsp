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
        <link href="css/stylesheet.css" rel="stylesheet" type="text/css"/>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Homepage</title>
    </head>

    <body>        
        <!-- Navigation Bar -->
        <nav class="container-fluid fogNavbar navbar-default">
            <div class="">
                <div class="navbar-header" style="margin-right: 10px;">
                    <a class="navbar-brand">Frontpage</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="#">Home</a></li>
                    <li><a href="#">Page 1</a></li>
                    <li><a href="#">Page 2</a></li>
                    <li><a href="#">Page 3</a></li>
                </ul>
            </div>
        </nav>

        <div class="container-fluid " style="margin-top: 20px;">
            <div class="loginRegisterBox">
                <div class="btn-group btn-group-justified" role="group" aria-label="...">
                    <div class="btn-group clearBtn fader" role="group">
                        <button data-target="login" type="button " class="loginRegisterButton btn br-1-w">Login</button>
                    </div>
                    <div class="btn-group clearBtn fader" role="group">
                        <button data-target="register" type="button" class="btn loginRegisterButton bl-1-w">Register</button>
                    </div>
                </div>
                <div class="loginRegisterContainer">
                    <div class="tab2-c tab" id="login" style="display: block;">
                        <form  name="login" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="login">
                            <div class="form-group">
                                <label>Username:</label>
                                <input name="username" class="form-control" type="text" name="username" placeholder ="Username">
                            </div>
                            <div class="form-group">
                                <label>Password:</label>
                                <input class="form-control" type="password" name="password" placeholder="Password">
                            </div>
                            <button type="submit" value="submit" class="btn btn-default">Login</button>
                            <a style="float: right;" class="btn btn-default" href="inputpage.jsp">Login as Guest</a>
                        </form>
                    </div>
                    <div class="tab2-c tab" id="register">
                        <form  name="register" action="FrontController" method="POST">                                
                            <input type="hidden" name="command" value="register">
                            <div class="form-group">
                                <label>Username:</label>
                                <input class="form-control" type="text" name="username" placeholder="Username">
                            </div>

                            <div class="form-group">
                                <label>Email:</label>
                                <input class="form-control" type="text" name="email" placeholder="Email">
                            </div>

                            <div class="form-group">
                                <label>Phone:</label>
                                <input class="form-control" type="text" name="phone" placeholder="Phone">
                            </div>

                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" type="text" name="password1" placeholder="Password">
                            </div>

                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" type="text" name="password2" placeholder="Retype Password">
                            </div>
                            <button type="submit" value="submit" class="btn btn-default">Register</button>
                        </form>
                    </div>
                </div>
            </div>
            <div id="errorMessage   ">
                <% String error = (String) request.getAttribute("error");
                                if (error != null) {%>
                <p><strong>Error!!</strong></p>
                <p><%= error%><% }
                    %>


            </div>

            <!--<div id="errorMessage" class="alert alert-danger alert-dismissable">
                <a href="#" class="close" data-dismiss="alert" aria-label="close">×</a>
            </div>->

            <div id="errorMessage" class="alert alert-dismissable"> 
            </div>
            
            -->


            <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
            <script src="js/loginregisterfader.js" type="text/javascript"></script>
            <script type="text/javascript">
                $(document).ready(function () {
                    if ($("#errorMessage").text().length > 0) {
                        $('#errorMessage').hide();
                    }
                });
            </script>
        </div>
    </body>
</html>

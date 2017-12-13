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
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library -->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script type="text/javascript" src="//code.jquery.com/jquery-2.1.3.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>        
        <link href="css/stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>Homepage</title>
    </head>

    <body>        
        <!-- Navigation Bar -->
        <nav class="container-fluid fogNavbar navbar-default">
            <div class="navbar-header" style="margin-right: 10px;">
                <a class="navbar-brand">FOG</a>
                <a class="navbar-brand registerTradeMark">®</a>
            </div>
            <div class="navbar-header" style="margin-right: 10px;">
                <a class="navbar-brand">Frontpage</a>
            </div>

            <ul class="nav navbar-nav">
                <li><a href="index.jsp" class="tabNavButton">Home</a></li>
                <li><a href="contactPage.jsp" target="_blank" class="tabNavButton">KONTAKT OS</a></li>
            </ul>
        </nav>

        <div class="container-fluid">
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
                                <label>Brugernavn:</label>
                                <input name="username" class="form-control" type="text" name="username" placeholder ="Username" minlength="1" maxlength="45"  required>
                            </div>
                            <div class="form-group">
                                <label>Password:</label>
                                <input class="form-control" type="password" name="password" placeholder="Password" minlength="1" maxlength="45" required>
                            </div>
                            <button type="submit" value="submit" class="btn btn-default">Login</button>
                            <a style="float: right;" class="btn btn-default" href="inputpage.jsp">Fortsæt som gæst</a>
                        </form>
                    </div>
                    <div class="tab2-c tab" id="register">
                        <form  name="register" action="FrontController" method="POST">                                
                            <input type="hidden" name="command" value="register">
                            <div class="form-group">
                                <label>Brugernavn:</label>
                                <input class="form-control" type="text" name="username" placeholder="Username" minlength="1" maxlength="45" required>
                            </div>

                            <div class="form-group">
                                <label>Email:</label>
                                <input class="form-control" type="email" name="email" placeholder="Email" minlength="1" maxlength="45" required>
                            </div>

                            <div class="form-group">
                                <label>Tlf Nr:</label>
                                <input class="form-control" type="number" name="phone" placeholder="Phone" minlength="1" maxlength="45" required>
                            </div>

                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" type="password" name="password1" placeholder="Password" minlength="1" maxlength="45" required>
                            </div>

                            <div class="form-group">
                                <label>Password</label>
                                <input class="form-control" type="password" name="password2" placeholder="Retype Password" minlength="1" maxlength="45" required>
                            </div>
                            <button type="submit" value="submit" class="btn btn-default">Register</button>
                        </form>
                    </div>
                </div>
            </div>

            <div class="errorMessage alert alert-dismissable">
                <a style="right: 0 !important" href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
                <% String error = (String) request.getAttribute("error");
                    if (error != null) {%>
                <p><strong>Error!!</strong></p>
                <p><%= error%><% }%></p>
            </div>


            <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
            <script src="js/loginregisterfader.js" type="text/javascript"></script>

            <script>
                $(document).ready(function () {
                    $('.errorMessage').filter(function () {
                        return $.trim($(this).text()).length <= 2
                    }).hide()
                });
            </script>
        </div>
    </body>
</html>

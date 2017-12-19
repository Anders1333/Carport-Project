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
        <title>Customer home page</title>
        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <!-- jQuery library --> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <link href="./css/stylesheet.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
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
            </ul>
        </nav>
        <div class="container-fluid">
            <div class="loginRegisterBox">
                <div class="btn-group btn-group-justified" role="group" aria-label="...">
                    <div class="btn-group clearBtn fader" role="group">
                        <button type="button " class="loginRegisterButton btn br-1-w">Lav Carport</button>
                    </div>
                </div>
                <div class="loginRegisterContainer" style="margin-bottom: 20px;">
                    <div class="tab2-c tab" id="login" style="display: block;">
                        <form name="buildCarport" action="FrontController" method="POST">
                            <input type="hidden" name="command" value="buildCarport">
                            <div class="form-group">
                                <label>Længde (cm)</label>
                                <input class="form-control" type="number" name="length" placeholder ="Længde i cm" min='200' max='1000' required>
                            </div>
                            <div class="form-group">
                                <label>Bredde (cm)</label>
                                <input class="form-control" type="number" name="width" placeholder="Bredde i cm" min="200" max="1000" min='200' max='1000' required>
                            </div>
                            <div class="form-group">
                                <label>Højde (cm)</label>
                                <input class="form-control" type="number" name="height" placeholder="Højde i cm" min="210" max="1000" required>
                            </div>
                            <div class="form-group">
                                <label>Taghældning i grader</label>
                                <label>Hvis du indsætter '0 grader' bliver taget fladt.</label>
                                <input class="form-control" type="number" name="degree" placeholder="Taghældning i grader" min="0" max="45" required>
                            </div>

                            <div class="form-group">
                                <label>Tilføj skur (Husk at opgive skurets dybde).</label>
                                <input style="width: 20px; height: 20px" id='skur' type="checkbox" name="toolshed" value="1" >
                                <input id='skurhidden' type="hidden" name="toolshed" value="0" >
                            </div>

                            <div class="form-group">
                                <label>Skurets dybde (cm)</label>
                                <input id="deptinput" class="form-control" type="number" name="depth" placeholder="Skurets dybde i cm" min="50" max="1000">
                            </div>                           
                            <button type="submit" value="submit" class="btn btn-default">Byg Carport</button>
                        </form> 
                    </div>
                </div>
            </div>
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
        <script>
            //This script do so the deptinput in the buildCarport from is REQUIRED if the checkbox is checked.            
            //Define variables
            var checkBox = document.querySelector('input[type="checkbox"]');
            var deptInput = document.getElementById('deptinput');

            //The fnction
            function toggleRequired() {
                //if deptinput is not REQUIRED, set it to required, else remove REQUIRED attribute.
                if (deptInput.hasAttribute('required') !== true) {
                    deptInput.setAttribute('required', 'required');
                } else {
                    deptInput.removeAttribute('required');
                }
            }            
            //Add event listener to the checkBox.
            checkBox.addEventListener('change', toggleRequired, false);
        </script>
    </body>
</html>

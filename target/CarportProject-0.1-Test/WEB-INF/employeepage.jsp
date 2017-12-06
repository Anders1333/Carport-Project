

<%@page import="java.util.ArrayList"%>
<%@page import="FunctionLayer.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>

        <%
            ArrayList<User> userList = (ArrayList<User>) request.getAttribute("userList");
        %>
        <link href="./css/stylesheet.css" rel="stylesheet" type="text/css"/>

        <!-- Latest compiled and minified CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- jQuery library --> 
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

        <!-- Latest compiled JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    </head>

    <body>
        <nav class="container-fluid fogNavbar navbar-default">
            <div class="navbar-header" style="margin-right: 10px;">
                <a class="navbar-brand">FOG</a>
                <a class="navbar-brand registerTradeMark">®</a>
            </div>
            <div class="navbar-header" style="margin-right: 10px;">
                <a class="navbar-brand">Employee Page</a>
            </div>
            <ul class="nav navbar-nav">
                <li><a class="tabNavButton" data-target="one">Vis alle brugere</a></li>
                <li><a class="tabNavButton" data-target="two">Vis ubehandlede ordre</a></li>
                <li><a class="tabNavButton" data-target="three">Hide List</a></li>
            </ul>

            <ul class="nav navbar-nav" style="float: right">
                <li><a href="./index.jsp" class="tabNavButton">Home</a></li>
            </ul>
        </nav>

        <div class="container-fluid">
            <div class="row">
                <!-- This is the left div in the row -->
                <div class="col-sm-12">
                    <!-- This is the hidden content what will become visible by clicking the buttons in the User Navigator menu -->
                    <div class="tab-content-wrapper">
                        <!-- The first content (Show all users) -->
                        <div class="tab1-c tab" id="one">
                            <div clss="userSelectorBox">
                                <h4><strong>All Users</strong></h4>
                                <div class="userSelectorBoxButtons">
                                    <ul>
                                        <% for (int i = 0; i < userList.size(); i++) {%>
                                        <li>
                                            <form name = "getOrders" action="FrontController" method="POST">
                                                <button type = "submit">
                                                    <%=userList.get(i)%>
                                                    <input type="hidden" name="command" value="getOrders">
                                                    <input type ="hidden" name="Username" value=<%=userList.get(i).getUsername()%>>
                                                </button>
                                            </form>
                                        </li>
                                        <%}%>   
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <!-- The second content (pending orders) -->
                        <div class="tab3-c tab" id="two">
                            <div class="userSelectorBox">
                                <h4><strong>Pending Orders</strong></h4>                                
                                <div class="userSelectorBoxButtons">
                                    <ul>
                                        <% for (int i = 0; i < userList.size(); i++) {%>
                                        <li>
                                            <%if (userList.get(i).getGenerated().equalsIgnoreCase("Y")) {%>
                                            <form name = "getOrders" action="FrontController" method="POST">
                                                <button type = "submit">
                                                    <%=userList.get(i)%>
                                                    <input type="hidden" name="command" value="getOrders">
                                                    <input type ="hidden" name="Username" value=<%=userList.get(i).getUsername()%>>
                                                </button>
                                            </form>
                                            <%}%>
                                        </li>
                                        <%}%>   
                                    </ul>
                                </div>
                            </div>
                        </div>

                        <!-- The second content (pending orders) -->
                        <div class="tab3-c tab" id="three" style="display: block;">
                            <!-- Nothing here :( -->
                        </div>
                    </div>
                </div>

                <!-- This is the right div in the row -->
            </div>
            <div>
                <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
                <script src="./js/empfaderjs.js" type="text/javascript"></script>
            </div>
        </div>
    </body>
</html>
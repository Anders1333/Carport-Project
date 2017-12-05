

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
            <div class="">
                <div class="navbar-header" style="margin-right: 10px;">
                    <a class="navbar-brand">Employee Page</a>
                </div>
                <ul class="nav navbar-nav">
                    <li><a class="tabNavButton" data-target="one">Show All</a></li>
                    <li><a class="tabNavButton" data-target="three">Pending Orders</a></li>
                    <li><a class="tabNavButton" data-target="two">Page 3</a></li>
                </ul>
            </div>
        </nav>


        <div class="container-fluid">
            <div class="header">
                <h1>Hello <%=request.getParameter("username")%> </h1>
                <p>This is the employee-page</p>
                <br>
            </div>
            <div class="row">
                
                <!-- This is the left div in the row -->
                <div class="col-sm-6">
                    <!-- This is the hidden content what will become visible by clicking the buttons in the User Navigator menu -->
                    <div class="tab-content-wrapper">
                        <!-- The first content (Show all users) -->
                        <div class="tab1-c tab" id="one" style="display: block;">
                            <div id="allUsersDiv">
                                <h4><center><strong>All Users</strong></center></h4>
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
                                    <br>
                                    <%}%>   
                                </ul>
                            </div>
                        </div>

                        <!-- The second content (Show all users w/ order(s)) -->
                        <div class="tab2-c tab" id="two">
                            <p>Insert showUsersWithOrders() function</p>
                        </div>

                        <!-- The third content (Show all users w/o order(s)) -->
                        <div class="tab3-c tab" id="three">
                            <div id="allUsersDiv">
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
                                    <br>
                                    <%}%>   
                                </ul>
                            </div>
                        </div>  
                    </div>
                </div>
                                
                <!-- This is the right div in the row -->
                <div class="col-sm-6">
                    <p>Nothing here</p>
                </div>
            </div>
            <div>
                <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
                <script src="./js/empfaderjs.js" type="text/javascript"></script>
            </div>
        </div>
    </body>
</html>
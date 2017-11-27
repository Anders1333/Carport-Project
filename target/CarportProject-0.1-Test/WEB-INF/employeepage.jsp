

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

    </head>

    <body>

        <h1>Hello <%=request.getParameter("username")%> </h1>
        <p>This is the employee-page</p>
        <br>
        <div class="navigationBar">
            <h4>USERS NAVIGATOR</h4>
            <ul>
                <hr />
                <li class="showButton"><a data-target="one">SHOW ALL</a></li>
                <li class="showButton"><a data-target="two">TWO</a></li>
                <li class="showButton"><a data-target="three">THREE</a></li>
                <hr />
            </ul>
        </div>
        <br>



        <!-- This is the hidden content what will become visible by clicking the buttons in the User Navigator menu -->
        <div class="tab-content-wrapper">
            <!-- The first content (Show all users) -->
            <div class="tab1-c tab" id="one" style="display: block;">
                <div id="allUsersDiv">
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
                <p>Insert showUsersWithoutOrders() function</p>
            </div>  

            <div>
                <script src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
                <script src="./js/empfaderjs.js" type="text/javascript"></script>
            </div>
        </div>
    </body>
</html>

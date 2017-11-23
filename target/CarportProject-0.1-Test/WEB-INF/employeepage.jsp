

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
    </head>
    <body>
        
        <h1>Hello <%=request.getParameter( "username")%> </h1>
        This is the employee-page
           <form name="getUsers" action="FrontController" method="POST">
                        <input type="hidden" name="command" value="getUsers">
                   
                        <input type="submit" value="Show Users">
                    </form>
        <ul>
            <% for (int i = 0; i < userList.size(); i++) {%>
            <li>
                <form name = "getOrders" action="FrontController" method="POST">
                
                    <%=userList.get(i)%>   <input type = "submit" value ="Show offers">
                    <input type="hidden" name="command" value="getOrders">
                    <input type ="hidden" name="Username" value=<%=userList.get(i).getUsername()%>>
                </form>
            </li>
            <br>
            <%}%>   
        </ul>
        <br>
    </body>
</html>

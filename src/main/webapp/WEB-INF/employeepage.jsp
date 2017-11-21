

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee home page</title>
    </head>
    <body>
        
        <h1>Hello <%=request.getParameter( "username")%> </h1>
        You are now logged in as a EMPLOYEE of our wonderful site.
        
        <form action="" name="">
            <input type="text" name="user_id">
            <input type="submit" value="submit">    
        </form>
    </body>
</html>

<%-- 
    Document   : addsuccess
    Created on : 24-Jan-2015, 21:16:30
    Author     : Ayman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Your account was created successfully!</h1>
        <h2>An e-mail was sent to your address</h2>
        <h3>User Details</h3>
        User &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${user.name} ${user.surname}<br>
        E-mail &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: ${user.email}<br>
        Username &nbsp;: ${user.login}
        
        <a href="login.htm">login</a>
    </body>
</html>

<%-- 
    Document   : newjsp
    Created on : 06-Jan-2015, 22:08:00
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
        <h1>JSP2</h1>
        <h3>Session User Details</h3>

        User      : ${user.name} ${user.surname}<br>
        E-mail    : ${user.email}<br>
        Gender    : ${user.gender}<br>
        Pseudonym : ${user.login}
    </body>
</html>

<%-- 
    Document   : userhomepage
    Created on : 03-Feb-2015, 23:52:14
    Author     : Ayman
--%>

<%@page import="model.pojo.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <%
            User u = (User) session.getAttribute("sessionuser");
        %>

        <h1>Hello <%=u.getLogin()%>!</h1>


        <a href="users.htm">List of users</a>
        <a href="addbook.htm">Add books to store</a>
        <a href="books.htm">Browse books in the store</a>
        
        
    </body>
</html>

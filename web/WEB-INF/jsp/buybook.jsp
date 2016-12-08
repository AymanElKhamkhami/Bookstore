<%-- 
    Document   : buybook
    Created on : 06-Feb-2015, 23:21:27
    Author     : Ayman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buy Book</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
        <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
        <%@ page session="true"%>
        
    </head>
    
    <body>
        
        <h1>Here is supposed to be the purchase form</h1>
        <h3>Click on the following button to confirm the purchase</h3>
        <%
            int isbn = 0;
            if(request.getParameter("buyBook") != null){
                isbn = Integer.parseInt(request.getParameter("buyBook"));
            }
        %>
        
        
        <a href="buybook.htm?confirmBuyBook=<%=String.valueOf(isbn)%>"><button>Confirm</button></a>
        
        <%
            
            if(request.getParameter("confirmBuyBook") != null){
                isbn = Integer.parseInt(request.getParameter("confirmBuyBook"));
                %>
                <h2>Book purchased successfully!</h2>
                <a href="userhomepage.htm?confirmBuyBook=<%=String.valueOf(isbn)%>">Return to homepage</a>
                <%
            }
        %>
        
    </body>
</html>

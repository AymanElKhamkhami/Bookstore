<%-- 
    Document   : userhomepage
    Created on : 03-Feb-2015, 23:52:14
    Author     : Ayman
--%>
<%@page import="model.pojo.Book"%>
<%@page import="model.pojo.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

        <script type="text/javaScript" src="js/jquery-1.9.1.min.js"></script>
    </head>
    <body>
        <%
            User u = (User) session.getAttribute("sessionuser");
            String fullname = u.getName() + " " + u.getSurname();
        %>

        <h1>Hello <%=fullname%>!</h1>
        <table border="1">
            <tr>
                <th>Image</th> <th>ISBN</th> <th>Title</th> <th>Quantity</th> <th>Add to cart</th>
            </tr>
            
            <c:forEach var="book" items="${books}">
                <tr>
                    <td><img alt="" src="images/${book.getIsbn()}.jpg" width="100"></td>
                    <td><c:out value="${book.getIsbn()}"></c:out></td>
                    <td><c:out value="${book.getTitle()}"></c:out></td>
                        <td><input type="number" id="qtty${book.getIsbn()}"></td>
                        <td>
                            <button onclick='window.location = "usercart.htm?isbn=${book.getIsbn()}&qtty=" + document.getElementById("qtty${book.getIsbn()}").value'>Add to cart</button>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <a href="usercart.htm">as</a>

    </body>
</html>

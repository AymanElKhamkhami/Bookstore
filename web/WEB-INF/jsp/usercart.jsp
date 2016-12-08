<%-- 
    Document   : usercart
    Created on : 06-Feb-2015, 15:04:37
    Author     : Ayman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User cart</title>
    </head>
    <body>
        <h1>Browse books in your cart</h1>

        <table border="1">
            <tr>
                <th>Image</th> <th>ISBN</th> <th>Title</th> <th>Remove/Buy</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td><img alt="" src="images/${book.getIsbn()}.jpg" width="100"></td>
                    <td><c:out value="${book.getIsbn()}"></c:out></td>
                    <td><c:out value="${book.getTitle()}"></c:out></td>
                        <td>
                            <a href="usercart.htm?deleteBook=${book.getIsbn()}"><button>Remove from cart</button></a>
                            <a href="buybook.htm?buyBook=${book.getIsbn()}"><button>Buy now</button></a>
                    </td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>

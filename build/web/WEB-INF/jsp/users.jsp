<%-- 
    Document   : users
    Created on : 06-Jan-2015, 21:59:38
    Author     : Ayman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>List of users</h1>
        
        <table border="1">
            <tr>
                <th>Name</th> <th>Username</th> <th>Email</th> <th>Gender</th>
            </tr>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.getName()} ${user.getSurname()}"></c:out></td>
                    <td><c:out value="${user.getLogin()}"></c:out></td>
                    <td><c:out value="${user.getEmail()}"></c:out></td>
                    <td>
                        <c:if test="${user.getGender() == 'm'}">Male</c:if>
                        <c:if test="${user.getGender() == 'f'}">Female</c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>

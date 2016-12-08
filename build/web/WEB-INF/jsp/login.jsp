<%-- 
    Document   : login
    Created on : 03-Feb-2015, 22:40:52
    Author     : Ayman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <style>
            .error {
                color: #ff0000;
            }
        </style>  
    </head>
    <body>
        
        <%@include file="../fragments/header.jspf" %>

        <h1><spring:message code="label.form.loginTitle"></spring:message></h1>
        <form:form modelAttribute="loginForm" method="POST" enctype="utf8">
            <br>
            <table>
                <tr>
                    <td>
                        <label><spring:message code="label.user.emailOrLogin"></spring:message></label>
                        </td>
                        <td><form:input path="emailOrLogin" value=""/></td>
                    <td> <form:errors path="emailOrLogin" cssClass="errorblock" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.user.password"></spring:message>
                            </label>
                        </td>
                        <td><form:input path="password" value="" type="password"/></td>
                    <td><form:errors path="password" cssClass="errorblock"/></td>
                </tr>
            </table>
            <button type="submit"><spring:message code="label.form.loginSubmit"></spring:message>
                </button>
        </form:form>

        <br>
        Don't have an account?
        <a href="register.htm">register</a>

        <%
            if (request.getParameter("loginerror") != null) {
        %>
        <h2 class="error">The email or password you entered are not valid or wrong</h2>
        <%
            }
        %>
        <br>
        <%@include file="../fragments/footer.jspf" %>
        
    </body>
</html>

<%-- 
    Document   : newjsp
    Created on : 06-Jan-2015, 22:08:00
    Author     : Ayman
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="false"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
        <style>
            .error {
                color: #ff0000;
            }
        </style>  
    </head>
    <body>

        <% 
            if(request.getParameter("duplicate")!=null){
                %>
                <h2 class="error">There is already a user using the username and/or the email you provided<br>
                Please use another one
                </h2>
                <%
            }
        %>
        
        <h1><spring:message code="label.form.registerTitle"></spring:message></h1>

        <form:form modelAttribute="registrationForm" method="POST" enctype="utf8">
            <br>
            <table>
                <tr>
                    <td>
                        <label><spring:message code="label.user.name"></spring:message></label>
                        </td>
                        <td><form:input path="user.name" value="" /></td>
                    <td> <form:errors path="user.name" cssClass="errorblock" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.user.surname"></spring:message>
                            </label>
                        </td>
                        <td><form:input path="user.surname" value="" /></td>
                        <td><form:errors path="user.surname" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.user.gender"></spring:message>
                            </label>
                        </td>
                        <td>
                        <form:radiobutton path="user.gender" value="m" label="label.user.male"/>
                        <form:radiobutton path="user.gender" value="f" label="label.user.female"/>
                    </td>
                    <td><form:errors path="user.gender" cssClass="error" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.user.email"></spring:message>
                            </label>
                        </td>
                        <td><form:input path="user.email" value="" type="email"/></td>
                    <td><form:errors path="user.email" cssClass="error" /><td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.user.login"></spring:message>
                            </label>
                        </td>
                        <td><form:input path="user.login" value="" /></td>
                    <td> <form:errors path="user.login" cssClass="error" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.user.password"></spring:message>
                            </label>
                        </td>
                        <td><form:input path="user.password" value="" type="password" /></td>
                    <td><form:errors path="user.password" cssClass="error" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.user.confirmPass"></spring:message>
                            </label>
                        </td>
                        <td><form:input path="confirmPassword" value="" type="password" /></td>

                    <td><form:errors path="confirmPassword" cssClass="error"/></td>
                </tr>
            </table>
            <button type="submit"><spring:message code="label.form.registerSubmit"></spring:message>
                </button>
        </form:form>
        <br>
        <a href="login.htm">
            <spring:message code="label.form.loginTitle"></spring:message>
        </a>

    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body>
        <a href="register.htm">register</a>
        <a href="newjsp2.htm">jsp2</a>
        <a href="login.htm">sign in</a>
        
        <span style="float: right">
            <a href="?language=en">en</a> 
            | 
            <a href="?language=de">de</a>
        </span>
        
        <h3><spring:message code="welcome"></spring:message></h3>
    </body>
</html>

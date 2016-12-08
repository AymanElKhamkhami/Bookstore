<%-- 
    Document   : addbook
    Created on : 04-Feb-2015, 23:37:42
    Author     : Ayman
--%>

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
        <title>New Book</title>
    </head>
    <body>
        <h1>Add a new book to the store</h1>

        

        <sf:form modelAttribute="addBookForm" method="POST" enctype="multipart/form-data">
            <br>
            <table>
                <tr>
                    <td><label>Please select a file to upload : </label></td>
                    <td><sf:input path="image" value="" type="file"  /></td>
                </tr>
                <tr>
                    <td>
                        <label><spring:message code="label.book.isbn"></spring:message></label>
                        </td>
                        <td><sf:input path="book.isbn" value="" /></td>
                    <td> <sf:errors path="book.isbn" cssClass="errorblock" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.book.title"></spring:message>
                            </label>
                        </td>
                        <td><sf:input path="book.title" value="" /></td>
                    <td><sf:errors path="book.title" cssClass="error"/></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.book.author"></spring:message>
                            </label>
                        </td>
                        <td><sf:input path="book.author" value=""/></td>
                    <td><sf:errors path="book.author" cssClass="error" /><td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.book.publisher"></spring:message>
                            </label>
                        </td>
                        <td><sf:input path="book.publisher" value="" /></td>
                    <td> <sf:errors path="book.publisher" cssClass="error" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.book.category"></spring:message>
                            </label>
                        </td>
                        <td>
                        <sf:select path="book.category" value="" >
                            <sf:option value="" label="Select" />
                            <sf:option value="Architecture" label="Architecture" />
                            <sf:option value="Art" label="Art" />
                            <sf:option value="Biography" label="Biography" />
                            <sf:option value="Business" label="Business" />
                            <sf:option value="Cooking & Food" label="Cooking & Food" />
                            <sf:option value="Fun & Games" label="Fun & Games" />
                            <sf:option value="Health & Body" label="Health & Body" />
                            <sf:option value="History" label="History" />
                            <sf:option value="Philosophy" label="Philosophy" />
                            <sf:option value="Photography" label="Photography" />
                            <sf:option value="Social & Science" label="Social & Science" />
                            <sf:option value="Sports" label="Sports" />
                            <sf:option value="Travel" label="Travel" />
                        </sf:select>
                    </td>
                    <td><sf:errors path="book.category" cssClass="error" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.book.format"></spring:message>
                            </label>
                        </td>
                        <td>
                        <sf:select path="book.format" value="" >
                            <sf:option value="" label="Select" />
                            <sf:option value="Hardpaper" label="Hardpaper" />
                            <sf:option value="Paperback/Softback" label="Paperback/Softback" />
                        </sf:select>
                    </td>
                    <td><sf:errors path="book.format" cssClass="error" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.book.price"></spring:message>
                            </label>
                        </td>
                        <td><sf:input path="book.price" value="" /></td>
                    <td><sf:errors path="book.price" cssClass="error" /></td>
                </tr>
                <tr>
                    <td><label><spring:message code="label.book.description"></spring:message>
                            </label>
                        </td>
                        <td><sf:textarea path="book.description" value="" /></td>
                    <td></td>
                </tr>
            </table>
            <button type="submit"><spring:message code="label.form.addBook"></spring:message>
                </button>
        </sf:form>

    </body>
</html>

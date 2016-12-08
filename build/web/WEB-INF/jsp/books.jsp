<%-- 
    Document   : users
    Created on : 06-Jan-2015, 21:59:38
    Author     : Ayman
--%>

<%@page import="model.pojo.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page session="true"%>
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Browse Books</title>
        <link rel="stylesheet" href="css/style.css">
        <script type="text/javaScript" src="js/jquery-1.9.1.min.js"></script>
        <script type="text/javaScript" src="js/js.js" charset="utf-8"></script>

    </head>
    <body>
        <h1>List of books in the store</h1>

        
        <table border="1">
            <tr>
                <th>Image</th> <th>ISBN</th> <th>Title</th> <th>Edit/Delete</th>
            </tr>
            <c:forEach var="book" items="${books}">
                <tr>
                    <td><img alt="" src="images/${book.getIsbn()}.jpg" width="100"></td>
                    <td><c:out value="${book.getIsbn()}"></c:out></td>
                    <td><c:out value="${book.getTitle()}"></c:out></td>
                        <td>
                            <a href="books.htm?deleteBook=${book.getIsbn()}"><button>Delete</button></a>
                        <button id="editBtn" onclick="$('#editBox').show();
                                $('#bg').show();
                                $('#inputIsbn').val(${book.getIsbn()});
                                $('#inputTitle').val('${book.getTitle()}');
                                $('#inputAuthor').val('${book.getAuthor()}');
                                $('#inputPublisher').val('${book.getPublisher()}');
                                $('#inputCategory').val('${book.getCategory()}');
                                $('#inputFormat').val('${book.getFormat()}');
                                $('#inputDecription').val('${book.getDescription()}');
                                $('#inputPrice').val(${book.getPrice()});
                                ">Edit
                        </button>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <h3><%=request.getParameter("bookIsbn")%></h3>


        <div id="bg"></div>

        <div id="editBox">
            <button id= "close" >&#215;</button>
            <br>
            <form method="POST">
                <br>
                <table>
                    <tr>
                        <td>
                            <label><spring:message code="label.book.isbn"></spring:message></label>
                            </td>
                            <td><input id="inputIsbn" type="text" name="inputIsbn" ></td>
                        </tr>
                        <tr>
                            <td>
                                <label><spring:message code="label.book.title"></spring:message></label>
                            </td>
                            <td><input id="inputTitle" type="text" name="inputTitle" ></td>
                        </tr>
                        <tr>
                            <td>
                                <label><spring:message code="label.book.author"></spring:message></label>
                            </td>
                            <td>
                                <input id="inputAuthor" type="text" name="inputAuthor" >
                            </td>
                        </tr>

                        <tr>
                            <td>
                                <label><spring:message code="label.book.publisher"></spring:message></label>
                            </td>
                            <td><input id="inputPublisher" type="text" name="inputPublisher" >
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label><spring:message code="label.book.category"></spring:message></label>
                            </td>
                            <td><select id="inputCategory" name="inputCategory">
                                    <option value="" label="Select" >
                                    <option value="Architecture" label="Architecture" >
                                    <option value="Art" label="Art" >
                                    <option value="Biography" label="Biography" >
                                    <option value="Business" label="Business" >
                                    <option value="Cooking & Food" label="Cooking & Food" >
                                    <option value="Fun & Games" label="Fun & Games" >
                                    <option value="Health & Body" label="Health & Body" >
                                    <option value="History" label="History" >
                                    <option value="Philosophy" label="Philosophy" >
                                    <option value="Photography" label="Photography" >
                                    <option value="Social & Science" label="Social & Science" >
                                    <option value="Sports" label="Sports" >
                                    <option value="Travel" label="Travel" >
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label><spring:message code="label.book.format"></spring:message></label>
                            </td>
                            <td>
                                <select id="inputFormat" name="inputFormat"  >
                                    <option value="" label="Select" >
                                    <option value="Hardpaper" label="Hardpaper" >
                                    <option value="Paperback/Softback" label="Paperback/Softback" >
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label><spring:message code="label.book.description"></spring:message></label>
                            </td>
                            <td>
                                <textarea id="inputDescription" name="inputDescription" ></textarea>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label><spring:message code="label.book.price"></spring:message></label>
                        </td>
                        <td>
                            <input id="inputPrice" type="text" name="inputPrice" >
                        </td>
                    </tr>
                </table>
                <a href="books.htm"><button>Save</button></a>
            </form>

        </div>

    </body>
</html>

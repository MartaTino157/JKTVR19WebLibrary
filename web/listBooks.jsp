<%-- 
    Document   : listBooks
    Created on : Dec 1, 2020, 9:59:18 AM
    Author     : pupil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список книг</title>
    </head>
    <body>
        <h1>Список книг</h1>
        <ol>
            <c:forEach var="book" items="${listBooks}" varStatus="status">
                <li>
                    <b>${book.name}. </b> ${book.author}. ${book.publishedYear}
                </li>
            </c:forEach>
        </ol>
        <a href="index.jsp">Home</a>
    </body>
</html>

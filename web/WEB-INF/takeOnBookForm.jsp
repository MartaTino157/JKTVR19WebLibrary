<%-- 
    Document   : giveOutBook
    Created on : Dec 2, 2020, 9:15:50 AM
    Author     : pupil
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Выдача книги</title>
    </head>
    <body>
        <h1>Выдать книгу</h1>
        <form action="takeOnBook" method="POST">
            <h3>Шаг 1: Выберите книгу</h3>
            <select name="bookId">
                <option value="">Выберите книгу</option>
                <c:forEach var="book" items="${listBooks}" varStatus="status">
                    <option value="${book.id}">${book.name} ${book.author}</option>
                </c:forEach>
            </select>
            <h3>Шаг 2: Выберите читателя</h3>
            <select name="readerId">
                <option value="">Выберите читателя</option>
                <c:forEach var="reader" items="${listReaders}" varStatus="status">
                    <option value="${reader.id}">${reader.firstname} ${reader.lastname}</option>
                </c:forEach>
            </select>
            <p>
                <input type="submit" name="submit" value="Выдать книгу">
            </p>
            <p>
                <a href="index.jsp">Home</a>                
            </p>
        </form>
    </body>
</html>

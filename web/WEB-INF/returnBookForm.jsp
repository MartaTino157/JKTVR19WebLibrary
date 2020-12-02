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
        <title>Список читаемых книг</title>
    </head>
    <body>
        <h1>Возврат книги</h1>
        <form action="returnBook" method="POST">
            <select name="historyId">
                <option value="">Выберите возвращаемую книгу</option>
                <c:forEach var="history" items="${listReadBooks}" varStatus="status">
                    <option value="${history.id}">"${history.book.name}" на руках у читателя ${history.reader.firstname} ${history.reader.lastname}</option>
                </c:forEach>
            </select>
            <p>
                <input type="submit" value="Вернуть книгу">
            </p>
        </form>
        <p>
            <a href="index.jsp">Home</a>
        </p>
    </body>
</html>

<%-- 
    Document   : page1
    Created on : Nov 24, 2020, 10:43:08 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добавить книгу</title>
    </head>
    <body>
        <div>Добавление книги</div>
        <p>${info}</p>
        <br>
        <a href="index.jsp">Home</a>
        <form action="createBook" method="POST">
            Название книги: <input type="text" name="name" value="${name}"><br>
            Автор книги: <input type="text" name="author" value="${author}"><br>
            Год публикации: <input type="text" name="publishedYear" value="${publisedYear}"><br>
            <input type="submit" name="submit" value="Добавить книгу">
        </form>
    </body>
</html>

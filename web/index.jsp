<%-- 
    Document   : index
    Created on : Nov 27, 2020, 9:14:15 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JKTVR19WebLibrary</title>
    </head>
    <body>
        <h1>Наша библиотека</h1>
        <p>${info}</p>
        <p>
            <a href="loginForm">Войти в систему</a>
        </p>
        <p>
            <a href="logout">Выйти из системы</a>
        </p>
        <p>
            <a href="addBook">Добавить книгу</a>
        </p>
        <p>
            <a href="listBooks">Список книг</a>
        </p>
        <p>
            <a href="registrationForm">Добавить читателя</a>
        </p>
        <p>
            <a href="listReaders">Список читателей</a>
        </p>
        <p>
            <a href="takeOnBookForm">Выдать книгу</a>
        </p>
        <p>
            <a href="returnBookForm">Вернуть книгу</a>
        </p>
    </body>
</html>

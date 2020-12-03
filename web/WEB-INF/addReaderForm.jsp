<%-- 
    Document   : page2
    Created on : Nov 24, 2020, 10:52:20 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Добавить читателя</title>
    </head>
    <body>
        <h2>Добавление читателя</h2>
        <p>${info}</p>
        <h3>Шаг 1: Ввод личных данных</h3>
        <form action="registration" method="POST">
            Имя: <input type="text" name="firstname" value="${firstname}"><br>
            Фамилия: <input type="text" name="lastname" value="${lastname}"><br>
            Номер телефона: <input type="text" name="phone" value="${phone}"><br><br>
            
        <h3>Шаг 2: Регистрация пользователя</h3>
            Логин: <input type="text" name="login" value="${login}"><br>
            Пароль: <input type="text" name="password" value="${password}"><br><br>
            
            <input type="submit" name="submit" value="Добавить пользователя"><br>
        </form>
            <a href="index.jsp">Home</a>
    </body>
</html>

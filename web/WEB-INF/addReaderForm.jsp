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
        <div>Добавление читателя</div>
        <p>${info}</p>
        <br>
        <a href="index.jsp">Home</a>
        <form action="createReader" method="POST">
            Имя: <input type="text" name="firstname" value="${firstname}"><br>
            Фамилия: <input type="text" name="lastname" value="${lastname}"><br>
            Номер телефона: <input type="text" name="phone" value="${phone}"><br>
            <input type="submit" name="submit" value="Добавить читателя">
        </form>
    </body>
</html>

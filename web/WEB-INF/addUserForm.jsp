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
        <a href="WEB-INF/addReaderForm.jsp">Назад</a><br>
        <a href="index.jsp">Home</a><br>
        <h3>Шаг 2: Регистрация пользователя</h3>
        <form action="createReader" method="POST">

            Логин: <input type="text" name="login" value="${login}"><br>
            Пароль: <input type="text" name="password" value="${password}"><br>
            
            Роль: <select name="role" value="${role}">
                <option value="reader">Читатель</option>
                <option value="manager">Менеджер</option>
            </select><br><br>
            <input type="submit" name="submit" value="Добавить пользователя">
        </form>
    </body>
</html>

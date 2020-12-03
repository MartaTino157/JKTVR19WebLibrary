<%-- 
    Document   : loginForm
    Created on : Dec 3, 2020, 8:51:01 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Вход</title>
    </head>
    <body>
        <h1>Введите логин и пароль</h1>
        <form action="login" method="POST">
            Логин: <input type="text" name="login" value=""><br>
            Пароль: <input type="password" name="password" value=""><br><br>
            <input type="submit" value="Войти"><br>
        </form>
        <p>
            Если у вас нет аккаунта - <a href="registrationForm">зарегистрируйтесь</a>
        </p>
        
    </body>
</html>

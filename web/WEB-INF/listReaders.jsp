<%-- 
    Document   : listUsers
    Created on : Dec 1, 2020, 10:17:28 AM
    Author     : pupil
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список пользователей</title>
    </head>
    <body>
        <h1>Список пользователей</h1>
        <ol>
            <c:forEach var="reader" items="${listReaders}" varStatus="status">
                <li>
                    ${reader.firstname} ${reader.lastname}. <br>
                    Номер телефона: ${reader.phone}
                </li>
            </c:forEach>
        </ol>
        <a href="index.jsp">Home</a>
    </body>
</html>

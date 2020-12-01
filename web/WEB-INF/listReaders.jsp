<%-- 
    Document   : listUsers
    Created on : Dec 1, 2020, 10:17:28 AM
    Author     : pupil
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Список пользователей</title>
    </head>
    <body>
        <h1>Список пользователей</h1>
        <ul>
            <c:forEach var="reader" items="${listReaders}" varStatus="status">
                <li>
                    ${status.index+1}. ${reader.firstname}. ${reader.lastname}. ${reader.phone}
                </li>
            </c:forEach>
        </ul>
    </body>
</html>

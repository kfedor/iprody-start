<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
<head>
    <title>Пользователь по id</title>
</head>
<body>
    <h1>Базовая информация о пользователе</h1>
    <table border="1">
        <tr>
            <th>Имя</th>
            <th>Email</th>
        </tr>
        <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
        </tr>
    </table>
</body>
</html>
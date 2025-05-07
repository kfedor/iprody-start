<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>

<html>
<head>
    <title>Пользователь по id</title>
</head>
<body>
    <h1>Пользователь по id</h1>
    <table border="1">
        <tr>
            <th>Имя</th>
            <th>Email</th>
            <th>Адреса</th>
        </tr>
        <tr>
            <td>${user.name}</td>
            <td>${user.email}</td>
            <td>
            <c:forEach var="address" items="${user.addresses}">
                    ${address}<br>
            </c:forEach>
            </td>
        </tr>
    </table>
</body>
</html>
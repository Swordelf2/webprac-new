<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>История услуг</title>
    </head>
<body>
<table border="2px">
    <tr>
        <td>ID</td>
        <td>${client.id}</td>
    </tr>
    <tr>
        <td>Имя</td>
        <td>${client.name}</td>
    </tr>
</table>

<table border="2px">
    <tr>
        <th>Телефонный номер</th>
        <th>ID услуги</th>
        <th>Начало оказания</th>
        <th>Конец оказания</th>
    </tr>
<c:forEach items="${client.activatedservices}" var="item">
    <tr>
        <td>${item.number}</td>
        <td>${item.service.id}</td>
        <td>${item.starttime}</td>
        <td>${item.endtime}</td>
    </tr>
</c:forEach>
</table>

<a href="newService?id=${client.id}">Регистрация договора об оказании услуги</a>

</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Клиент</title>
</head>
<body>

<h2>Клиент</h2>
<table border="2px">
    <tr>
        <td>ID</td>
        <td>${client.id}</td>
    </tr>
    <tr>
        <td>Тип</td>
        <td>${client.type}</td>
    </tr>
    <tr>
        <td>Имя</td>
        <td>${client.name}</td>
    </tr>
</table>
<a href="clientEdit?id=${client.id}">Редактировать</a> <br>
<a href="clientAcctount?id=${client.id}">Счет</a> <br>
<a href="serviceHistory?id=${client.id}">История услуг</a> <br>
Список контактов: <br>
<table border="2px">
    <tr>
        <th>Тип</th>
        <th>Описание</th>
    </tr>
    <c:forEach items="${client.contacts}" var="contact">
        <tr>
            <td>${contact.type}</td>
            <td>${contact.description}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

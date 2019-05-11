<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Клиенты</title>
    </head>
<body>
<h2>Список клиентов:</h2>
<form action="<c:url value="/clientList"/>" method="post">
    Имя: <input name="name" type="text">
    <input value="Поиск" type="submit">
</form>
<table border="2px">
    <tr>
        <th>ID</th>
        <th>Тип</th>
        <th>Имя</th>
        <th>Баланс</th>
        <th>Лимит кредита</th>
        <th>Максимальное время кредита</th>
        <th></th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.id}</td>
            <td>${item.type}</td>
            <td>${item.name}</td>
            <td>${item.balance}</td>
            <td>${item.creditlimit}</td>
            <td>${item.credittime}</td>
            <td>
                <span><a href="client?id=${item.id}">Info</a></span>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Регистрация списания</title>
    </head>
<body>
<h2>Регистрация списания</h2>
<form action="newCharge" method="post">
    ID клиента: <input name="clientId" value="<c:if test="${not empty client}">${client.id}</c:if>"> <br>
    Сумма: <input name="sum"> <br>
    Время: <input name="time" type="datetime-local"> <br>
    ID сервиса: <input name="serviceId"> <br>
    <button type="submit">Сохранить</button>
</body>
</html>

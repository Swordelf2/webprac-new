<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Регистрация кредита</title>
    </head>
<body>
<a href="index">На главную</a> <br>
<h2>Регистрация кредита</h2>
<form action="newCredit" method="post">
    ID клиента: <input name="clientId" value="<c:if test="${not empty client}">${client.id}</c:if>"> <br>
    Сумма: <input name="sum"> <br>
    Дата: <input name="startdate" type="datetime-local"> <br>
    <button type="submit">Сохранить</button>
</body>
</html>

<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Регистрация договора об оказании услуги</title>
    </head>
<body>
<a href="index">На главную</a> <br>
<h2>Регистрация договора об оказании улуги</h2>
<form action="newService" method="post">
    ID клиента: <input name="clientId" value="${client.id}"> <br>
    ID услуги: <input name="serviceId"> <br>
    Телефонный номер <input name="number"> <br>
    Время начала: <input name="starttime" type="datetime-local">
    Время окончания: <input name="endtime" type="datetime-local">
    <button type="submit">Сохранить</button>
</body>
</html>

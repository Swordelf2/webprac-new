<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Редактирование клиента</title>
    </head>
<body>
<h2>Редактирование клиента</h2>
<form:form action="clientEdit" method="post" modelAttribute="client">
    ID: <form:hidden path="id"/> ${client.id}<br>
    Тип
        <form:radiobutton path="type" value="I"/> Физическое лицо
        <form:radiobutton path="type" value="L"/> Юридическое лицо <br>
    Имя: <form:input path="name" value="${client.name}"/> <br>
    <form:hidden path="balance"/>
    <form:hidden path="creditlimit"/>
    <form:hidden path="credittime"/>
    <button type="submit">Сохранить</button>
</form:form>
</body>
</html>

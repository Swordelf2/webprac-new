<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Услуги</title>
    </head>
<body>
<h2>Список услуг:</h2>
<form action="<c:url value="/serviceList"/>" method="post">
    Имя: <input name="name" type="text"> <br>
    Описание: <input name="description" type="text"> <br>
    <input value="Поиск" type="submit">
</form>
<table border="2px">
    <tr>
        <th>Название</th>
        <th>Описание</th>
        <th>Описание тарифа</th>
        <th></th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.description}</td>
            <td>${item.tariffdescription}</td>
            <td>
                <!-- <span><a href="lient?id=${item.id}">Info</a></span> -->
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

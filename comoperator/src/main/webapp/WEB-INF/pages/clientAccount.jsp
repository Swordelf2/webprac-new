<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Счет клиента</title>
</head>
<body>

<h2>Счет клиента</h2>
<table border="2px">
    <tr>
        <td>ID</td>
        <td>${client.id}</td>
    </tr>
    <tr>
        <td>Имя</td>
        <td>${client.name}</td>
    </tr>
    <tr>
        <td>Баланс</td>
        <td>${client.balance}</td>
    </tr>
    <tr>
        <td>Лимит кредита</td>
        <td>${client.creditlimit}</td>
    </tr>
    <tr>
        <td>Максимальное время кредита</td>
        <td>${client.credittime}</td>
    </tr>
</table>

Поступления:<br>
<table border="2px">
    <tr>
        <th>Время</th>
        <th>Сумма</th>
    </tr>
    <c:forEach items="${client.deposits}" var="deposit">
    <tr>
        <td>${deposit.time}</td>
        <td>${deposit.sum}</td>
    </tr>
    </c:forEach>
</table>
<a href="newDeposit?id=${client.id}">Регистрация поступления</a> <br>

Списания:<br>
<table border="2px">
    <tr>
        <th>Время</th>
        <th>Сумма</th>
        <th>ID услуги</th>
    </tr>
    <c:forEach items="${client.charges}" var="charge">
    <tr>
        <td>${charge.time}</td>
        <td>${charge.sum}</td>
        <td>${charge.service.id}</td>
    </tr>
    </c:forEach>
</table>
<a href="newCharge?id=${client.id}">Регистрация списания</a> <br>

Действуйщие кредиты:<br>
<table border="2px">
    <tr>
        <th>Сумма</th>
        <th>Дата начала</th>
        <th>Дата окончания</th>
    </tr>
    <c:forEach items="${client.credits}" var="credit">
    <tr>
        <td>${credit.sum}</td>
        <td>${credit.startdate}</td>
        <td>${credit.enddate}</td>
    </tr>
    </c:forEach>
</table>
<a href="newCredit?id=${client.id}">Регистрация кредита</a> <br>
</body>
</html>

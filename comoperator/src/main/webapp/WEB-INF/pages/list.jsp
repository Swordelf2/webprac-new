<%@ page language="java" contentType="text/html; UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<body>
<h2>Список идей:</h2>
<table border="2px">
    <tr>
        <th>Name</th>
        <th>Balance</th>
        <th>Credit Limit</th>
        <th>Credit Time</th>
        <th></th>
    </tr>
    <c:forEach items="${list}" var="item">
        <tr>
            <td><c:out value="${item.name}"/></td>
            <td><c:out value="${item.balance}"/></td>
            <td><c:out value="${item.creditlimit}"/></td>
            <td><c:out value="${item.credittime}"/></td>
            <td>
                <span><a href="info?id=${item.id}">Info</a></span>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

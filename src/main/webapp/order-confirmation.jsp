<%--@elvariable id="order" type="com.epam.transporter.entity.Order"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Оформление</title>
</head>
<body>
<p>Ваш заказ принят</p>
<p>Стоимость ${order.price}</p>
<p>Мои заказы</p>
<table>
    <tr>
        <td>Груз</td>
        <td>Откуда</td>
        <td>Куда</td>
        <td>Статус</td>
    </tr>
    <jsp:useBean id="customerOrders" scope="session" type="java.util.List"/>
    <c:forEach items="${customerOrders}" var="order">
        <tr>
            <td>${order.goods.name}</td>
            <td>${order.deliveryPoints.startingPoint}</td>
            <td>${order.deliveryPoints.destination}</td>
            <td>${order.status}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>

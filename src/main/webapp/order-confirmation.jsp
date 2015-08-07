<%--@elvariable id="customer" type="com.epam.transporter.entity.Customer"--%>
<%--@elvariable id="truck" type="com.epam.transporter.entity.Truck"--%>
<%--@elvariable id="order" type="com.epam.transporter.entity.Order"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Мои заказы</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.2/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="jumbotron-narrow.css"/>
</head>
<body style="zoom: 1;">
<div class="container">
    <%@include file="header.jspf" %>
    <p>Ваш заказ принят</p>
    <p>Для Вас зарезервирован ${truck.model}</p>
    <p>Стоимость перевозки ${order.deliveryPoints.distance*truck.pricePerKm}</p>
    <%@include file="footer.jspf" %>
</div>
</body>
</html>

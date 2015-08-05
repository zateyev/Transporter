<%--@elvariable id="order" type="com.epam.transporter.entity.Order"--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.2/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="jumbotron-narrow.css">
</head>
<body style="zoom: 1;">
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li><a href="index.jsp"><span class="glyphicon glyphicon-home"></span> Главная</a></li>
            <li><a href="login.jsp">Вход</a></li>
            <li><a href="register.jsp">Регистрация</a></li>
        </ul>
        <h1 class="text-muted">Transporter</h1>
    </div>
    <p>Дистанция ${order.deliveryPoints.distance}</p>
    <p>Стоимость ${order.price}</p>
    <%@include file="footer.jspf" %>
</div>
</body>
</html>
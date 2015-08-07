<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

    <jsp:useBean id="truckList" scope="session" type="java.util.List"/>
    <c:choose>
        <c:when test="${not empty truckList}">
    <div class="list">
        <h3>Свободные грузовики</h3>
        <table class="table">
            <tr>
                <th>ID</th>
                <th>Модель</th>
                <th>Стоимость перевозки</th>
            </tr>
            <tbody>
            <c:forEach items="${truckList}" var="truck">
                <tr>
                    <td>${truck.id}</td>
                    <td>${truck.model}</td>
                    <td>${truck.pricePerKm*order.deliveryPoints.distance}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
            <p>Чтобы зарезервировать транспорт <a href="login.jsp">войдите</a> в систему</p>
        </c:when>
        <c:otherwise>
            <p>Свободных грузовиков нет.</p>
        </c:otherwise>
    </c:choose>

    <%@include file="footer.jspf" %>
</div>
</body>
</html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="user" type="com.epam.transporter.entity.User"--%>
<%--@elvariable id="order" type="com.epam.transporter.entity.Order"--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Стоимость перевозки</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.2/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="jumbotron-narrow.css">
</head>
<body style="zoom: 1;">
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li><a href="welcome.jsp"><span class="glyphicon glyphicon-home"></span> Главная</a></li>
            <li><a href="#">${user.firstName}</a></li>
            <li><a href="my-orders.jsp">Мои заказы</a></li>
            <li>
                <form method="get" action="${pageContext.request.contextPath}/logout">
                    <button class="btn btn-default navbar-btn">Выйти</button>
                </form>
            </li>
        </ul>
        <h1 class="text-muted">Transporter</h1>
    </div>

    <jsp:useBean id="truckList" scope="session" type="java.util.List"/>
    <c:choose>
        <c:when test="${not empty truckList}">
    <form method="post" action="${pageContext.request.contextPath}/book">
            <div class="list">
                <h3>Свободные грузовики</h3>
                <table class="table">
                    <tr>
                        <th>ID</th>
                        <th>Модель</th>
                        <th>Стоимость перевозки</th>
                        <th>Выбрать</th>
                    </tr>
                    <tbody>
                    <c:forEach items="${truckList}" var="truck">
                        <tr>
                            <td>${truck.id}</td>
                            <td>${truck.model}</td>
                            <td>${truck.pricePerKm*order.deliveryPoints.distance}</td>
                            <td><input type="radio" name="truckId" value="${truck.id}"/></td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <button class="btn btn-info pull-right">Забронировать</button>
            </div>
    </form>
        </c:when>
        <c:otherwise>
            <p>Свободных грузовиков нет.</p>
        </c:otherwise>
    </c:choose>

    <%@include file="footer.jspf" %>
</div>
</body>
</html>
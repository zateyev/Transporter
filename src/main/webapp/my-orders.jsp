<%--@elvariable id="customer" type="com.epam.transporter.entity.Customer"--%>
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
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li><a href="welcome.jsp"><span class="glyphicon glyphicon-home"></span> Главная</a></li>
            <li><a href="#">${customer.firstName}</a></li>
            <li class="active"><a href="my-orders.jsp">Мои заказы</a></li>
            <li>
                <form method="get" action="${pageContext.request.contextPath}/logout">
                    <button class="btn btn-default navbar-btn">Выйти</button>
                </form>
            </li>
        </ul>
        <h1 class="text-muted">Transporter</h1>
    </div>

    <form action="${pageContext.request.contextPath}/orderStatusChanger" method="post">
        <h3>Мои заказы</h3>
        <table class="table">
            <tr>
                <th>Груз</th>
                <th>Откуда</th>
                <th>Куда</th>
                <th>Статус</th>
            </tr>
            <tbody>
            <jsp:useBean id="customerOrders" scope="session" type="java.util.List"/>
            <c:forEach items="${customerOrders}" var="order">
                <tr>
                    <td>${order.goods.name}</td>
                    <td>${order.deliveryPoints.startingPoint}</td>
                    <td>${order.deliveryPoints.destination}</td>
                    <td>
                        <select name="status${order.id}" id="">
                            <option value="${order.status}">${order.status}</option>
                            <option value="CANCELED">CANCELED</option>
                        </select>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <button class="btn btn-info pull-right">Отменить заказы</button>
    </form>
    <%@include file="content.jspf" %>
    <%@include file="footer.jspf" %>
</div>
</body>
</html>
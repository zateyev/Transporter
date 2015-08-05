<%--@elvariable id="customer" type="com.epam.transporter.entity.Customer"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Admin</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.2/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="jumbotron-narrow.css">
</head>
<body style="zoom: 1;">
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> Главная</a></li>
            <li><a href="#">${customer.firstName}</a></li>
            <li>
                <form method="get" action="${pageContext.request.contextPath}/logout">
                    <button class="btn btn-default navbar-btn">Выйти</button>
                </form>
            </li>
        </ul>
        <h1 class="text-muted">Transporter</h1>
    </div>
    <form action="${pageContext.request.contextPath}/orderStatusChanger" method="post">
        <table>
            <tr>
                <td>Груз</td>
                <td>Откуда</td>
                <td>Куда</td>
                <td>Заказчик</td>
                <td>Статус</td>
            </tr>
            <jsp:useBean id="orderList" scope="session" type="java.util.List"/>
            <c:forEach items="${orderList}" var="order">
                <tr>
                    <td>${order.goods.name}</td>
                    <td>${order.deliveryPoints.startingPoint}</td>
                    <td>${order.deliveryPoints.destination}</td>
                    <td>${order.customer.firstName}</td>
                    <td>
                        <select name="status${order.id}" id="0">
                            <option value="${order.status}">${order.status}</option>
                            <option value="IN_WORK">IN_WORK</option>
                            <option value="WORKED_OUT">WORKED_OUT</option>
                            <option value="CANCELED">CANCELED</option>
                        </select>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <button>Изменить</button>
    </form>
    <p><a href="edit-trucks-list.jsp">Редактировать список грузовиков</a></p>

    <form action="${pageContext.request.contextPath}/truckStatusChanger" method="post">
        <table>
            <tr>
                <td>ID</td>
                <td>Модель</td>
                <td>Грузоподъемность</td>
                <td>Объем</td>
                <td>Цена за км</td>
                <td>Статус</td>
            </tr>
            <jsp:useBean id="trucksList" scope="session" type="java.util.List"/>
            <c:forEach items="${trucksList}" var="truck">
                <tr>
                    <td>${truck.id}</td>
                    <td>${truck.model}</td>
                    <td>${truck.capacityByWeight}</td>
                    <td>${truck.capacityByVolume}</td>
                    <td>${truck.pricePerKm}</td>
                    <td>
                        <select name="status${truck.id}" id="color-bar-indicator">
                            <option value="${truck.status}">${truck.status}</option>
                            <option value="EMPTY">EMPTY</option>
                            <option value="RESERVED">RESERVED</option>
                            <option value="DEFECTIVE">DEFECTIVE</option>
                        </select>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <button>Изменить</button>
    </form>
    <%@include file="footer.jspf" %>
</div>
</body>
</html>
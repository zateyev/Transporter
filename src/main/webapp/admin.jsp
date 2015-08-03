<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<p>Hello admin!</p>
<form method="get" action="${pageContext.request.contextPath}/logout">
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
                <td>${order.status}</td>
            </tr>
        </c:forEach>
    </table>
    <table>
        <tr>
            <td>ID</td>
            <td>Модель</td>
            <td>Статус</td>
        </tr>
        <jsp:useBean id="trucksList" scope="session" type="java.util.List"/>
        <c:forEach items="${trucksList}" var="truck">
            <tr>
                <td>${truck.id}</td>
                <td>${truck.model}</td>
                <td>${truck.status}</td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Logout"/>
</form>
</body>
</html>

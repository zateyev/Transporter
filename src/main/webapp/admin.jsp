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
        </tr>
        <jsp:useBean id="orderList" scope="session" type="java.util.List"/>
        <c:forEach items="${orderList}" var="order">
            <tr>
                <td>${order.goods.name}</td>
                <td>${order.deliveryPoints.startingPoint}</td>
                <td>${order.deliveryPoints.destination}</td>
            </tr>
        </c:forEach>
    </table>
    <input type="submit" value="Logout"/>
</form>
</body>
</html>

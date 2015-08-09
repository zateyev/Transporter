<%--@elvariable id="user" type="com.epam.transporter.entity.User"--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Редактирование списка грузовиков</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.2/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="jumbotron-narrow.css">
</head>
<body style="zoom: 1;">
<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li><a href="admin.jsp"><span class="glyphicon glyphicon-home"></span> Главная</a></li>
            <li><a href="#">${user.firstName}</a></li>
            <li>
                <form method="get" action="${pageContext.request.contextPath}/logout">
                    <button class="btn btn-default navbar-btn">Выйти</button>
                </form>
            </li>
        </ul>
        <h1 class="text-muted">Transporter</h1>
    </div>
</div>
<h3>Список грузовиков</h3>
    <table class="table">
        <tr>
            <th>ID</th>
            <th>Модель</th>
            <th>Грузоподъемность</th>
            <th>Объем</th>
            <th>Цена за км</th>
            <th>Статус</th>
            <th></th>
        </tr>
        <tbody>
        <jsp:useBean id="trucksList" scope="session" type="java.util.List"/>
        <c:forEach items="${trucksList}" var="truck">
            <form action="${pageContext.request.contextPath}/truckRemover" method="post">
                <tr>
                    <td>${truck.id}</td>
                    <td>${truck.model}</td>
                    <td>${truck.capacityByWeight}</td>
                    <td>${truck.capacityByVolume}</td>
                    <td>${truck.pricePerKm}</td>
                    <td>${truck.status}</td>
                    <td>
                        <input type="hidden" name="truckId" value="${truck.id}"/>
                        <button class="btn-warning">Удалить</button>
                    </td>
                </tr>
            </form>
        </c:forEach>
        <form action="${pageContext.request.contextPath}/truckAdder" method="post">
            <tr>
                <td></td>
                <td>
                    <input name="model" type="text" placeholder="model">
                </td>
                <td>
                    <input name="capacityByWeight" type="text" placeholder="capacityByWeight">
                </td>
                <td>
                    <input name="capacityByVolume" type="text" placeholder="capacityByVolume">
                </td>
                <td>
                    <input name="pricePerKm" type="text" placeholder="pricePerKm">
                </td>
                <td>
                    <select name="status" id="">
                        <option value="EMPTY">EMPTY</option>
                        <option value="RESERVED">RESERVED</option>
                        <option value="DEFECTIVE">DEFECTIVE</option>
                    </select>
                </td>
                <td>
                    <button class="btn-primary">Добавить</button>
                </td>
            </tr>
        </form>
        </tbody>
    </table>
    <div class="container">
    <%@include file="footer.jspf" %>
</div>
</body>
</html>
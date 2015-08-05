<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit trucks list</title>
</head>
<body>
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
                <input type="submit" value="Удалить"/>
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
                <button>Добавить</button>
            </td>
        </tr>
    </form>
</table>
</body>
</html>

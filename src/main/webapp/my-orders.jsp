<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<p>Мои заказы</p>
<form action="${pageContext.request.contextPath}/changingOrderStatus" method="post">
  <table>
    <tr>
      <td>Груз</td>
      <td>Откуда</td>
      <td>Куда</td>
      <td>Статус</td>
    </tr>
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
  </table>
  <button>Изменить</button>
</form>
</body>
</html>

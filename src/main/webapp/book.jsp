<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="order" scope="session" type="com.epam.transporter.entity.Order"/>
<!DOCTYPE html>
<html>
<head>
  <title>Book</title>
</head>
<body>
<p>Дистанция ${order.deliveryPoints.distance}</p>
<p>Стоимость ${order.price}</p>
<form method="get" action="${pageContext.request.contextPath}/book">
    <input type="submit" value="Забронировать"/>
</form>
</body>
</html>
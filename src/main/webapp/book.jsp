<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="price" scope="request" type="com.epam.transporter.logic.Price"/>
<!DOCTYPE html>
<html>
<head>
  <title>Book</title>
</head>
<body>
<p>Дистанция ${price.order.deliveryPoints.distance}</p>
<p>Стоимость ${price.price}</p>
<form method="get" action="${pageContext.request.contextPath}/book">
    <input type="submit" value="Забронировать"/>
</form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="price" scope="request" type="com.epam.transporter.logic.Price"/>
<!DOCTYPE html>
<html>
<head>
    <title>Info</title>
</head>
<body>
<p>Дистанция ${price.order.deliveryPoints.distance}</p>
<p>Стоимость ${price.price}</p>
</body>
</html>
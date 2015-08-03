<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="order" scope="request" type="com.epam.transporter.entity.Order"/>
<!DOCTYPE html>
<html>
<head>
    <title>Info</title>
</head>
<body>
<p>Дистанция ${order.deliveryPoints.distance}</p>
<p>Стоимость ${order.price}</p>
</body>
</html>
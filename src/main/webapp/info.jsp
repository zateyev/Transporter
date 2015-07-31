<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="deliveryPoints" scope="request" class="com.epam.transporter.entity.DeliveryPoints"/>
<!DOCTYPE html>
<html>
<head>
    <title>Info</title>
</head>
<body>
<p>Дистанция ${deliveryPoints.distance}</p>
</body>
</html>
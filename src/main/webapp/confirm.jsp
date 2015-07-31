<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="customer" scope="request" type="com.epam.transporter.entity.Customer"/>
<html>
<head>
    <title>Confirm</title>
</head>
<body>
<p>Уважаемый ${customer.firstName}, регистрация прошла успешно</p>
<a href="login.jsp">Войти на сайт</a>
</body>
</html>

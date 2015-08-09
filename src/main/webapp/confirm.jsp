<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="user" scope="request" type="com.epam.transporter.entity.User"/>
<html>
<head>
    <title>Confirm</title>
</head>
<body>
<p>Уважаемый ${user.firstName}, регистрация прошла успешно</p>
<a href="login.jsp">Войти на сайт</a>
</body>
</html>

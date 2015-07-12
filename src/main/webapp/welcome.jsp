<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean id="customer" scope="request" type="com.epam.transporter.entity.Customer"/>
<html>
<head>
    <title>WELCOME</title>
</head>
<body>
  <p>Welcome, ${customer.firstName}</p>
</body>
</html>

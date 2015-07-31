<%--@elvariable id="customer" type="com.epam.transporter.entity.Customer"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WELCOME</title>
    <link rel="stylesheet" href="main.css"/>
</head>
<body>
  <p>Welcome, ${customer.firstName}</p>
  <form method="get" action="${pageContext.request.contextPath}/logout">
      <input type="submit" value="Logout"/>
  </form>
<%@include file="order.jspf"%>
</body>
</html>

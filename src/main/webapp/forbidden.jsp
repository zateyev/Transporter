<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--@elvariable id="user" type="com.epam.transporter.entity.User"--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Запрещен</title>
  <link rel="stylesheet" href="webjars/bootstrap/3.3.2/dist/css/bootstrap.min.css"/>
  <link rel="stylesheet" href="jumbotron-narrow.css">
</head>
<body style="zoom: 1;">
<div class="container">
  <div class="header">
    <ul class="nav nav-pills pull-right">
      <li><a href="welcome.jsp"><span class="glyphicon glyphicon-home"></span> Главная</a></li>
      <li><a href="#">${user.firstName}</a></li>
      <li><a href="my-orders.jsp">Мои заказы</a></li>
      <li>
        <form method="get" action="${pageContext.request.contextPath}/logout">
          <button class="btn btn-default navbar-btn">Выйти</button>
        </form>
      </li>
    </ul>
    <h1 class="text-muted">Transporter</h1>
  </div>
  <h1>Forbidden</h1>
  <%@include file="footer.jspf" %>
</div>
</body>
</html>
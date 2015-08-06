<%@ page contentType="text/html; charset=UTF-8" language="java" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="language" value="${not empty param.language ? param.language : not empty language ? language : pageContext.request.locale}" scope="session" />
<fmt:setLocale value="${language}" />
<fmt:setBundle basename="i18n" />

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Document</title>
    <link rel="stylesheet" href="webjars/bootstrap/3.3.2/dist/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="jumbotron-narrow.css">
</head>
<body style="zoom: 1;">

<form>
    <select id="language" name="language" onchange="submit()">
        <option value="kk" ${language == 'kk' ? 'selected' : ''}>Қазақ</option>
        <option value="ru" ${language == 'ru' ? 'selected' : ''}>Русский</option>
        <option value="en" ${language == 'en' ? 'selected' : ''}>English</option>
    </select>
</form>

<div class="container">
    <div class="header">
        <ul class="nav nav-pills pull-right">
            <li class="active"><a href="#"><span class="glyphicon glyphicon-home"></span> <fmt:message key="nav.home" /></a></li>
            <li><a href="login.jsp"><fmt:message key="login" /></a></li>
            <li><a href="register.jsp"><fmt:message key="nav.reg" /></a></li>
        </ul>
        <h1 class="text-muted"><fmt:message key="project.name" /></h1>
    </div>

    <%@include file="order.jspf" %>
    <%@include file="content.jspf" %>
    <%@include file="footer.jspf" %>
</div>
</body>
</html>
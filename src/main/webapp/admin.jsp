<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin</title>
</head>
<body>
<p>Hello admin!</p>
<form method="get" action="${pageContext.request.contextPath}/logout">
  <input type="submit" value="Logout"/>
    <table>
        <tr>
            <td>Груз</td>
            <td>Откуда</td>
            <td>Куда</td>
        </tr>
    </table>
</form>
</body>
</html>

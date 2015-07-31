<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Sign up</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/register" method="post" class="form">
  <label>registration</label>
  <input name="firstName" type="text" placeholder="Name">
  <input name="email" type="text" placeholder="Your email">
  <input name="password" type="password" placeholder="Create a password">
  <button>Sign up</button>
</form>
</body>
</html>
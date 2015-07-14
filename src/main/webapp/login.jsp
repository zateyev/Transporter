<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Log in</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
<form action="${pageContext.request.contextPath}/login" method="post" class="form">
  <label>login</label>
  <input name="email" type="text" placeholder="email">
  <input name="password" type="password" placeholder="password">
  <button>Log in</button>
</form>
</body>
</html>
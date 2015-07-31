<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" href="main.css"/>
</head>
<body>
<a href="login.jsp">Вход</a>
<a href="register.jsp">Регистрация</a>
<form action="${pageContext.request.contextPath}/calculation" method="post" class="form">
  <div class="points">
    <label>Откуда</label>
    <input name="startingPoint" type="text" placeholder="Введите название местоположения">
    <label>Куда</label>
    <input name="destination" type="text" placeholder="Введите название местоположения">
  </div>
  <div class="description">
    <label>Вес</label>
    <input name="weight" type="text" placeholder="Введите вес товара, кг">
    <label>Объем</label>
    <input name="volume" type="text" placeholder="Введите объем товара, л">
    <label>Стоимость</label>
    <input name="cost" type="text" placeholder="Введите стоимость товара, тг">
  </div>
    <label>Комментарии</label>
    <input name="comment" type="text">
    <button>Расчитать</button>
</form>
</body>
</html>
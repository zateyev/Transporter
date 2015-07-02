<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form action="upload" method="post" enctype="multipart/form-data">
    <div>
        <input type="text" name="description" placeholder="Выберите xml-файл" />
        <input type="file" name="file" />
    </div>
    <br>
    <div>
        <input type="text" name="xsd-description" placeholder="Выберите xsd-файл" />
        <input type="file" name="xsd-file" />
    </div>
    <br>
    <div>
        <input type="submit" />
    </div>
</form>
</body>
</html>
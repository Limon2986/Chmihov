<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 13.07.2017
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<H1>Привет</H1>
<form action="vvod" method="post" name="Forma">
    id<input type="text" name="id" readonly = "true" value="${id}"/><br>
    name<input type="text" name="name" value="${name}"/><br>
    Proivoditel
    <select name = "Proivoditel">
        <option value = "russia">russia</option>
        <option value = "ukraina">ukraina</option>
        <option value = "japon">japon</option>
        <option value = "kitay">kitay</option>
    </select>
    <input value="save" type="submit"/>
</form>
</body>
</html>

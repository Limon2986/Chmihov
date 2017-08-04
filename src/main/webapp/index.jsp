<%--
  Created by IntelliJ IDEA.
  User: Администратор
  Date: 12.07.2017
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Моя страница.</title>
</head>
<body>
<a href="/marka">Доступные марки</a>
<a href="/vvod">Вdод</a>
<c:if test="${save}">
    <p>Данные сохранены</p>
        </c:if>
</body>
</html>

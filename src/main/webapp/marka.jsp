



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Моя страница.</title>
</head>
<body>
<H1>Доступные марки кофе</H1>

<c:forEach var="marka" items="${poxer}">
    <p><a href="/vvod?id=${marka.id}"> id = ${marka.id}, name = ${marka.name}</a> <a href="/delete?id=${marka.id}">delete</a> </p>

</c:forEach>



</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: TandTV
  Date: 2016/12/19
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>addFilm</title>
</head>
<body>
<form action="film?type=add" method="post">
title：<br><input type="text" name="title" id="title"><br>
description:<br><input type="text" name="description" id="description"><br>
language:<br>
<select name="language" id="language">
    <c:forEach items="${languages}" var="l">
        <%--<option value="${l.language_id}">${l.language_id}</option>--%>
        
        <option value="${l.language_id}">${l.name}</option>
    </c:forEach>
</select>
    <input type="submit" value="新增">
</form>
</body>
</html>

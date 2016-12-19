<%@ page import="com.jjx.daos.iDaos.IFilmDao" %>
<%@ page import="com.jjx.daos.daosImpl.FilmDaoImpl" %>
<%@ page import="com.jjx.beans.Film" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: TandTV
  Date: 2016/12/19
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ page language="java" pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>showAll</title>
</head>
<body>
<a href="film?type=showL">新增</a><br>
<a href="index.jsp">返回首页</a>
<table border="1">
    <tr>
        <th>film_id</th>
        <th>title</th>
        <th>description</th>
        <th>language</th>
        <th>update</th>
        <th>delete</th>
    </tr>
    <c:forEach items="${allFilm}" var="f">
        <tr>
            <td>${f.film_id}</td>
            <td>${f.title }</td>
            <td>${f.description }</td>
            <td>${f.language.name }</td>
            <td><a href="film?type=showL&fid=${f.film_id }">修改</a></td>
            <td><a href="film?type=delete&fid=${f.film_id }">删除</a></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

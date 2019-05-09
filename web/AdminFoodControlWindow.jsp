<%--
  Created by IntelliJ IDEA.
  User: Юля
  Date: 21.03.2019
  Time: 0:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Главная страница</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        /* Demo Background */
        body{background-color: #bdff93;)}
        .active{color: #bdff93;)}
    </style>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">
        <ul class="nav navbar-nav">
            <li class="active"><a href="/diaryf">Главная</a></li>
            <li><a href="/administration">Управление пользователями</a></li>
            <li><a href="/redact">Редактирование меню</a></li>
            <li><a href="/">Выйти</a></li>
        </ul>
    </nav>
</div>
<table>
    <tr>
        <th>Название</th>
        <th>КК</th>
        <th>Ж</th>
        <th>Б</th>
        <th>У</th>
        <th>Удалить</th>
    </tr>
    <form action="/redact" method="post">
    ${requestScope.tableFood}
        <tr>
            <td><input type="text" placeholder="name" name="foodName"></td>
            <td><input type="text" placeholder="kk" name="kk"></td>
            <td><input type="text" placeholder="fats" name="fats"></td>
            <td><input type="text" placeholder="prot" name="prot"></td>
            <td><input type="text" placeholder="carboh" name="carboh"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Удалить"></td>
            <td><input type="submit" value="Создать/Править"></td>
        </tr>
    </form>
</table>
${requestScope.errorWrongRights}
</body>
</html>

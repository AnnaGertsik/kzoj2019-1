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
            <li><a href="/diary">Дневник</a></li>
            <li><a href="#">Статистика</a></li>
            <li><a href="/change">Личный кабинет</a></li>
            <li><a href="/control">Добавить блюдо</a></li>
            <li><a href="/">Выйти</a></li>
        </ul>
    </nav>
</div>
<h4>
    <strong>
        <mark style="background-color: azure">Добро пожаловать, ${requestScope.userName}!</mark>
    </strong>
</h4>
${requestScope.previousOperation}
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Юля
  Date: 07.05.2019
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Управление</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <style>
        /* Demo Background */
        body{background-color: #8bff87;)}
        h2{text-align: center}
        /* Form Style */
        .form-horizontal{
            background: #fff;
            padding-bottom: 40px;
            border-radius: 15px;
            text-align: center;
        }
        .form-horizontal .heading{
            display: block;
            font-size: 35px;
            font-weight: 700;
            padding: 35px 0;
            border-bottom: 0px solid #f0f0f0;
            margin-bottom: -40px;
        }
        .form-horizontal .form-group{
            padding: 0 40px;
            margin: 0 0 25px 0;
            position: relative;
        }
        .form-horizontal .form-control{
            background: #f0f0f0;
            border: none;
            border-radius: 20px;
            box-shadow: none;
            padding: 0 20px 0 45px;
            height: 40px;
            transition: all 0.3s ease 0s;
        }
        .form-horizontal .form-control:focus{
            background: #e0e0e0;
            box-shadow: none;
            outline: 0 none;
        }
        .form-horizontal .form-group i{
            position: absolute;
            top: 12px;
            left: 60px;
            font-size: 17px;
            color: #c8c8c8;
            transition : all 0.5s ease 0s;
        }
        .form-horizontal .form-control:focus + i{
            color: #00b4ef;
        }
        .form-horizontal .main-checkbox label{
            width: 20px;
            height: 20px;
            position: absolute;
            top: 0;
            left: 0;
            cursor: pointer;
        }
        .form-horizontal .main-checkbox label:after{
            content: "";
            width: 10px;
            height: 5px;
            position: absolute;
            top: 5px;
            left: 4px;
            border: 3px solid #fff;
            border-top: none;
            border-right: none;
            background: transparent;
            opacity: 0;
            -webkit-transform: rotate(-45deg);
            transform: rotate(-45deg);
        }
        .form-horizontal .text{
            float: left;
            margin-left: 7px;
            line-height: 20px;
            padding-top: 5px;
            text-transform: capitalize;
        }
        .form-horizontal .btn{
            float: top;
            font-size: 14px;
            color: #fff;
            background: #00b4ef;
            border-radius: 30px;
            padding: 10px 25px;
            border: none;
            text-transform: capitalize;
            transition: all 0.5s ease 0s;
        }
        @media only screen and (max-width: 479px){
            .form-horizontal .form-group{
                padding: 0 25px;
            }
            .form-horizontal .form-group i{
                left: 45px;
            }
            .form-horizontal .btn{
                padding: 10px 20px;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <nav class="navbar navbar-default">
        <ul class="nav navbar-nav">
            <li><a href="/diaryf">Главная</a></li>
            <li><a href="/diary">Дневник</a></li>
            <li><a href="#">Статистика</a></li>
            <li><a href="/change">Личный кабинет</a></li>
            <li class="active"><a href="/control">Добавить блюдо</a></li>
            <li><a href="/">Выйти</a></li>
        </ul>
    </nav>
</div>
<h2><strong><mark style="background-color: azure">Добавьте новое блюдо</mark></strong></h2>
<form action="/control" method="post">
    <label for="name">Название<input type="text" id="name" name="name"></label>
    <label for="kkl">Калории<input type="number" id="kkl" name="kkl"></label>
    <label for="fats">Жиры<input type="text" id="fats" name="fats"></label>
    <label for="protein">Белки<input type="text" id="protein" name="protein"></label>
    <label for="carbs">Углеводы<input type="text" id="carbs" name="carbs"></label>
    <input type="submit" value="Добавить" class="btn btn-default">
</form>
${requestScope.errorEmptyField}
</body>
</html>

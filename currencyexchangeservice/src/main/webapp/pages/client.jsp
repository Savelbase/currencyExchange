<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <!-- Bootstrap CSS v5.0.2 -->

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

    <link href="${pageContext.request.contextPath}/resources/style/reg.css" rel="stylesheet">

</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand ms-4" href="#">EXCHANGE</a>
    <button class="navbar-toggler d-lg-none me-3" type="button" data-bs-toggle="collapse"
            data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId"
            aria-expanded="false" aria-label="Toggle navigation"></button>
    <div class="collapse navbar-collapse" id="collapsibleNavId">
        <ul class="navbar-nav me-auto mt-2 mt-lg-0">
            <li class="nav-item active ms-3">
                <a class="nav-link" href="/">Домой<span class="visually-hidden">(current)</span></a>
            </li>
            <li class="nav-item  ms-3">
                <a class="nav-link" href="/">Курсы</a>
            </li>
            <li class="nav-item dropdown  ms-3">
                <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-bs-toggle="dropdown"
                   aria-haspopup="true" aria-expanded="false">Наши услуги</a>
                <div class="dropdown-menu" aria-labelledby="dropdownId">
                    <a class="dropdown-item" href="/exchange">Обмен валют</a>
                    <a class="dropdown-item" href="/singUp">Регистрация</a>
                </div>
            </li>
            <li class="nav-item ms-3">
                <a class="nav-link" href="/signIn">Войти</a>
            </li>
        </ul>
    </div>
</nav>
<div class="main">
    <div class="col-md-6 col-sm-12">
        <div class="login-form">
            <form id="newClient">
                <div class="form-group">
                    <label for="login">Придумайте логин</label>
                    <input type="text" class="form-control" id="login" placeholder="Логин сдесь" required>
                </div>
                <div class="form-group">
                    <label for="password">Придумайте пароль</label>
                    <input type="password" class="form-control" id="password" placeholder="Пароль сдесь" required>
                </div>
                <input type="submit" class="btn btn-black mt-3" value="Создать аккаунт"/>
            </form>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/createClient.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>


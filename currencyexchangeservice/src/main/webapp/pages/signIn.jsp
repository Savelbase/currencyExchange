<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 17.12.2021
  Time: 13:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link href="${pageContext.request.contextPath}/resources/style/signInStyle.css" rel="stylesheet">

<div class="sidenav">
    <div class="login-main-text">
        <h2>EXCHANGE<br> Страница входа</h2>
        <p>Войдите или зарегестрируйтесь</p>
    </div>
</div>
<div class="main">
    <div class="col-md-6 col-sm-12">
        <div class="login-form">
            <form id="signInForm" >
                <div class="form-group">
                    <label for="login">Введите логин</label>
                    <input type="text" id="login" class="form-control" placeholder="User Name" required>
                </div>
                <div class="form-group">
                    <label for="password">Введите пароль</label>
                    <input type="password" id="password" class="form-control" placeholder="Password" required>
                </div>
                <button type="submit" class="btn btn-black mt-3" value="Login">Войти</button>
                <a href="${pageContext.request.contextPath}/singUp" class="btn btn-secondary mt-3">Регистрация</a>
            </form>
        </div>
    </div>
</div>
<script src="/resources/js/signin.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>
</body>
</html>

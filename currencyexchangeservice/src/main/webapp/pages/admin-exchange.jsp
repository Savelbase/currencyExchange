<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 13.12.2021
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="url" value="${pageContext.request.contextPath}"/>
<html>
<head><title>Title</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <link rel="stylesheet" href="${url}/resources/style/style.css">
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
        </ul>
    </div>
</nav>


<div class="form-label ms-4 mt-3">
    <form method="post" id="currency">
        <div class="data input-group">
            <div class="currencyChoose me-3">
                <label for="buy-currency" class="me-2">Продать : <br>
                    <select name="buy-currency" id="buy-currency" class="custom-select">
                        <option value="USD">USD</option>
                        <option value="UAH">UAH</option>
                        <option value="EUR">EUR</option>
                        <option value="RUB">RUR</option>
                    </select>
                </label>
                <label for="sell-currency">Купить : <br>
                    <select name="sell-currency" id="sell-currency" class="custom-select">
                        <option value="USD" disabled>USD</option>
                        <option value="UAH">UAH</option>
                        <option value="EUR">EUR</option>
                        <option value="RUB">RUR</option>
                    </select>
                </label>
            </div>

            <div class="fieldsForAmount">
                Сумма обмена :
                <label for="amount">
                    <input class="form-control " type="number" name="amount" id="amount">
                </label>
                <label for="sum" class="mt-1">
                    <input class="form-control" type="number" name="sum" id="sum" readonly>
                </label>
            </div>
            <div class="ms-3">
                <label>
                    <p class="mb-1">ID Пользователя</p>
                    <input type="text" name="user" id="user" class=" form-control w-50 h-25">
                </label>
            </div>

        </div>
        <input id="submit_button" type="submit" value="Transfer" class=" btn btn-outline-secondary ms-5 mt-3"></form>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
        crossorigin="anonymous"></script>

<script src="${url}/resources/js/script.js"></script>
</body>
</html>

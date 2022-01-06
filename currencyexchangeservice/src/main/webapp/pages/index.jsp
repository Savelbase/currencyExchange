<%--
  Created by IntelliJ IDEA.
  User: slava
  Date: 16.12.2021
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" isELIgnored="false" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="url" value="${pageContext.request.contextPath}"/>
<html>
<head>
    <title>Title</title>
   <!-- Bootstrap CSS -->
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <link rel="stylesheet" href="${url}/resources/style/style.css">
</head>
<body>
<nav class="navbar navbar-expand-md navbar-dark bg-dark">
    <a class="navbar-brand ms-4" href="/">EXCHANGE</a>
    <button class="navbar-toggler d-lg-none me-3" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId"
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
                <a class="nav-link dropdown-toggle" href="#" id="dropdownId" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Наши услуги</a>
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
<table class="table table-striped table-inverse table-responsive">
    <thead class="thead-default">
        <tr>
            <th>Код валюты</th>
            <th>Стоимость валюты</th>
        </tr>
        </thead>
        <tbody>
          <c:forEach var="c" items="${currencyList}">
           <tr>
               <th>${c.getCode()}</th>
               <th>${c.getRate()}</th>
           </tr>
          </c:forEach>
        </tbody>
</table>

</div>

<!-- Option 1: Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

<!-- Option 2: Separate Popper and Bootstrap JS -->
<!--
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" integrity="sha384-7+zCNj/IqJ95wo16oMtfsKbZ9ccEh31eOz1HGyDuCQ6wgnyJNSYdrPa03rtR1zdB" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js" integrity="sha384-QJHtvGhmr9XOIpI6YVutG+2QOK9T+ZnN4kzFN1RtK3zEFEIsxhlmWl5/YESvpZ13" crossorigin="anonymous"></script>
-->
</body>
</html>

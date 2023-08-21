<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="pl">
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <meta http-equiv="X-UA-Compatible" content="ie=edge" />
  <title>Document</title>
  <link rel="stylesheet" href="<c:url value="/resources/css/style.css"/>"/>
</head>
<body>
<header class="header--form-page">
  <nav class="container container--70">
    <ul class="nav--actions">
      <li class="logged-user">
        Witaj <sec:authentication property="principal.user.username"/>
        <ul class="dropdown">
          <li><a href="#">Profil</a></li>
          <li><a href="#">Moje zbiórki</a></li>
          <li><a href="/donations">Przekaż dar</a></li>
          <li><a href="/logout">Wyloguj</a></li>
        </ul>
      </li>
    </ul>

    <ul>
      <li><a href="/donations" class="btn btn--without-border active">Start</a></li>
      <li><a href="#steps" class="btn btn--without-border">O co chodzi?</a></li>
      <li><a href="#o_nas" class="btn btn--without-border">O nas</a></li>
      <li><a href="#pomoc" class="btn btn--without-border">Fundacje i organizacje</a></li>
      <li><a href="#contact_form" class="btn btn--without-border">Kontakt</a></li>
    </ul>
  </nav>

  <div class="slogan container container--90">
    <h2>
      Strona administratora
    </h2>
  </div>
</header>

<%@ include file="footer.jsp"%>

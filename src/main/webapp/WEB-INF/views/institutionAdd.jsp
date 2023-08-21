<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<header>
    <jsp:include page="adminHeader.jsp"/>
</header>

<h2>Dodaj instytucję</h2>
<form:form method="post" action="/admin/institution/add" modelAttribute="institutions">
<div class="form-group form-group--inline">
    <label>
        Nazwa instytucji:
        <form:input path="name"/>
    </label>
</div>
    <div class="form-group form-group--inline">
    <label>
        Opis instytucji:
        <form:input path="description"/>
    </label>
    </div>
    <button class="btn" type="submit">Dodaj</button>
</form:form>
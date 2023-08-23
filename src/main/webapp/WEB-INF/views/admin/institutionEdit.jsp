<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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

<h2>Edytuj instytucję</h2>
<form:form method="post" action="/admin/institution/edit" modelAttribute="institutions">
    <form:hidden path="id"/>
<div class="form-group form-group--inline">
    <label>
        Nazwa instytucji:
        <form:input class="w-100 p-1" path="name"/>
    </label>
</div>
<div class="form-group form-group--inline">
    <label>
        Opis instytucji:
        <form:input class="w-100 p-1" path="description"/>
    </label>
</div>
<button class="btn" type="submit">Zapisz</button>
</form:form>

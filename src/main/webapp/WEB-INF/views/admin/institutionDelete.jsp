<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
<html>
<head>
    <title></title>
</head>
<body>
<h2>Potwierdź usunięcie</h2>
<a href="/admin/delete-confirm/${institutions.id}" class="btn btn-warning rounded-0 text-light m-1" >Potwierdź</a>
<a href="/admin/institutionList/" class="btn btn-warning rounded-0 text-light m-1">Anuluj</a>
</body>
</html>

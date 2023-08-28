<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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

<section class="table-sub-heading-color">
  <h2>Adminstratorzy:</h2>
  <div class="table-tab">
    <table id="tableinstitutions" class="table" >
      <thead>
      <tr>
        <th>Nazwa</th>
<%--        <th>Opis</th>--%>
        <th>Akcje</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${admins}" var="admin">
        <tr>
          <td>${admin.username}</td>
          <td>
            <a href="/admin/admin/edit/${admin.id}">
              <button type="button" class="btn btn--small">Edytuj</button>
            </a>
            <a href="/admin/admin/delete/${admin.id}" class="delete-link">
              <button type="button" class="btn btn--small">Usuń</button>
            </a>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
    <c:if test='${delete.equals("failed")}'>
      <p class="error"> Nie można usunąć instytucji</p>
    </c:if>
    <a href="/admin/add">
      <button style="margin-right:30px;float:right" type="button" class="btn">Dodaj</button>
    </a>
  </div>
</section>
<script src="/js/app.js"/>"></script>
</body>
</html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="WEB-INF/pages/include.jsp"%>
<html>
<head>
    <title>Main</title>
</head>
<body>

  <nav>
    <c:if test="${inSystem}">
      <c:out value="${currentUserName}"/>
    </c:if>>
    <ul>
      <%--localhost:8080/author/add--%>
      <%--localhost:8080/library/author/add--%>
        <li><a href="login"/>Login</li>
        <li><a href="author/add"/>Add Author</li>
    </ul>
  </nav>
</body>
</html>

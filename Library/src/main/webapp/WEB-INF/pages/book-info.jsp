<%@include file="include.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <title>Book info</title>
</head>
<body>

<c:set var="varBook" value="${book}"/>

<h1>Book</h1>

name : <c:out value="${varBook.name}"/><br>
price: ${varBook.price}<br>
date : ${varBook.birthDay}<br>
book : ${varBook}<br>

</body>
</html>

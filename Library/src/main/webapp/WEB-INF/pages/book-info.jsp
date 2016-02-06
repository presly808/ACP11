<%@ page import="ua.artcode.library.model.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book info</title>
</head>
<body>
  <% Book book = (Book) request.getAttribute("book"); %>

  <h1>Book</h1>

  name : <%=book.getName()%><br>
  price: <%=book.getPrice()%><br>
  date : <%=book.getPublishDate()%><br>
  book : <%=book%><br>

</body>
</html>

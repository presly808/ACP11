<%@include file="include.jsp"%>
<html>
<head>
    <title>Login</title>
</head>
<body>

  <div class="row">
    <form action="/${APP_NAME}/login" method="post">
      id: <input name="id" type="password">
      name: <input name="name" type="text">
      <input type="submit">
    </form>
  </div>


</body>
</html>

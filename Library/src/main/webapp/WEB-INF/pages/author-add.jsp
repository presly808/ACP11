<%@include file="include.jsp"%>
<html>
<head>
    <title>Add author</title>
</head>
<body>

  <div id="row">
    <form action="/${APP_NAME}/author/add" method="post">
      Name : <input  name="name" type="text"><br>
      Salary : <input  name="salary" type="text"><br>
      Birthday : <input  name="birthday" type="text"><br>
      <input type="hidden" value="secret info">
      <input type="submit" value="send">
    </form>
  </div>
</body>
</html>

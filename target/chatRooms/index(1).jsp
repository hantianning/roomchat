<%--
  Created by IntelliJ IDEA.
  User: jyyr
  Date: 2019/10/21
  Time: 10:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">test</a>

    <form action="account/save" method="post">
        name : <input type="text" name="name"><br>
        money: <input type="text" name="money"><br>
        <input type="submit" value="save"/>
    </form>
</body>
</html>

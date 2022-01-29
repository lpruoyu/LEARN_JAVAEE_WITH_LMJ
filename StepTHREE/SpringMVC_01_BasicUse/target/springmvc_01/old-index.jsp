<%--
  Created by IntelliJ IDEA.
  User: lpruoyu
  Date: 2022-01-18
  Time: 15:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>INDEX</title>
</head>
<body>
<h1>This is index.jsp.</h1>
<form method="get" action="addUser">
    <div>
        用户名：<input name="username" type="text" placeholder="请输入用户名"/>
    </div>
    <div>
        密码：<input name="password" type="password" placeholder="请输入密码"/>
    </div>
    <div>
        <input type="submit" value="提交"/>
    </div>
</form>
</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h2>登录页面</h2>
<form action="/mvc03/encoding/login" method="post">
    <div><label>用户名：<input type="text" name="username"></label></div>
    <div><label>密码：<input type="password" name="password"></label></div>
    <div><input type="submit" value="登录"></div>
</form>
</body>
</html>

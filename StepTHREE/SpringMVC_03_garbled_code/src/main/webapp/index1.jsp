<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>garbled_code</title>
</head>
<body>
<h2>get</h2>
<form action="/mvc03/encoding/get" method="get">
    <div><label>用户名：<input type="text" name="username"></label></div>
    <div><label>密码：<input type="password" name="password"></label></div>
    <div><input type="submit" value="提交"></div>
</form>

<hr>
<h2>post</h2>
<form action="/mvc03/encoding/post" method="post">
    <div><label>用户名：<input type="text" name="username"></label></div>
    <div><label>密码：<input type="password" name="password"></label></div>
    <div><input type="submit" value="提交"></div>
</form>

<hr>

<h2>GetOrPost-get</h2>
<form action="/mvc03/encoding/GetOrPost" method="get">
    <div><label>用户名：<input type="text" name="username"></label></div>
    <div><label>密码：<input type="password" name="password"></label></div>
    <div><input type="submit" value="提交"></div>
</form>

<h2>GetOrPost-post</h2>
<form action="/mvc03/encoding/GetOrPost" method="post">
    <div><label>用户名：<input type="text" name="username"></label></div>
    <div><label>密码：<input type="password" name="password"></label></div>
    <div><input type="submit" value="提交"></div>
</form>

</body>
</html>

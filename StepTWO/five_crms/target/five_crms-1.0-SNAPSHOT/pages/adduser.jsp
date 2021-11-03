<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>add user</title>
</head>
<body>

<%--有浏览器完成操作，需要告诉浏览器context path--%>
<form action="/five_crms/adduser" method="post">
    <div>姓名：<input type="text" name="username"></div>
    <div>年龄：<input type="text" name="userage"></div>
    <div>身高：<input type="text" name="usertall"></div>
    <br>
    <br>
    <br>
    <div>
        <button type="submit">保存</button>
    </div>
</form>
</body>
</html>
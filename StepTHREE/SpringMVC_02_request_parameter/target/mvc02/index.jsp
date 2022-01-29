<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index——request_parameter</title>
</head>
<body>
<form action="/mvc02/skill/add" method="post">
    <div><label>用户名：<input type="text" name="username"></label></div>
    <div><label>密码：<input type="password" name="password"></label></div>
    <div>
        <label>级别：
            <select name="level">
                <option id="1">1</option>
                <option id="2">2</option>
                <option id="3">3</option>
            </select>
        </label>
    </div>
    <div><input type="submit" value="提交"></div>
</form>
</body>
</html>

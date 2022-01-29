<%--
  Created by IntelliJ IDEA.
  User: lpruoyu
  Date: 2022-01-24
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<%request.setAttribute("ctx", request.getContextPath());%>
<form method="get" action="${ctx}/test3/demo1">
    <div>姓名：<input type="text" name="name"></div>
    <div>年龄：<input type="number" name="age"></div>
    <div>
        兴趣爱好：
        <div>篮球<input type="checkbox" value="basketball" name="hobby"></div>
        <div>足球<input type="checkbox" value="football" name="hobby"></div>
        <div>乒乓球<input type="checkbox" value="pingpang" name="hobby"></div>
    </div>
    <div><input type="submit" value="提交"></div>
</form>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: lpruoyu
  Date: 2022-01-25
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<!-- chrome客户端的日期类型默认格式为yyyy-MM-dd -->
<div>demo1</div>
<form action="${pageContext.request.contextPath}/test1/demo1">
    <div>生日：<input type="date" name="birthday"></div>
    <div><input type="submit" value="提交"></div>
</form>
<div>demo2</div>
<form action="${pageContext.request.contextPath}/test1/demo2">
    <div>生日：<input type="date" name="birthday"></div>
    <div><input type="submit" value="提交"></div>
</form>
<div>demo2</div>
<form action="${pageContext.request.contextPath}/test1/demo3">
    <div>生日：<input type="date" name="birthday"></div>
    <div><input type="submit" value="提交"></div>
</form>
</body>
</html>

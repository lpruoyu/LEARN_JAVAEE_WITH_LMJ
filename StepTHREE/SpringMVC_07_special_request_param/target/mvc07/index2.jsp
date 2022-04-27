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
<!-- enctype 默认为 application/x-www-form-urlencoded -->
<!-- 要想上传文件，表单必须满足两个条件：1.method为post 2.enctype为multipart/form-data -->
<form method="post" action="${ctx}/test4/demo1" enctype="multipart/form-data">
    <div>用户名：<input type="text" name="username"></div>
    <div>密 码：<input type="password" name="password"></div>
    <div><input type="submit" value="提交"></div>
</form>
</body>
</html>

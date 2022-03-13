<%--
  Created by IntelliJ IDEA.
  User: lpruoyu
  Date: 2022-01-28
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("ctx", request.getContextPath()); %>
<html>
<head>
    <title>Skill</title>
</head>
<body>

<div>
    保存
    <form action="${ctx}/skill/save" method="post">
        <input name="id" placeholder="id">
        <input name="name" placeholder="name">
        <input name="level" placeholder="level">
        <button type="submit">保存</button>
    </form>
</div>

<div>
    删除
    <form action="${ctx}/skill/remove" method="post">
        <input name="id" placeholder="id">
        <button type="submit">删除</button>
    </form>
</div>

</body>
</html>

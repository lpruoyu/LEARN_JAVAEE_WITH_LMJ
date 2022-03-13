<%--
  Created by IntelliJ IDEA.
  User: lpruoyu
  Date: 2022-02-08
  Time: 11:46
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("ctx", request.getContextPath()); %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Skill</title>
</head>
<body>

<c:forEach var="a" begin="1" end="10" step="1">
    ${a}
</c:forEach>


<div>
    int
    <form action="${ctx}/test6" method="post" enctype="multipart/form-data">
        <div><input name="file" type="file"></div>
        <div><input name="name" type="text"></div>
        <button type="submit">提交</button>
    </form>
</div>


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
<div>
    test3
    <form action="${ctx}/test3" method="post">
        <input name="info">
        <button type="submit">提交</button>
    </form>
</div>

<div>
    请求参数——日期
    <form action="${ctx}/test4" method="get">
        <input name="birthday" type="date">
        <button type="submit">提交</button>
    </form>
</div>

<div>
    int
    <form action="${ctx}/test4" method="get">
        <input name="number" type="number">
        <button type="submit">提交</button>
    </form>
</div>

</body>
</html>


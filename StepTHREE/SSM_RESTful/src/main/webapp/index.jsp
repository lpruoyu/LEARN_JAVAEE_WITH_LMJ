<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("ctx", request.getContextPath()); %>
<html>
<head>
    <title>skills</title>
</head>
<body>
<%
    String ctx = request.getContextPath();
%>

<div>get请求</div>
<div>请求——所有</div>
<div>
    <form action="<%=ctx%>/skills" method="get">
        <input type="submit" value="提交">
    </form>
</div>
<div>请求——id=17</div>
<div>
    <form action="<%=ctx%>/skills/17" method="get">
        <input type="submit" value="提交">
    </form>
</div>

<div>post请求</div>
<div>
    <form action="<%=ctx%>/skills" method="post">
        name：<input name="name">
        level：<input name="level">
        <input type="submit" value="提交">
    </form>
</div>

<div>delete请求</div>
<div>
    <form action="${ctx}/skills/10" method="post">
        <input type="hidden" name="_method" value="delete">
        <input type="submit" value="提交">
    </form>
</div>

<div>put请求</div>
<div>
    <form action="${ctx}/skills/10" method="post">
        <input type="hidden" name="_method" value="put">
        name：<input name="name">
        level：<input name="level">
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>

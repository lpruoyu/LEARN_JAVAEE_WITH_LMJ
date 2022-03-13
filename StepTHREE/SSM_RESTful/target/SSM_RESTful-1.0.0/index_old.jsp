<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("ctx", request.getContextPath()); %>
<html>
<head>
    <title>Skill</title>
</head>
<body>
<%
    String ctx = request.getContextPath();
%>
<div>users——get</div>
<div>
    <form action="<%=ctx%>/test/users" method="get">
        <input type="submit" value="提交">
    </form>
</div>
<div>users——post</div>
<div>
    <form action="<%=ctx%>/test/users" method="post">
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>

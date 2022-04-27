<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% request.setAttribute("ctx", request.getServletContext().getContextPath()); %>
<html>
<head>
    <title>index</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/file/demo1" enctype="multipart/form-data">
    <div>用户名：<input type="text" name="username"></div>
    <div>
        头像：<input type="file" name="photo">
    </div>
    <div><input type="submit" value="提交"></div>
</form>

<a href="${ctx}/file/download">下载文件</a>

</body>
</html>

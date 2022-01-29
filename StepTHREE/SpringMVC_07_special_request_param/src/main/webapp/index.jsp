<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>index</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/date/demo2">
    <div>姓名：<input type="text" name="username"></div>
    <%-- chrome客户端发过去的日期类型为：yyyy-MM-dd --%>
    <div>生日：<input type="date" name="birthday"></div>
    <div><input type="submit" value="提交"></div>
</form>
</body>
</html>

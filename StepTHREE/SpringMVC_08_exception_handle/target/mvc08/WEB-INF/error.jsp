<%--
  Created by IntelliJ IDEA.
  User: lpruoyu
  Date: 2022-01-26
  Time: 13:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>出异常啦！</div>
<div>
    <%
        StringBuilder sb = new StringBuilder();
        Throwable throwable = exception;
        do {
            sb.append(throwable.getClass())
                    .append("——")
                    .append(throwable.getMessage())
                    .append("<br>");
            throwable = throwable.getCause();
        } while (throwable != null);
    %>
    <text><%=sb.toString()%></text>
</div>
<div>
    <%--  根据异常做出相应的处理  --%>
    <p><%=exception%></p>
</div>
</body>
</html>

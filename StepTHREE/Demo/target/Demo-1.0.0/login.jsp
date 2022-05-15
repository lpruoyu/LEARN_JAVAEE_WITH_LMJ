<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>
<body>
<div>
    <h3>欢迎登录</h3>
    <form action="<%=request.getContextPath()%>/login" method="get">
        <p style="color: red">${error}</p>
        <input style="display: inline-block;width: 200px" type="text" name="username" required placeholder="username"><br><br>
        <input style="display: inline-block;width: 200px" type="password" name="password" required placeholder="password"><br><br>
        <input style="width: 200px;color: blue" type="submit" value="login">
    </form>
</div>
</body>
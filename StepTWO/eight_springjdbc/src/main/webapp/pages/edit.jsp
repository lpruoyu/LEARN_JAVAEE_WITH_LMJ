<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>update</title>
</head>
<body>
<form action="/eight_springjdbc/customer/update" method="post">
    <%--    <div style="height: 0; display: none;"><input type="text" name="customer_id" value="${customer.id}"></div>--%>
    <div><input type="hidden" name="customer_id" value="${customer.id}"></div>
    <div>姓名：<input type="text" name="customer_name" value="${customer.name}"></div>
    <div>年龄：<input type="number" name="customer_age" value="${customer.age}"></div>
    <div>身高：<input type="text" name="customer_height" value="${customer.height}"></div>
    <div>
        <button type="submit">保存</button>
    </div>
</form>
</body>
</html>

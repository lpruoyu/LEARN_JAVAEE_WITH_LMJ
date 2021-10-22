<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>
        <c:choose>
            <c:when test="${empty customer}">
                add-customer
            </c:when>
            <c:otherwise>
                edit-customer
            </c:otherwise>
        </c:choose>
    </title>
</head>
<body>
<form action="/eight_javascript/customer/save" method="post">
    <c:if test="${not empty customer}">
        <div><input type="hidden" name="customer_id" value="${customer.id}"></div>
    </c:if>
    <div>姓名：<input type="text" name="customer_name" value="${customer.name}"></div>
    <div>年龄：<input type="number" name="customer_age" value="${customer.age}"></div>
    <div>身高：<input type="text" name="customer_height" value="${customer.height}"></div>
    <div>
        <button type="submit">
            <c:if test="${empty customer}">
                添加
            </c:if>
            <c:if test="${not empty customer}">
                更新
            </c:if>
        </button>
    </div>
</form>
</body>
</html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>list</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
            width: 500px;
            text-align: center;
        }
    </style>
</head>
<body>
<h1 style="color: green">总共有${customerSize}个客户</h1>
<table>
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>身高</th>
    </tr>

    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.age}</td>
            <td>${customer.height}</td>
            <td><a href="/eight_javascript/customer/edit?id=${customer.id}">编辑</a></td>
            <td><a href="/eight_javascript/customer/remove?id=${customer.id}">删除</a></td>
        </tr>
    </c:forEach>

</table>

<br>
<a href="/eight_javascript/pages/save.jsp">添加客户</a>

</body>
</html>

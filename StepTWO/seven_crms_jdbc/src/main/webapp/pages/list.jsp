<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>客户数据</title>
    <style>
        table, tr, th, td {
            border: 1px solid black;
            text-align: center;
        }

        th, td {
            display: inline-block;
            width: 200px;
        }

    </style>
</head>
<body>


<h1>总共有${customerSize}个客户</h1>

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
        </tr>
    </c:forEach>

</table>

<br>
<div><a href="../pages/addcustomer.html">添加客户</a></div>

</body>
</html>

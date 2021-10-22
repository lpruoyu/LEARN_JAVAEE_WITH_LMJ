<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>error</title>
    <style>
        html, body, h1 {
            color: red;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>${error}</h1>

<br>
<br>
<a href="/eight_springjdbc/customer/list">返回用户页面</a>
</body>
</html>

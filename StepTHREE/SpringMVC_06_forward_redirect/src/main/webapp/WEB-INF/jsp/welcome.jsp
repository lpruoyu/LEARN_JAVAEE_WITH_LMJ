<%--
  Created by IntelliJ IDEA.
  User: lpruoyu
  Date: 2022-01-23
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>WELCOME</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }

        html, body {
            height: 100%;
            width: 100%;
            position: fixed;
        }

        h2 {
            width: 50%;
            height: 50%;
            position: absolute;
            top: 50%;
            left: 50%;
            transform: translateX(-50%) translateY(-50%);
            display: flex;
            align-items: center;
            justify-content: center;
        }
    </style>
</head>
<body>
<h2 style="color: blueviolet;">WELCOME! 欢迎用户：<font color="green">&nbsp;${username}&nbsp;</font>回来！</h2>
</body>
</html>

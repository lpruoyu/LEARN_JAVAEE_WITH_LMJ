<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>dog</title>
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
<h2>This is a dog, his name:${dog.name}, his age:${dog.age}.</h2>
</body>
</html>

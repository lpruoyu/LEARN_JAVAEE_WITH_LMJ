<%@page contentType="text/html; utf-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setAttribute("ctx", request.getContextPath());%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>LP教育-Error</title>
    <link rel="icon" href="${ctx}/static/asset/admin/img/favicon.png" type="image/x-icon">
    <link href="${ctx}/static/asset/plugin/bootstrap/bootstrap.min.css" rel="stylesheet">
    <link href="${ctx}/static/asset/plugin/node-waves/waves.css" rel="stylesheet">
    <link href="${ctx}/static/asset/plugin/animate-css/animate.min.css" rel="stylesheet">
    <link href="${ctx}/static/asset/admin/css/material-icons.css" rel="stylesheet">
    <link href="${ctx}/static/asset/admin/css/style.min.css" rel="stylesheet">
    <link href="${ctx}/static/asset/admin/css/main.css" rel="stylesheet">
</head>

<body class="five-zero-zero">
<div class="five-zero-zero-container">
    <div class="error-title">喔豁，出错了</div>
    <div class="error-msg">
        <c:choose>
            <c:when test="${empty error}">
                很抱歉
            </c:when>
            <c:otherwise>
                ${error}
            </c:otherwise>
        </c:choose>
    </div>
    <div class="button-place">
        <a href="#" class="btn btn-default btn-lg waves-effect">回到首页</a>
    </div>
</div>
</body>

</html>
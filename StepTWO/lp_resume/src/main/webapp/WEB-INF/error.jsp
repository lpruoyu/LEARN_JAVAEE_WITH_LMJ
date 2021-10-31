<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>LP教育-Error</title>
    <%@ include file="common/head.jsp" %>
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
        <a href="${ctx}/WEB-INF/index.html" class="btn btn-default btn-lg waves-effect">回到首页</a>
    </div>
</div>
</body>

</html>
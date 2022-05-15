<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isELIgnored="false" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<body>
<div>
    <form action="<%=request.getContextPath()%>/fileup" method="post" enctype="multipart/form-data">
        上传<input type="file" name="file"><br>
        <input type="submit" value="上传">
    </form>
</div>
<div>
    <c:forEach items="${filelist}" var="li">
        <a href="${pageContext.request.contextPath}/download?filename=${li}">${li}</a><br>
    </c:forEach>
</div>
</body>
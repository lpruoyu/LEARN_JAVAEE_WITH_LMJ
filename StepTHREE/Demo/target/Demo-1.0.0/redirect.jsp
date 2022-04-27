<%--
  Created by IntelliJ IDEA.
  User: lpruoyu
  Date: 2022-04-18
  Time: 10:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>redirect</title>
</head>
<body>

<div>This is redirect.jsp!</div>

<c:forEach var="i" begin="1" end="10">
    <p>${i}</p>
</c:forEach>

</body>
</html>

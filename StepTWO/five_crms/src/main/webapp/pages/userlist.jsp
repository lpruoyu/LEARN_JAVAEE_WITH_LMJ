<%--  page指令下的contentType相当于response.setContentType  --%>
<%--  因为JSP的本质就是Servlet  --%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--  因为是core库，所以prefix简写为c即可  --%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>user list</title>
    <style>
        th, td {
            border: 1px solid black;
        }
    </style>
</head>
<body>

<%--由服务器完成，只需要告诉相对路径--%>
<a href="pages/adduser.jsp">添加</a>

<table>
    <thead>
    <tr>
        <th>姓名</th>
        <th>年龄</th>
        <th>身高</th>
    </tr>
    </thead>
    <tbody>

    <%--
            items中的${argument}相当于
            通过request.getAttribute("argument")
            得到request的attribute中的对象



    --%>
    <c:forEach items="${customers}" var="customer">
        <tr>
            <td>${customer.name}</td>
            <td>${customer.age}</td>
            <td>${customer.tall}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>

</body>
</html>
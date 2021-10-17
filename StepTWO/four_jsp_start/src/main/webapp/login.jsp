<%@ page import="java.util.ArrayList" %>
<%@ page import="coder.lp.four_jsp_start.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>login</title>
</head>
<body>
<%!

    private String getSuccessfulDataString() {

        final List<Customer> list = getDataList();

        Customer customer;
        StringBuilder sb = new StringBuilder();
        sb.append("<table>\n" +
                "    <thead>\n" +
                "    <th>姓名</th>\n" +
                "    <th>性别</th>\n" +
                "    <th>电话</th>\n" +
                "    </thead>\n" +
                "    <tbody>\n");
        for (int i = 0; i < list.size(); i++) {
            customer = list.get(i);
            sb.append("<tr> <td >");
            sb.append(customer.getName());
            sb.append("</td > <td >");
            sb.append(customer.getSex());
            sb.append("</td > <td >");
            sb.append(customer.getPhone());
            sb.append("</td > </tr>");
        }
        sb.append("    </tbody>\n" +
                "</table>");
        return sb.toString();
    }

    private List<Customer> getDataList() {
        List<Customer> list = new ArrayList<>();

        // 读取数据
        // for (int i = 0; i < 10; i++) {
        //     list.add(new Customer("张三" + i, "1211531125" + i, (((i & 1) == 1)) ? "男" : "女"));
        // }

        // 数据应该是从数据库读取的

        return list;
    }
%>

<%
    request.setCharacterEncoding("UTF-8");
    response.setContentType("text/html;charset=UTF-8");

    String username = request.getParameter("username");
    String userpswd = request.getParameter("userpswd");

    System.out.println("username : " + username + " , userpwd : " + userpswd);

    if ("123".equals(username) && "123".equals(userpswd)) {
%>
        <h1 style="color: blue; border: 2px solid black">登录成功</h1>
        <%=getSuccessfulDataString()%>
<%  } else {
%>
        <h1 style="color: red; border: 2px solid black">登录失败</h1>
        <a href="http://localhost:8080/jspstart/login.html">返回首页</a>
<%
    }
%>

</body>
</html>
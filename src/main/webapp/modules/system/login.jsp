<%--
  Created by IntelliJ IDEA.
  Date: 2019/12/19
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%
    String basePath=request.getContextPath();
%>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="<%=basePath%>/user/login/login.do" method="post">
    <input type="text" name="userid" id="userid"/>
    <input type="text" name="password" id="password"/>
    <input type="submit" value="登录" />
</form>

</body>
</html>

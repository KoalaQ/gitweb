<!DOCTYPE html>
<%
    String basePath = request.getContextPath();
%>
<html>
<head>
    <meta charset="utf-8">
    <title>Bootstrap 实例 - 分页的状态</title>



    <script src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>
    <!-- 包括所有已编译的插件 -->
    <script src="<%=basePath%>/js/bootstrap-3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet" href="<%=basePath%>/js/bootstrap-3.3.7/css/bootstrap.min.css"/>

    <link rel="stylesheet" href="<%=basePath%>/css/modules/article/articlelist.css"/>
</head>
<body>

<ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <li class="active"><a href="#">1</a></li>
    <li class="disabled"><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>

</body>
</html>
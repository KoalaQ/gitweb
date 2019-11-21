<%--
  Created by IntelliJ IDEA.
  User: LomeL
  Date: 2019/11/20
  Time: 20:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getContextPath();
%>
<html>
<head>
    <title>Title</title>
</head>
<link rel="stylesheet" href="<%=basePath%>/editormd/css/editormd.preview.css" />
<script src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>
<script src="<%=basePath%>/editormd/editormd.min.js"></script>

<link rel="stylesheet" href="<%=basePath%>/editormd/css/style.css" />
<link rel="stylesheet" href="<%=basePath%>/editormd/css/editormd.css" />



<body>
<div id="editor">
    <!-- Server-side output Markdown text -->
    <textarea style="display:none;">### Hello Editor.md !</textarea>
</div>
</body>

<script type="text/javascript">
    $(function() {
        var editor = editormd("editor", {
            width   : "90%",
            height  : 640,
            syncScrolling : "single",
            path : "<%=basePath%>/editormd/lib/"  // Autoload modules mode, codemirror, marked... dependents libs path
        });
    });
</script>

</html>

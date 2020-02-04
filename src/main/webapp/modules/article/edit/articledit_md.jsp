<%@ page import="constant.ENArticletype" %><%--
  Created by IntelliJ IDEA.
  User: lyd
  Date: 2020/1/8
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/modules/common/include.jsp" %>
<html>
<head>
    <title>文章修改</title>
    <script src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>/editormd/editormd.min.js"></script>
    <script src="<%=basePath%>/editormd/lib/marked.min.js"></script>
    <script src="<%=basePath%>/editormd/lib/prettify.min.js"></script>

    <script src="<%=basePath%>/editormd/lib/raphael.min.js"></script>
    <script src="<%=basePath%>/editormd/lib/underscore.min.js"></script>
    <script src="<%=basePath%>/editormd/lib/sequence-diagram.min.js"></script>
    <script src="<%=basePath%>/editormd/lib/flowchart.min.js"></script>
    <script src="<%=basePath%>/editormd/lib/jquery.flowchart.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap/js/bootstrap.min.js"></script>
    <script src="<%=basePath%>/js/bs4/bs4.pop.js"></script>


    <link rel="stylesheet" href="<%=basePath%>/editormd/css/style.css"/>
    <link rel="stylesheet" href="<%=basePath%>/editormd/css/editormd.css"/>
    <link rel="stylesheet" href="<%=basePath%>/editormd/css/editormd.preview.css"/>
    <link rel="stylesheet" href="<%=basePath%>/js/bootstrap/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="<%=basePath%>/js/bs4/bs4.pop.css"/>

    <script>
        function savearticle() {
            var editlog=$("#editlog").val();
            if(strIsNull(editlog)){
                alert("更新日志必填！");
                return;
            }
            $.ajax({
                async: false,
                //请求方式
                type: "POST",
                //请求地址
                url: "<%=basePath%>/article/editarticle.do",
                //数据
                data :  $('#articleform').serialize(),
                dataType: "JSON",
                //请求成功
                success: function (result) {
                    if(result.retcode=="1" && result.retstatus=="1"){
                        //bs4pop.notice("修改成功", {position: "topcenter"});
                        alert("修改成功");
                        window.location.href="<%=basePath%>/modules/article/articledetail.jsp?articletype=<%=ENArticletype.MARKDOWN.getValue()%>&articleid=${param.articleid}";
                    }else{
                        alert(result.retdata);
                    }
                },
                //请求失败，包含具体的错误信息
                error: function (e) {
                    console.log(e.status);
                    console.log(e.responseText);
                    alert(e.responseText);
                }
            });

        }
    </script>
</head>
<body>
<form  id="articleform">
    <input type="hidden" name="urid" value="${param.articleid}"/>
    <div id="top" style="height: 35px;">
        <div style="width: 100%;">
            <button type="button" id="save" onclick="savearticle()" class="btn btn-primary"
                    style="margin-left: 5px;margin-top: 5px;margin-bottom: 5px;float: left">保存
            </button>
        </div>
        <div class="form-group" style="width: 100%;clear:both;">
            <label for="title" style="float: left;margin-left: 5px">标题:</label>
            <input type="text"  class="form-control" style="width: 90%;float: right;" name="title" id="title" >
        </div>
        <div class="form-group" style="width: 100%;clear:both;">
            <label for="abstractcontent" style="float: left;margin-left: 5px">摘要:</label>
            <input type="text"  class="form-control" style="width: 90%;float: right;" name="abstractcontent" id="abstractcontent" >
        </div>
        <div class="form-group" style="width: 100%;clear:both;">
            <label for="editlog" style="float: left;margin-left: 5px">更新日志:</label>
            <input type="text"  class="form-control" style="width: 90%;float: right;" name="editlog" id="editlog" placeholder="请输入更新日志,可填写工单号..." >
        </div>

    </div>
    <div id="editor">
        <!-- Server-side output Markdown text -->
        <textarea id="contenttxt">### Hello world!请稍后。。。</textarea>
    </div>
</form>

</body>

<script>

    $(function () {
        $.ajax({
            //请求方式
            type: "GET",
            //请求的媒体类型
            contentType: "application/json;charset=UTF-8",
            //请求地址
            url: "<%=basePath%>/article/queryarticle.do?articleid=${param.articleid}",
            //数据，json字符串
            // data : JSON.stringify(list),
            //请求成功
            success: function (result) {
                var resultobj = $.parseJSON(result);
                var text = "";
                if (resultobj.retstatus == "1") {
                    var contentobj = $.parseJSON(resultobj.retdata);
                    text = contentobj.content;
                    $("#title").val(contentobj.title);
                    $("#abstractcontent").val(contentobj.abstractcontent);
                    // parent.setinfo(contentobj);
                } else {
                    text = resultobj.retdata;
                }
                $("#contenttxt").val(text);
                var testView = editormd("editor", {
                    name:"content",
                    width: "100%",
                    height: "77%",
                    syncScrolling: "single",
                    path: "<%=basePath%>/editormd/lib/"  // Autoload modules mode, codemirror, marked... dependents libs path
                });
            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                console.log(e.status);
                console.log(e.responseText);
            }
        });

    });
</script>
</html>

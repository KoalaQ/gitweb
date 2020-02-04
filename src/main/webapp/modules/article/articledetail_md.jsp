<%--
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
    <title>文章详情</title>
    <script src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>/editormd/editormd.min.js"></script>
    <script src="<%=basePath%>/editormd/lib/marked.min.js"></script>
    <script src="<%=basePath%>/editormd/lib/prettify.min.js"></script>

    <script src="<%=basePath%>/editormd/lib/raphael.min.js"></script>
    <script src="<%=basePath%>/editormd/lib/underscore.min.js"></script>
    <script src="<%=basePath%>/editormd/lib/sequence-diagram.min.js"></script>
    <script src="<%=basePath%>/editormd/lib/flowchart.min.js"></script>
    <script src="<%=basePath%>/editormd/lib/jquery.flowchart.min.js"></script>


    <link rel="stylesheet" href="<%=basePath%>/editormd/css/style.css"/>
    <link rel="stylesheet" href="<%=basePath%>/editormd/css/editormd.css"/>
    <link rel="stylesheet" href="<%=basePath%>/editormd/css/editormd.preview.css"/>

    <style>
        body {padding: 40px;}

        #layout > header, .btns {
            width: auto;
        }
        #custom-toc-container {
            padding-left: 0;
        }

        #custom-toc-container {
            padding-left: 0;
        }
        #sidebar {
            width: 410px;
            height: 100%;
            position: fixed;
            top: 0;
            left: 0;
            overflow: hidden;
            background: #fff;
            z-index: 100;
            padding: 18px;
            border: 1px solid #ddd;
            border-top: none;
            border-bottom: none;
        }

        #sidebar:hover {
            overflow: auto;
        }

        #sidebar h1 {
            font-size: 16px;
        }

        #test-markdown-view {
            padding-right: 0;
            padding-left: 430px;
            margin: 0;
        }
    </style>

</head>
<body>
<div id="layout">
    <div id="sidebar">
        <h1>Table of Contents</h1>
        <div class="markdown-body editormd-preview-container" id="custom-toc-container"></div>
    </div>
    <div id="test-markdown-view">
        <!-- Server-side output Markdown text -->
        <textarea id="contenttxt" style="display:none;">### Hello world!请稍后。。。</textarea>
    </div>
</div>
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
                    parent.setinfo(contentobj);
                } else {
                    text = resultobj.retdata;
                }
                //$("#contenttxt").val(text);
                var testView = editormd.markdownToHTML("test-markdown-view", {
                    markdown: text,//+ "\r\n" + $("#append-test").text(),
                    //htmlDecode      : true,       // 开启 HTML 标签解析，为了安全性，默认不开启
                    htmlDecode: "style,script,iframe",  // you can filter tags decode
                    //toc             : false,
                    tocm: true,    // Using [TOCM]
                    tocContainer: "#custom-toc-container", // 自定义 ToC 容器层
                    //gfm             : false,
                    //tocDropdown     : true,
                    // markdownSourceCode : true, // 是否保留 Markdown 源码，即是否删除保存源码的 Textarea 标签
                    emoji: true,
                    taskList: true,
                    tex: true,  // 默认不解析
                    flowChart: true,  // 默认不解析
                    sequenceDiagram: true,  // 默认不解析
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

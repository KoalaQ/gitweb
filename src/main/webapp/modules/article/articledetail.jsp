<%@ page import="constant.ENArticletype" %><%--
  Created by IntelliJ IDEA.
  User: lyd
  Date: 2020/2/3
  Time: 19:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/modules/common/include.jsp" %>

<html>
<head>
    <title>文章详情</title>
    <script src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>/js/bootstrap-3.3.7/css/bootstrap.min.css"/>
</head>
<body>
<div>
    <div style="float: left;margin-left: 5px;margin-top: 5px">
        <button type="button" id="edit" onclick="edit(${param.articleid})" class="btn btn-primary">修改</button>
    </div>
    <div style="float: right;font-size: 12px"><span id="articleinfo"></span></div>

</div>
<iframe id="detailarc" width="100%" height="90%" frameborder="0"></iframe>
</body>
</html>
<script>
    $(function () {
        var url="";
        var articleid=${param.articleid};
        var articletype=${param.articletype==null? "":param.articletype};
        if(articletype==undefined || articletype==""|| articletype==null){
            alert("文章类型异常！");
            return;
        }
        if("<%=ENArticletype.MARKDOWN.getValue()%>"==articletype){
            url="<%=basePath%>/modules/article/articledetail_md.jsp?articleid="+articleid;
        }else if("<%=ENArticletype.TXT.getValue()%>"==articletype){
            alert("暂未支持！");
            return;
        }
        document.getElementById("detailarc").src=url;
        //window.location.href=url;
    });
    function setinfo(data) {
        if(data!=null && data!=undefined && data!=""){
            var infotxt="创建人："+data.createdby+",最后更新时间："+data.lastmodifiedon+",更新日志："+data.editlog;
            $("#articleinfo").html(infotxt);
        }
    }
    function edit(articleid) {
        var articletype=${param.articletype==null? "":param.articletype};
        if(articletype==undefined || articletype==""|| articletype==null){
            alert("文章类型异常！");
            return;
        }
        var url="";
        if("<%=ENArticletype.MARKDOWN.getValue()%>"==articletype){
            url="<%=basePath%>/modules/article/edit/articledit_md.jsp?articleid="+articleid;
        }else if("<%=ENArticletype.TXT.getValue()%>"==articletype){
            alert("暂未支持！");
            return;
        }
        window.location.href=url;
    }
</script>



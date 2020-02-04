<%--
  Created by IntelliJ IDEA.
  User: lyd
  Date: 2019/12/26
  Time: 18:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getContextPath();
%>
<html>
<head>
    <title>文档列表</title>
    <!-- jQuery (Bootstrap 的 JavaScript 插件需要引入 jQuery) -->
    <script src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>
    <script src="<%=basePath%>/js/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="<%=basePath%>/js/bootstrap-3.3.7/css/bootstrap.min.css"/>

    <link rel="stylesheet" href="<%=basePath%>/css/modules/article/articlelist.css"/>
</head>
<body>
<article>
    <div class="lbox">
        <div id="mainContent" class="whitebg bloglist">

        </div>
    </div>
</article>
<div>
    <ul class="pagination">
        <li><a href="#">&laquo;</a></li>
        <li><a href="#">1</a></li>
        <li><a href="#">2</a></li>
        <li><a href="#">3</a></li>
        <li><a href="#">4</a></li>
        <li><a href="#">5</a></li>
        <li><a href="#">&raquo;</a></li>
    </ul>
</div>
</body>
<script>
    var testboke = {
        "retcode":1,
        "retstatus":1,
        "retdata":"[" +
            "                {\n" +
            "                    \"urid\":\"8\",//项目id\n" +
            "                    \"title\":\"1支付宝第一批幸运儿，花呗报销一年，芝麻分狂\",//发起人名称\n" +
            "                    \"img\":\"\",//发起人公司名称\n" +
            "                    \"abstractcontent\":\"最近有网友非常兴奋，将激动地心情用文字表达在了网上，为什么呢？因为他成了支付为一批幸运儿中的其中一员！我们知道，在出席之前，支付宝推出的2019年大礼中，除了五福红包，...\",//发起项目类别\n" +
            "                    \"createby\":\"1\",\n" +
            "                    \"createdbyname\":\"admin\",\n" +
            "                    \"createon\":\"2020-01-01\"\n" +
            "                },\n" +
            "                {\n" +
            "                    \"urid\":\"9\",//项目id\n" +
            "                    \"title\":\"2支付宝第一批幸运儿，花呗报销一年，芝麻分狂\",//发起人名称\n" +
            "                    \"img\":\"\",//发起人公司名称\n" +
            "                    \"abstractcontent\":\"最近有网友非常兴奋，将激动地心情用文字表达在了网上，为什么呢？因为他成了支付为一批幸运儿中的其中一员！我们知道，在出席之前，支付宝推出的2019年大礼中，除了五福红包，...\",//发起项目类别\n" +
            "                    \"createby\":\"1\",\n" +
            "                    \"createdbyname\":\"admin\",\n" +
            "                    \"createon\":\"2020-01-01\"\n" +
            "                }]" +
            "" +
            "",
        "retdatasize":"4",
        "datalist":{
            "total":17,//总条数
            "size":10,//分页大小-默认为0
            "pages":2,//总页数
            "current":1,//当前页数
            "datas":[//author-riverLethe-double-slash-note数据部分
                {
                    "urid":"8",//项目id
                    "title":"1支付宝第一批幸运儿，花呗报销一年，芝麻分狂",//发起人名称
                    "img":"",//发起人公司名称
                    "abstract":"最近有网友非常兴奋，将激动地心情用文字表达在了网上，为什么呢？因为他成了支付为一批幸运儿中的其中一员！我们知道，在出席之前，支付宝推出的2019年大礼中，除了五福红包，...",//发起项目类别
                    "createby":"admin",
                    "createbyid":"1",
                    "createon":"2020-01-01"
                },
                {
                    "urid":"9",//项目id
                    "title":"2支付宝第一批幸运儿，花呗报销一年，芝麻分狂",//发起人名称
                    "img":"",//发起人公司名称
                    "abstract":"最近有网友非常兴奋，将激动地心情用文字表达在了网上，为什么呢？因为他成了支付为一批幸运儿中的其中一员！我们知道，在出席之前，支付宝推出的2019年大礼中，除了五福红包，...",//发起项目类别
                    "createby":"admin",
                    "createbyid":"1",
                    "createon":"2020-01-01"
                },
                {
                    "urid":"3",//项目id
                    "title":"3支付宝第一批幸运儿，花呗报销一年，芝麻分狂",//发起人名称
                    "img":"",//发起人公司名称
                    "abstract":"最近有网友非常兴奋，将激动地心情用文字表达在了网上，为什么呢？因为他成了支付为一批幸运儿中的其中一员！我们知道，在出席之前，支付宝推出的2019年大礼中，除了五福红包，...",//发起项目类别
                    "createby":"admin",
                    "createbyid":"1",
                    "createon":"2020-01-01"
                },
                {
                    "urid":"4",//项目id
                    "title":"4支付宝第一批幸运儿，花呗报销一年，芝麻分狂",//发起人名称
                    "img":"",//发起人公司名称
                    "abstract":"最近有网友非常兴奋，将激动地心情用文字表达在了网上，为什么呢？因为他成了支付为一批幸运儿中的其中一员！我们知道，在出席之前，支付宝推出的2019年大礼中，除了五福红包，...",//发起项目类别
                    "createby":"admin",
                    "createbyid":"1",
                    "createon":"2020-01-01"
                },
                {
                    "urid":"5",//项目id
                    "title":"5支付宝第一批幸运儿，花呗报销一年，芝麻分狂",//发起人名称
                    "img":"",//发起人公司名称
                    "abstract":"最近有网友非常兴奋，将激动地心情用文字表达在了网上，为什么呢？因为他成了支付为一批幸运儿中的其中一员！我们知道，在出席之前，支付宝推出的2019年大礼中，除了五福红包，...",//发起项目类别
                    "createby":"admin",
                    "createbyid":"1",
                    "createon":"2020-01-01"
                }]
        }
    }
    $(function () {


        $.ajax({
            //请求方式
            type: "GET",
            //请求的媒体类型
            contentType: "application/json;charset=UTF-8",
            //请求地址
            url: "<%=basePath%>/article/queryarticlelist.do",
            //数据，json字符串
            // data : JSON.stringify(list),
            //请求成功
            success: function (result) {
                var resultobj = $.parseJSON(result);
                reload(resultobj);

            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                console.log(e.status);
                console.log(e.responseText);
            }
        });
    });

    function reload(datas) {
        var mainObj = $('#mainContent');
        if(datas.retstatus=="1" && (datas.retdata!=null && datas.retdata!=undefined && datas.retdata!="")){
            var blogHtml=createBlogListHtml( $.parseJSON(datas.retdata));
            mainObj.empty();
            mainObj.html(blogHtml);
        }else{
            mainObj.empty();
            mainObj.html("异常："+datas.retdata);
        }
    }
   function createBlogListHtml(blogdatas) {
       var html = [];
       if(blogdatas==null||blogdatas==undefined||blogdatas=="" ){
           html.push('无数据！');
       }else{
           if(blogdatas.length>0){
               html.push('<ul>');
               $.each( blogdatas,function (index,data) {
                   html.push("<li>");
                   html.push("<h3 class=\"blogtitle\">");
                   html.push("<a href='#' onclick='viewdetail("+data.urid+","+data.articletype+")' title=\""+data.title+"\">"+data.title+"</a></h3>");
                   html.push("</h3>");
                   html.push("<p class=\"blogtext\">");
                   html.push(data.abstractcontent);
                   html.push("</p>");

                   html.push("<p class=\"bloginfo\">");
                   html.push("<span>");
                   html.push(data.createby);
                   html.push("</span>");
                   html.push("<span>");
                   html.push(data.createon);
                   html.push("</span>");
                   html.push("</p>");

                   html.push("<a href=\"#\" onclick='viewdetail("+data.urid+","+data.articletype+")' title=\""+data.title+"\" class=\"viewmore\">");
                   html.push("阅读更多");
                   html.push("</a>");

                   html.push("</li>");
               });
               html.push('</ul>');
           }else{
               html.push('无数据！');
           }
       }
       return html.join('');
   }
   function viewdetail(urid,articletype) {
        var url="<%=basePath%>/modules/article/articledetail.jsp?articleid="+urid+"&articletype="+articletype;
       window.open(url);
   }
</script>
</html>

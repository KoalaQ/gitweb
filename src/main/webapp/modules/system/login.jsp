<%--
  Created by IntelliJ IDEA.
  Date: 2019/12/19
  Time: 11:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@include file="/modules/common/include.jsp" %>
<html>
<head>
    <title>登录</title>
    <script src="<%=basePath%>/js/jquery-3.4.1.min.js"></script>
</head>
<body>
<form id="loginForm" method="post" >
    <input type="text" name="userid" id="userid"/>
    <input type="text" name="password" id="password"/>
    <input type="button" onclick="loginClick()" value="登录" />
</form>

</body>

<script>
   // $('#loginForm').submit(function (event) {
    function loginClick() {
        var formData = {};
        formData.userid=$("#userid").val();
        formData.password=$("#password").val();
        /*var userid=$("#userid").val();
        var password=$("#password").val();

        var formData = "userid="+userid+"&password="+password;*/

       /* var formData = new FormData();
        formData.append('userid', $("#userid").val());
        formData.append('password',$("#password").val());*/
        $.ajax({
            async: false,
            //请求方式
            type: "POST",
            //请求地址
            url: "<%=basePath%>/user/login/login.do",
            //数据
             data : formData,
             //data : $('#loginForm').serialize(),
            //data :$.extend({}, formData, {}),
            //data :formData,
            //data :new FormData($('#loginForm')[0]),
            dataType: "JSON",
            //mimeType: "multipart/form-data",
            //contentType: false,
            //cache: false,
            //processData: true,
            //请求成功
            success: function (result) {
                if(result.retcode=="1" && result.retstatus=="1"){
                    window.location.href="<%=basePath%>/modules/article/articlelist.jsp";
                }else{
                    alert(result.retdata);
                }


            },
            //请求失败，包含具体的错误信息
            error: function (e) {
                console.log(e.status);
                console.log(e.responseText);
            }
        });
    }



</script>
</html>

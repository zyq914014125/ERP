<%--
  Created by IntelliJ IDEA.
  User: zyq914014125
  Date: 2020/12/3
  Time: 13:53
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>请假</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="../css/layui.css"  media="all">
</head>
<body>

<form  action="apply.do" method="post" id="form" style="margin-top: 50px">
    <div class="layui-form-item">
        <label class="layui-form-label">标题</label>
        <input type="text" name="header" id="header">
            </div>
        <div class="layui-form-item">
            <label class="layui-form-label">原因(不超过255个字)</label>
            <textarea rows="30" cols="50" name="reason" id="reason">

</textarea>
        </div>
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button type="button" class="layui-btn" lay-submit="" lay-filter="demo1" id="sub">立即提交</button>
                <input type="hidden"><a href="" id="a" TARGET="_top"><span id="go"></span></a>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </div>
</form>

<script src="../js/layui.js" charset="utf-8"></script>
<script src="../js/jquery.js" charset="utf-8"></script>



<script>
    $("#sub").click(function () {
        var reaseon=$("#reason").val();
        var header=$("#header").val();
        if(reaseon!=''&&header!='')
            $("#form").submit();

    })

</script>
</body>
</html>

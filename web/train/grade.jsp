<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    String path = request.getContextPath() + "/";
%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>
    <link rel="stylesheet" href="../css/pintuer.css">
    <link rel="stylesheet" href="../css/admin.css">
    <script src="../js/jquery.js"></script>
    <script src="../js/pintuer.js"></script>

</head>
<body>

<div class="panel admin-panel">
    <div class="panel-head">
        <strong class="icon-reorder">角色管理</strong>
    </div>

    <table class="table table-hover text-center">
        <tr>
            <th>姓名</th>
            <th>成绩</th>
            <th>时间</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${grades}" var="grade">
            <form action="role/update.do" method="post">
                <input type="hidden" name="grade_id" value="${grade.grade_id}" style="border: none;text-align: center">
                <tr>
                    <td><input type="text" name="name" value="${grade.name }" style="border: none;text-align: center" disabled></td>
                    <td><input type="text" name="score" value="${grade.score}" style="border: none;text-align: center"></td>
                    <td><input type="text" name="time" value="${grade.time}" style="border: none;text-align: center"></td>
                    <td><input type="submit" value="修改" style="color: blue"></td>
                    <td><a href="role/delete?roleId=${grade.grade_id}" style="color: red">删除</a></td>
                </tr>
            </form>
        </c:forEach>
    </table>

</div>


</body>
</html>
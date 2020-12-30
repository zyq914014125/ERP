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
            <th>请假人</th>
            <th>请假头</th>
            <th>请假原因</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${leaves}" var="leave">
            <form action="update.do" method="post">
                <input type="hidden" name="leaveId" value="${leave.leaveId}">
                <tr>
                    <td>${leave.name}</td>
                    <td>${leave.header}</td>
                    <td>${leave.reason}</td>
                    <td><input type="submit" value="批准" style="color: blue"></td>
                </tr>
            </form>
        </c:forEach>
    </table>

</div>


</body>
</html>
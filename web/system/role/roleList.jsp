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
            <th>Id</th>
            <th>职务名</th>
            <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${roleList}" var="role">
            <form action="role/update.do" method="post">
                <tr>
                    <td><input type="text" name="roleId" value="${role.roleId }" style="border: none;text-align: center" disabled></td>
                    <td><input type="text" name="roleName" value="${role.roleName}" style="border: none;text-align: center"></td>
                    <td><input type="submit" value="修改" style="color: blue"></td>
                    <td><a href="role/delete?roleId=${role.roleId}" style="color: red">删除</a></td>
                </tr>
            </form>
        </c:forEach>
    </table>

</div>


</body>
</html>
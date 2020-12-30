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
        <strong class="icon-reorder">菜单管理</strong>
        </div>
        <div class="padding border-bottom">
        <ul class="search">
        </ul>
        </div>

        <table class="table table-hover text-center">
        <tr>
        <th>菜单号</th>
        <th>菜单名称</th>
        <th>权限</th>
        <th>提交路径</th>
        <th colspan="2">操作</th>
        </tr>
        <c:forEach items="${menuLis}" var="menu">
            <form action="menu/update.do" method="post">
            <tr class="parent" id="${menu.menuId}">
            <td><input type="text" name="menuId" value="${menu.menuId }" style="border: none;text-align: center" disabled></td>
            <td><input type="text" name="menuName" value="${menu.menuName}" style="border: none;text-align: center"></td>
            <td><input type="text" name="roleId" value="${menu.roleId }" style="border: none;text-align: center"></td>
            <td><input type="text" name="url" value="${menu.url }" style="border: none;text-align: center"></td>
            <td><input type="submit" value="修改" style="color: blue"></td>
            <td><a href="menu/delete?user_id=${menu.menuId}" style="color: red">删除</a></td>
            </tr>
            </form>
            <c:forEach items="${menu.menu}" var="m">
            <form action="menu/update.do" method="post">
                <tr class="child_${menu.menuId}">
                <td><input type="text" name="menuId" value="${m.menuId }" style="border: none;text-align: center"></td>
                <td><input type="text" name="menuName" value="${m.menuName}" style="border: none;text-align: center"></td>
                <td><input type="text" name="roleId" value="${m.roleId }" style="border: none;text-align: center"></td>
                <td><input type="text" name="url" value="${m.url }" style="border: none;text-align: center"></td>
                <td><input type="submit" value="修改" style="color: blue"></td>
                <td><a href="menu/delete?menuId=${m.menuId}" style="color: red">删除</a></td>
                </tr>
                </form>
            </c:forEach>
        </c:forEach>
        </table>

        </div>


        </body>

        <script type="text/javascript">
        $(function(){
        $('.parent').click(function(){   // 获取所谓的父行
        $(this) .toggleClass("selected")   // 添加/删除高亮
        .siblings('.child_'+this.id).toggle();  // 隐藏/显示所谓的子行
        }).click();
        })
        </script>
        </html>
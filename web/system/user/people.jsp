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
	<link rel="stylesheet" href="../css/layui.css" media="all">
	<link rel="stylesheet" href="../css/bootstrap.css" media="all">
<script src="../js/jquery.js"></script>
<script src="../js/pintuer.js"></script>
	<script src="../js/layui.js" charset="utf-8"></script>
	<script src="../js/bootstrap.min.js" charset="utf-8"></script>
</head>
<body>

		<div class="panel admin-panel">
			<div class="panel-head">
				<strong class="icon-reorder">人员管理</strong>
			</div>
			<div class="padding border-bottom">
				<ul class="search">

					<li><form action="system/user/serach.do" method="post">
						<input type="text" name="name" value="" placeholder="请输入姓名进行搜索">
							<input type="submit" class="btn btn-primary" value="搜索"></input>
					</form></li>
					<li style="float: right"> <button class="btn btn-primary btn-lg" data-toggle="modal" data-target="#myModal">
						新增
					</button></li>

				</ul>
			</div>

			<table class="table table-hover text-center" >
				<tr>
					<th>登录名</th>
					<th>密码</th>
					<th>真实姓名</th>
					<th>电话</th>
					<th>性别</th>
					<th>年龄</th>
					<th>职务</th>
					<th colspan="2">操作</th>
				</tr>
				<tbody id="table">
				<c:forEach items="${userList}" var="user">
					<form action="user/update.do" method="post">
						<input type="hidden" value="${user.user_id}" name="id">
					<tr>
						<td><input type="text" name="username" value="${user.username }" style="border: none;text-align: center"></td>
						<td><input type="text" name="password" value="${user.password }" style="border: none;text-align: center"></td>
						<td><input type="text" name="name" value="${user.name}" style="border: none;text-align: center"></td>
						<td><input type="text" name="telephone" value="${user.telephone }" style="border: none;text-align: center"></td>
						<td><input type="text" name="sex" value="${user.sex }" style="border: none;text-align: center"></td>
						<td><input type="text" name="age" value="${user.age }" style="border: none;text-align: center"></td>
						<td><input type="text" name="age" value="${user.roleName }" style="border: none;text-align: center"></td>
						<td><input type="submit" value="修改" style="color: blue"></td>
						<td><a href="user/delete.do?user_id=${user.user_id}" style="color: red">删除</a></td>
					</tr>
					</form>
				</c:forEach>
				</tbody>
			</table>

		</div>

		<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">
						</button>
						<h4 class="modal-title" id="myModalLabel">
							新增人员
						</h4>
					</div>
					<div class="modal-body">
						<form action="#" id="addform">
							<div class="layui-form-item" style="width: 300px;height: 50px">
								<label class="layui-form-label" >登录名</label>
								<div class="layui-input-block">
									<input type="text" name="username" lay-verify="title" autocomplete="off" placeholder="请输入登录名" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item" style="width: 300px;height: 50px">
								<label class="layui-form-label">密码</label>
								<div class="layui-input-block">
									<input type="text" name="password" lay-verify="title" autocomplete="off" placeholder="请输入密码" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item" style=" width: 300px;height: 50px">
								<label class="layui-form-label" style="width: 100px;height:50px;">真实姓名</label>
								<div class="layui-input-block">
									<input type="text" name="name" lay-verify="title" autocomplete="off" placeholder="请输入真实姓名" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item" style="width: 300px;height: 50px" >
								<label class="layui-form-label">电话</label>
								<div class="layui-input-block">
									<input type="number" name="telephone" lay-verify="title" autocomplete="off" placeholder="请输入电话" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item" style="width: 300px;height: 50px" >
								<label class="layui-form-label">性别</label>
								<div class="layui-input-block">
									<input type="radio" name="sex" value="男" title="男" checked="">男
									<input type="radio" name="sex" value="女" title="女">女
								</div>
							</div>
							<div class="layui-form-item" style="width: 300px;height: 50px" >
								<label class="layui-form-label">年龄</label>
								<div class="layui-input-block">
									<input type="number" name="age" lay-verify="title" autocomplete="off" placeholder="请输入年龄" class="layui-input">
								</div>
							</div>
							<div class="layui-form-item" style="width: 300px;height: 50px">
								<label class="layui-form-label" style="width: 100px;height:50px;">选择职务</label>
								<div class="layui-input-block">
									<select name="roleId" lay-filter="aihao">
										<option value=""></option>
										<option value="200">行政专员</option>
										<option value="300">研发主管</option>
										<option value="301">研发专员</option>
									</select>
								</div>
							</div>
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default"
								data-dismiss="modal" >关闭
						</button>
						<button type="button" class="btn btn-primary" id="submit">
							提交
						</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->
</body>

<script>
	$("#submit").click(function () {
		// console.log($("form").serialize()); //输出字符串
		// console.log($("form").serializeArray()); //输出数组
		var data=$("#addform").serializeArray();
		$.ajax({
			data:data,
			url:"user/add.ajax",
			dataType:'json',
			type:'post',
			success:function (data) {
				console.log(data);
				var user_id=data['user_id'];
				console.log(user_id);
                 	$("#table").append("<tr>"+'<form action="user/update.do" method="post">'
							+"<td>"+ '<input type="text" name="username" value="'+data['username']+'"'+ 'style="border: none;text-align: center"></td>'+
							+"<td>"+ '<input type="text" name="password" value="'+data['password']+'"'+ 'style="border: none;text-align: center"></td>'+
							"<td>"+'<input type="text" name="name" value="'+data['name']+'"'+' style="border: none;text-align: center"></td>'+
						"<td>"+'<input type="text" name="telephone" value="'+data['telephone']+'"'+'style="border: none;text-align: center"></td>'+
						"<td>"+'<input type="text" name="sex" value="'+data['sex']+'"'+ 'style="border: none;text-align: center"></td>'+
						"<td>"+'<input type="text" name="age" value="'+data['age']+'"'+ 'style="border: none;text-align: center"></td>'+
						"<td>"+'<input type="text" name="age" value="'+data['roleName']+'"'+ 'style="border: none;text-align: center"></td>'+
						"<td>"+'<input type="submit" value="修改" style="color: blue"></td>'+
						"<td>"+'<a href="user/delete.do?user_id='+user_id+'"'+'style="color: red">删除</a></td>'+
				'</form>'+"</tr>")
			}
		})
	})
</script>

</html>
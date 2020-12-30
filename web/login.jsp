<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath() + "/";
%>
<!DOCTYPE HTML>
<html>
<head>
<title>WELCOME! 人力资源管理</title>
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!-- -->
<script>
	var __links = document.querySelectorAll('a');
	function __linkClick(e) {
		parent.window.postMessage(this.href, '*');
	};
	for (var i = 0, l = __links.length; i < l; i++) {
		if (__links[i].getAttribute('data-t') == '_blank') {
			__links[i].addEventListener('click', __linkClick, false);
		}
	}
</script>
<script src="js/jquery.js"></script>
<script>
	$(document).ready(function(c) {
		$('.alert-close').on('click', function(c) {
			$('.message').fadeOut('slow', function(c) {
				$('.message').remove();
			});
		});
	});
</script>
</head>
<body>
	<div class="message warning">
		<div class="inset">
			<div class="login-head">
				<h1>欢迎登录ERP系统</h1>
				<div class="alert-close"></div>
			</div>
			<form action="login.do" method="post">
				<li><input name="username" type="text" class="text"
					value="Username" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Username';}"><a
					href="#" class=" icon user" id="username"></a></li>
				<div class="clear"></div>
				<li><input name="password" type="password" value="Password"
					onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Password';}" id="password">
					<a href="#" class="icon lock"></a></li>
				<li><input type="text" value="" placeholder="请输入验证码" class="text" id="code"/></li>
				<div id="code_box" style="background-color: #FFB800;font-style:italic"><b>Af3D</b></div>
				<div class="clear"></div>
				<div class="button">
					<input type="button" value="Sign in" id="login" >
					<h4>
						<a href="forget.jsp">忘记密码?</a>
					</h4>
					<br>
					<br> <span style="color: red; font-size: 10px">${login_msg}</span>
					<div class="clear"></div>
				</div>
			</form>
		</div>
	</div>

	<div class="clear"></div>
	<!--- footer --->
<%--	<div class="footer" style="float: bottom">--%>
<%--		<p>Made by xian</p>--%>
<%--	</div>--%>
	<div style="display: none">
		<script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540'
			language='JavaScript' charset='gb2312'></script>
		<script>
			var code_box = document.getElementById("code_box");
			function refreshCode() {
				//62个字符 随机选择4位
				var code = '0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM',
						char = '',
						result = '';
				for (var i = 0; i < 4; i++) {
					//随机选择一位  （0,61） 写出0到61的随机的索引数字
					var code_index = Math.round(Math.random()*61);
					//得到随机的索引  取出随机地字符
					var char = code[code_index];
					//随机取出的字符 存在几个相同重复的问题 ，而且对于字母，不能区分大小写。
					// 避免重复的思路是：取出字符之后,和最后的result对比一下，看看里边是不是已经存在了，如果存在本次循环就终止，进行下一次
					if (result.toUpperCase().indexOf(char.toUpperCase()) > -1)
							//indexOf() == -1 说明结果里边没有要找的字符 那么 > -1 就是 里边有重复的字符
					{
						i --;
						//为什么会 --？ 因为如果条件成立，那么本轮循环就结束进行下一轮循环（自然i就加1了），那么本轮本应该取出的字符就没有了
						//到最后会少一个字符 缺席
						continue;//终止本轮循环 进行下一轮
					}
					result += char;
				}

				code_box.innerHTML = result;

			}
			//点击事件
			code_box.onclick = refreshCode;

			//登录审核
			$("#login").click(function () {
					var username=$("#username").val();
					var password=$("#password").val();
					var inputCode=$("#code").val()
					var Code=$("#code_box").text();
					console.log(inputCode);
					console.log(Code);
					//用户名密码不为空时
					if(username!=null&&password!=null){
						if(inputCode==Code){
							alert("欢迎");
							$("form").submit();
						}else
							alert("验证码错误");

					}else
						alert("用户名或密码为输入");
			})
		</script>
	</div>
</body>
</html>
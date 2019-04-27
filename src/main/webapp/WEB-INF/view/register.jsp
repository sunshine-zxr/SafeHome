<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<base href="<%=basePath %>">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>家居安全系统-注册页</title>
<link rel="stylesheet" href="css/register.css"/>
<script type="text/javascript">
	function custCheck(){
		var username=document.getElementById("username");
		var password=document.getElementById("password");
		var email=document.getElementById("email");
		if(username.value==""){
			alert("账号不能为空！");
			return false;
		}else if(password.value==""){
			alert("密码不能为空！");
			return false;
		}else if(email.value==""){
			alert("邮箱不能为空！");
			return false;
		}
	}
</script>
<script type="text/javascript">
	var msg="${requestScope.msg}";
	if(msg.trim().length!=0){
		alert(msg);
	}
</script>
</head>
<body>
	<form action="register" method="post" onSubmit="return custCheck()">
		<div id="register">
			<p>已有账号，<a href="Login">登录</a></p>
			<p>
				<input type="text" name="username" id="username" class="textbox" placeholder="请输入用户名">
			</p>
			<p>
				<input type="text" name="password" id="password" class="textbox" placeholder="请输入密码">
			</p>
			<p>
				<input type="text" name="email" id="email" class="textbox" placeholder="请输入邮箱">
			</p>
			<p>
				<input type="submit" value="注册" class="submit">
			</p>
			
		</div>
	</form>
</body>
</html>
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
<title>家居安全系统-登录页</title>
<link rel="stylesheet" href="css/login.css"/>
<script type="text/javascript">
	function custCheck(){
		var username=document.getElementById("username");
		var password=document.getElementById("password");
		if(username.value==""){
			alert("账号不能为空！");
			return false;
		}else if(password.value==""){
			alert("密码不能为空！");
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
	<form action="login" method="post" onSubmit="return custCheck()">
		<div id="login">
			<p class="t1">智能家居安全系统</p>
			<p>
				<input type="text" name="username" class="textbox" placeholder="请输入账号">
			</p>
			<p>
				<input type="password" name="password" class="textbox" placeholder="请输入密码">
			</p>
			<p>
				<input type="submit" value="登录" class="submit">
			</p>
			<p class="text" style="text-align:right">忘记密码</p>
			<p>
				<a href="Regist">
					<input type="button" value="注册账号" class="button">
				</a>
			</p>
		</div>
	</form>
</body>
</html>
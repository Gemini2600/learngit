<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
	<link rel="stylesheet" href="css/login.css"/>
</head>
<body>
	<div id="login" class="form-action show">	
			<h1>Login on web</h1>
			<p>欢迎使用*****管理平台</p>
			<form action="LoginServlet" method="post">
				<ul>
					<li>
						<input type="text" name="username" placeholder="请输入用户名" class="loginInput" />
						<span id="userid" style="width:20px;height:40px;background-color: white;"></span>
					</li>
					<li>
						<input type="text" name="password" placeholder="请输入密码" class="loginInput"/>
						<span id="pswid"></span>											
																	
					</li>
					<li>
						<input type="submit" value="登录" class="loginSubmit"/>
						<span id="afterid"></span>
					</li>
					<li>
						<input type="checkbox" name="checkbox" value="1"/><span>下次自动登录</span>
					</li>
				</ul>
				<input type="hidden" name="type" value="1" />
			</form>
		</div>
</body>
</html>
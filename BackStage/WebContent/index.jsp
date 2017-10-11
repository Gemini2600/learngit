<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理平台</title>
<link rel="stylesheet" href="css/index.css" />
		<script type="text/javascript" src="js/index.js"></script>
	</head>
	<body onload="_onload()">
		<div class="topNav">
			<span id="logo">电商管理平台</span>
			<ul id="topMenu">
				<li><a href="#">系统</a></li>
				<li><a href="#">采购</a></li>
				<li><a href="#">销售</a></li>
				<li><a href="#">库存</a></li>
				<li><a href="#">用户</a></li>
				<li><a href="#">商品</a></li>
				<li><a href="#">订单</a></li>
				<li><a href="#">客服</a></li>
				<li><a href="#">商家</a></li>
				<li><a href="#">财务</a></li>
				<li><a href="#">数据统计</a></li>
			</ul>
			<span id="admin"><a href="#">管理员</a></span>
			<span id="exit"><a  href="#" onclick="location.href=('login.jsp')">退出</a></span>
		</div>
		<div class="left">
			<div  class="search" id="search_box"> 
				<p><input type="text" id="s" value="搜索" /></p>			
			</div> 
			<div class="manager" id="manager1" style="background-color: #lalala;">
			
			
		    </div>
		</div>
		<div class="right">
			<iframe src="" name="ifrm" id="ifrm" width="1072px" height="600px"></iframe>
			
		</div>
		
	</body>
</html>

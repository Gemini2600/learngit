<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>是否删除？</title>
	<link rel="stylesheet" href="css/delcss.css" />
	</head>
	<body>
		<form action="delCateServlet.do" method="get">
		<div id="divid">
			<div id="div1id">确认删除吗？</div>
			<% Object obj=request.getAttribute("delet_cid");
				
			%>
			<div id="div2id">
				<input type="submit" id="_input1id" name="del_button_name" value="True" />
				<input type="submit" id="_input2id" name="del_button_name" value="False" />
			</div>
		</div>
		<input type="hidden" name="type" value="${delet_cid}" />
		</form>
	</body>
</html>
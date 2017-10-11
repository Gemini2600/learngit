<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品规格</title>
<!--<link rel="stylesheet" href="css/norm.css" />-->
		<!-- <script type="text/javascript" src="js/norm.js" ></script> -->
		<style>
			table{
				text-align: center;
			}
			#input2{
				margin-left: 50px;
			}
		</style>
	</head>
<body>
	<h3>商品规格</h3>
	<form action="ruleServlet.do" method="post">
	<h4><input type="button" name="addGui" value="添加商品规格" onclick="location.href=('addrule.jsp')"/></h4>
		<table border='1' width='800px' cellpadding="0px" cellspacing="0px">
			<thead>
			<tr>
				<th>商品规格编号</th>
				<th>商品名称</th>
				<th>商品编号</th>
				<th>商品尺寸</th>
				<th>操作</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${rules.datas}" var="prd" varStatus="varSta">
				<tr>
					<td>${prd.id}</td>
					<td>${pname}</td>
					<td>${prd.pid}</td>
					<td>${prd.size}</td>
					<td><a href="updateRuleServlet.do?getid=${prd.id}">编辑</a>&nbsp;&nbsp;&nbsp;
						<a href="ruleServlet.do?reqType=4&delet_id=${prd.id}">删除</a>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
		共${rules.totalcount}条记录${rules.pageNo}/${rules.totalPageSize}页 &nbsp;
		
	<c:if test="${rules.pageNo>0}">
	<a href="ruleServlet.do?reqType=2&pageNo=1&pageSize=5">首页</a>&nbsp;
	</c:if>
	
    <a href="ruleServlet.do?reqType=2&pageNo=${rules.pageNo==1?rules.pageNo:rules.pageNo-1}&pageSize=5">上一页</a>&nbsp;
	
	<a href="ruleServlet.do?reqType=2&pageNo=${rules.pageNo==rules.totalPageSize?rules.pageNo:rules.pageNo+1}&pageSize=5">下一页</a>&nbsp;
	
	<a href="ruleServlet.do?reqType=2&pageNo=${rules.totalPageSize}&pageSize=5">尾页</a>
	
	第<select onchange="self.location.href=options[selectedIndex].value">
  		
  		<c:forEach begin="0" end="${rules.totalPageSize-1}" step="1" var="i" >
  		<c:choose>
  		<c:when test="${rules.pageNo==i+1 }">
  			<option value="ruleServlet.do?reqType=2&pageNo=${i+1} }&pageSize=5" selected="selected">${i+1}</option>
  		</c:when>
  		<c:otherwise>
  		<option value="ruleServlet.do?reqType=2&pageNo=${i+1}&pageSize=5" >${i+1}</option>
  		</c:otherwise>	
		</c:choose>
		</c:forEach>
			</select>页
	</form>
	</body>
</html>
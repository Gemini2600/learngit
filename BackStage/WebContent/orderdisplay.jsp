<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.*,com.neusoft.entity.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title>
<link rel="stylesheet" href="css/orderdisplay.css" />
	</head>
	<body>
		<div id="div_all">
		<form action="orderDisplayServlet.do" method="post">
			<div id="div_button"><button type="submit" name="button_back" value="1">返回</button></div>
			<div class="div_list_word"><p>订单状态：</p><p id="div_list_word_right">${order.orderlist[0].orderstatusname}</p></div>
			<!--订单信息-->
			<div id="div_content_list01">
			<div class="div_list"><p>订单信息</p></div>
			<div class="div_list_have"><p>订单编号：</p>${order.orderlist[0].orderno}</div>
			<div class="div_list_have"><p>支付方式：</p>${order.orderlist[0].paystatusname}</div>
			<div class="div_list_have"><p>下单时间：</p>${order.orderlist[0].ordertime}</div>
			<div class="div_list_have"><p>付款时间：</p>${order.orderlist[0].paytime}</div>
			</div>
			<!--收货人信息-->
			<div id="div_content_list02">
			<div class="div_list"><p>收货人信息</p></div>
			<div class="div_list_have"><p>收货人姓名：</p>${order.orderlist[0].ca[0].cname}</div>
			<div class="div_list_have"><p>地址：</p>${order.orderlist[0].ca[0].addr}</div>
			<div class="div_list_have"><p>联系电话：</p>${order.orderlist[0].ca[0].phone}</div>
			</div>
			<!--物流信息-->
			<div id="div_content_list03">
				<div class="div_list"><p>收货人信息</p></div>
				<div class="div_list_have"><p>物流公司</P><input  class="div_input" type="text" /></div>
					<div class="div_list_have"><p>物流单号</p> <input class="div_input" type="text"/></div>
					<div id="div_list_have_button"><button>确认发货</button></div>
			</div>
			<!--备注信息-->
			<div id="div_content_list04">
				<div class="div_list"><p>备注信息</p></div>
				<div class="div_list_have">${order.orderlist[0].mask }</div>
			</div>
			<!--商品详细内容-->
			<div id="div_content_list05">
				<div class="div_list">
					<div class="div_list_pro"><p>商品编号</p></div>
					<div class="div_list_pro"><p>商品名称</p></div>
					<div class="div_list_pro"><p>商品数量</p></div>
					<div class="div_list_pro"><p>商品单价（元）</p></div>
				</div>
				
				<c:forEach items="${order.productlist}" var="i">
				<div class="div_list_prodisplay">
					<div class="div_list_pro"><p>${i.pno}</p></div>
					<div class="div_list_pro"><p>${i.pname}</p></div>
					<div class="div_list_pro"><p>1</p></div>
					<div class="div_list_pro"><p>${i.price}</p></div>
				</div>
				</c:forEach>
			</div>
			</form>
		</div>
	</body>
</html>
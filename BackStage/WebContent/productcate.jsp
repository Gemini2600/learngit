<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page language="java" import="java.util.*,com.neusoft.entity.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品类别</title>
<link rel="stylesheet" href="css/cate.css" />
	</head>
	<body>
	    <form action="cServlet.do" method="post">
		<div class="div-add" id="div-add-id" >
			<div id="div-up">
				<span id="span1id">商品类别</span>
				<span id="span2id"><a><img src="img/cha1.png" onclick="closeDiv()"></a></span>
			</div>
			<div id="div-down">
				<div id="down_div1id">
					<div id="down_div2id">
						<input type="button" id="_input1id" name="addcate" value="添加分类"  onclick="location.href=('addServlet.do')"/>
					</div>
					
					<div id="div11id">
					
						<table   cellpadding="0px" cellspacing="0px"  >
							<thead>
								<tr>
									<th><div>分类编号</div></th>
									<th><div>分类名称</div></th>
									<th><div>上级分类名称</div></th>
									<th><div>操作</div></th>
								</tr>
							</thead>
					
							<tbody >
				<%   response.setContentType("text/html;charset=utf-8");
			         Object obj=request.getAttribute("cates");
					 if(obj!=null){
						PageModel<Cate> pageModel=(PageModel<Cate>)obj;
						for(int i=0;i<pageModel.getDatas().size();i++){
						Cate pmd=pageModel.getDatas().get(i);%>
				
							<tr>
							<td><div><%=pmd.getCid() %></div></td>
							<td><div><%=pmd.getCname() %></div></td>
							<td><div><%=pmd.getPid() %></div></td>
							<td><div>
							<a href="updateCateServlet.do?getcid=<%=pmd.getCid()%>">编辑</a>&nbsp;&nbsp;&nbsp;
							<a href="cServlet.do?reqType=4&delet_cid=<%=pmd.getCid()%>">删除</a>
							
				
							</div></td>
							</tr>
					<% }%>
							</tbody>
							
						</table>
					</div>
					
					<div id="div12id">
	共<%=pageModel.getTotalcount() %>条记录<%=pageModel.getPageNo() %>/<%=pageModel.getTotalPageSize() %>页 &nbsp;
		
	<%if(pageModel.getPageNo()>0  ){%>
	<a href="cServlet.do?reqType=2&pageNo=1&pageSize=5">首页</a>&nbsp;<%}%>
	
    <a href="cServlet.do?reqType=2&pageNo=<%=pageModel.getPageNo()==1 ? pageModel.getPageNo() : pageModel.getPageNo()-1 %>&pageSize=5">上一页</a>&nbsp;
	
	<a href="cServlet.do?reqType=2&pageNo=<%=pageModel.getPageNo()==pageModel.getTotalPageSize() ? pageModel.getPageNo() :pageModel.getPageNo()+1 %>&pageSize=5">下一页</a>&nbsp;
	
	<a href="cServlet.do?reqType=2&pageNo=<%=pageModel.getTotalPageSize() %>&pageSize=5">尾页</a>
					          
	第<select onchange="self.location.href=options[selectedIndex].value">
  		<%
  		if(pageModel!=null){
  			int _totalPageSize=pageModel.getTotalPageSize();
  			for(int i=0;i<_totalPageSize;i++){
  				if(pageModel.getPageNo()==(i+1)){%>
  					<option value="cServlet.do?reqType=2&pageNo=<%=i+1 %>&pageSize=5" selected="selected"><%=(i+1) %></option>
  				<%}else{ %>
  					 <option value="cServlet.do?reqType=2&pageNo=<%=i+1 %>&pageSize=5" ><%=(i+1)%></option>
  				<%}
  			}
  		
  		}
  	%>
			</select>页
			</div>
				</div>
				<% }
				%>
				<!-- <div id="down_div3id">
					<input type="text" id="_input3id"/>
					<input type="button" id="_input1id" name="checkcate" value="搜索"/>
					
					
				</div> -->
			</div>
		</div>
		</form>
		
		<script>
			function closeDiv(){
			var closeid=document.getElementById("div-add-id");
			closeid.style.display="none";
			}
			function deleteJobDetail(){
			     if(window.confirm('你确定要删除吗')){
			          //后台删除数据方法
			           return true;
			      }else{
			          return false;
			      }
			  }
		</script>
	</body>
</html>

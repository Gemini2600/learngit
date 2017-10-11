//左部一级菜单
//var levelMenu1=[{'name':'商品管理','link':'productmanager.html'},{'name':'订单管理','link':''},{'name':'前台管理','link':''},{'name':'权限管理','link':''},{'name':'会员管理','link':'member.html'},{'name':'系统设置','link':''}];

var levelMenu1=['商品管理','订单管理','前台管理','权限管理','会员管理','地址管理','系统设置'];

var levelMenu2=[
				[{'name':'商品列表','link':'productServlet.do'},{'name':'商品分类','link':'cServlet.do'},{'name':'商品规格','link':'ruleServlet.do'}],
				[{'name':'订单状态','link':'orderServlet.do'},{'name':'待支付订单','link':'waitPayServlet.do?searchType=1'},{'name':'已付款订单','link':'payMentServlet.do?searchType=2'},{'name':'已发货订单','link':'shippedServlet.do?searchType=3'},{'name':'已完成订单','link':'completedServlet.do?searchType=4'}],
				[{'name':'通知列表','link':'#'}],
				[{'name':'一级菜单','link':'#'},{'name':'二级菜单','link':'#'},{'name':'三级菜单','link':'#'}],
				[{'name':'买家会员信息','link':'consumerServlet.do'},{'name':'卖家会员信息','link':'accProductServlet.do'}],
				[{'name':'地址查询','link':'addressServlet.do'}],
				[{'name':'修改密码','link':'#'}]
	];

function _onload(){
	var div_have=document.getElementById("manager1");
	for(var i=0;i<levelMenu1.length;i++){
		var div_head=document.createElement("div");
		div_have.appendChild(div_head);
		div_head.setAttribute("id","div_head"+i);
		div_head.setAttribute("style","width: 70px;height: 35px;background-color: #E74c3c;padding-left: 20px;padding-right: 50px;color: whitesmoke;line-height: 40px;    border-bottom: 1px solid whitesmoke;");
		div_head.setAttribute("onclick","test("+i+")");
		
//		var div_head_a=document.createElement("a");
//		div_head_a.setAttribute("href",levelMenu1[i].link);
//		div_head_a.setAttribute("target","ifrm");
//		div_head_a.setAttribute("style","text-decoration: none;color: whitesmoke;");
//		div_head.appendChild(div_head_a);
//		var div_head_word=document.createTextNode(levelMenu1[i].name);
//		div_head_a.appendChild(div_head_word);

		var div_head_word=document.createTextNode(levelMenu1[i]);
		div_head.appendChild(div_head_word);

		
		var div_hidden=document.createElement("div");
		div_hidden.setAttribute("style","width:140px ;height: 0px;overflow: hidden;");
		div_hidden.setAttribute("id","div_hidden"+i);
		div_have.appendChild(div_hidden);
	
		
		for(var j=0;j<levelMenu2[i].length;j++){
		var div_title=document.createElement("div");
		var div_title_a=document.createElement("a");
		div_title.setAttribute("style","padding-left: 20px;width: 90px;padding-right: 30px;line-height: 35px;font-size:15px;color: whitesmoke;");
		div_title_a.setAttribute("href",levelMenu2[i][j].link);
		div_title_a.setAttribute("target","ifrm");
		div_title_a.setAttribute("style","text-decoration: none;color: whitesmoke;");
		div_hidden.appendChild(div_title);
		div_title.appendChild(div_title_a);
		var div_title_word=document.createTextNode(levelMenu2[i][j].name);
		div_title_a.appendChild(div_title_word);
			
		}
	}
}
//

function test(i){
		var div_hidden=document.getElementById("div_hidden"+i);
		var h = div_hidden.offsetHeight;
		//alert(h);
		if(h===0){
		var st="height: "+levelMenu2[i].length*35+"px;";
		div_hidden.setAttribute("style",st);
		
		}
		else{
			var st="height:0px;overflow:hidden";
			div_hidden.setAttribute("style",st);
			
		}
}




	
	
/*function $(id){
	return document.getElementById(id);
}
window.onload = function(){
	$("manager1").onclick = function(e){
	var src = e?e.target:event.srcElement;
	if(src.tagName == "P"){
	   var next = src.nextElementSibling || src.nextSibling;
	   next.style.display = (next.style.display =="block")?"none":"block";
  	}
 	}
}*/


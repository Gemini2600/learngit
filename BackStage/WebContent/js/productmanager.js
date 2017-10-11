var _theadman=[
	'','编号','名称','库存','上架','排序','操作'
];
var _tbodyman=[  
	[{},{'num':'31'},{'img':'img/Alexander Wang.jpg','content':'Alexander Wang','link':'#'},{'sum':'1'},{'img':'img/duigou.png'},{'sort':'1'},{}],
	[{},{'num':'33'},{"img":"img/Christian Louboutin.jpg","content":"Christian Louboutin",'link':'#'},{'sum':'3'},{'img':'img/duigou.png'},{'sort':'5'},{}],
	[{},{'num':'45'},{"img":"img/Giuseppe Zanotti.jpeg","content":"Giuseppe Zanotti",'link':'#'},{'sum':'9'},{'img':'img/duigou.png'},{'sort':'10'},{}],
	[{},{'num':'88'},{"img":"img/Manolo Blahnik.jpg","content":"Manolo Blahnik",'link':'#'},{'sum':'9'},{'img':'img/duigou.png'},{'sort':'10'},{}],
	[{},{'num':'78'},{"img":"img/Nicholas Kirkwood.jpg","content":"Nicholas Kirkwood",'link':'#'},{'sum':'9'},{'img':'img/duigou.png'},{'sort':'10'},{}],
	[{},{'num':'98'},{"img":"img/Rene Caovilla.jpg","content":"Rene Caovilla",'link':'#'},{'sum':'9'},{'img':'img/duigou.png'},{'sort':'10'},{}],
	[{},{'num':'108'},{"img":"img/Roger Vivier.jpeg","content":"Roger Vivier",'link':'#'},{'sum':'9'},{'img':'img/cha.png'},{'sort':'10'},{}],
	[{},{'num':'86'},{"img":"img/Salvatore Ferragamo.JPG","content":"Salvatore Ferragamo",'link':'#'},{'sum':'9'},{'img':'img/duigou.png'},{'sort':'10'},{}],
	[{},{'num':'56'},{"img":"img/Sergio Rossi.jpg","content":"Sergio Rossi",'link':'#'},{'sum':'9'},{'img':'img/duigou.png'},{'sort':'10'},{}],
	[{},{'num':'35'},{"img":"img/Stuart Weitzman.jpg","content":"Stuart Weitzman",'link':'#'},{'sum':'9'},{'img':'img/duigou.png'},{'sort':'10'},{}]
];

function _onload(){
	var _theadid=document.getElementById("theadid");
	var _tr=document.createElement("tr");
	_theadid.appendChild(_tr);
	for (var i=0;i<_theadman.length;i++) {
		var _td=document.createElement("th");
		_td.setAttribute("id","_td"+i);
		_td.setAttribute("style","font-size:15px;background-color: #C0C0C0;height: 30px;border: 1px solid #A8A8A8;");
		_tr.appendChild(_td);
		if(i===0){
			var _td_input=document.createElement("input");
			_td_input.setAttribute("type","checkbox");
			_td_input.setAttribute("id","_td_input_id");
//			_td_input.setAttribute("name","allItem");
			_td_input.setAttribute("onclick","checkAll()");
			
			_td.appendChild(_td_input);
		}
		var _td_text=document.createTextNode(_theadman[i]);
		_td.appendChild(_td_text);
	}
	
	//商品列表
	for(var k=0;k<_tbodyman.length;k++){
		var _tbodyid=document.getElementById("tbodyid");
		var _tbody_tr=document.createElement("tr");
		_tbody_tr.setAttribute("id","_trid"+k);
		_tbodyid.appendChild(_tbody_tr);
	
		for (var m=0;m<_tbodyman[k].length;m++) {
			var _tbody_tr_td=document.createElement("td");
			_tbody_tr_td.setAttribute("style","border: 1px solid #C0C0C0;");
			_tbody_tr.appendChild(_tbody_tr_td);
			var _td_div=document.createElement("div");
			_td_div.setAttribute("style","padding-left: 10px;")
	    	_tbody_tr_td.appendChild(_td_div);
	    	if(m===0){
	    		var _input=document.createElement("input");
	    		_input.setAttribute("type","checkbox");
	    		_input.setAttribute("name","item");
	    		_td_div.appendChild(_input);
	    	}
	    	if(m===1){
		    	var _div_num=document.createTextNode(_tbodyman[k][m].num);
		    	_td_div.appendChild(_div_num);
		    }
	    	if(m===2){
	    		var _div_img=document.createElement("img");
	    		_div_img.setAttribute("src",_tbodyman[k][m].img);
	    		_div_img.setAttribute("style","width: 50px;height: 50px;");
	    		_td_div.appendChild(_div_img);
	    		var _img_text=document.createTextNode(_tbodyman[k][m].content);
	    		_td_div.appendChild(_img_text);
	    	}
	    	if(m===3){
	    		var _div_sum=document.createTextNode(_tbodyman[k][m].sum);
		    	_td_div.appendChild(_div_sum);
	    	}
	    	if(m===4){
	    		var _div_img4=document.createElement("img");
	    		_div_img4.setAttribute("src",_tbodyman[k][m].img);
	    		_div_img4.setAttribute("style","width: 20px;height: 20px;");
	    		_td_div.appendChild(_div_img4);
	    	}
	    	if(m===5){
	    		var _div_sort=document.createTextNode(_tbodyman[k][m].sort);
		    	_td_div.appendChild(_div_sort);
	    	}
	    	if(m===6){
	    		var a_img1=document.createElement("a");
	    		a_img1.setAttribute("href","#");
	    		_td_div.appendChild(a_img1);
	    		var a_text1=document.createTextNode("修改");
	    		a_img1.appendChild(a_text1);
	    		var _div_img1=document.createElement("img");
		    	_div_img1.setAttribute("src","img/xiu.png");
		    	a_img1.appendChild(_div_img1);
		    	
		    	var a_img2=document.createElement("a");
		    	a_img2.setAttribute("href","#");
		    	_td_div.appendChild(a_img2);
		    	var a_text2=document.createTextNode("删除");
	    		a_img2.appendChild(a_text2);
		    	var _div_img2=document.createElement("img");
		    	_div_img2.setAttribute("src","img/del1.png");
		    	a_img2.appendChild(_div_img2);
	    	}
		}
	}
	
	
}
//全选 
function checkAll(){
	var items=document.getElementsByName("item");
	var all=document.getElementById("_td_input_id");
	for (var i=0;i<items.length;i++) {
		items[i].checked=all.checked;
	}
}


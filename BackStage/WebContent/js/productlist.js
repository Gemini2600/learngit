var _ulproduct=[
	'商品名称','所属类别','货号','规格','上传照片','商品价格','点击数','是否推荐','是否降价','是否上线','商品详情'
];
//所属类别
var arr_sys = ["外套", "内搭", "裤装", "鞋子"];
	var arr_sub = [
		['夹克', '单西', '棒球服', '棉衣', '毛呢大衣', '风衣','西服套装'],
		['卫衣针织衫', '长袖衬衫', '长袖T恤', '背心', 'POLO衫','短袖T恤'],
		['休闲裤', '牛仔裤', '西裤', '小脚裤', '运动裤', '针织裤','9分裤'],
		['永远的帆布鞋', '舒适平底单鞋', '布洛克牛津鞋', '彩色豆豆鞋', '气质通勤欧美街头', '甜美优雅运动风格']
	];
//规格
var sys_size=['衣服尺码','内搭尺码','裤装尺码','鞋子尺码'];
	var arr_size=[
		'40,43,44,46,48',
		'10,20,30,40,50',
		'168,170,175,180,185',
		'38,39,40,41,42,43,44'
	];
function _onload(){
	//list-left
	var _ul=document.getElementById("ulproduct");
	for(var i=0;i<_ulproduct.length;i++){
		var _li=document.createElement("li");
		_li.setAttribute("class","li");
		_ul.appendChild(_li);
		
		var _li_p=document.createElement("p");
		_li_p.setAttribute("class","p");
		_li_p.setAttribute("id","id_p"+i);
		_li.appendChild(_li_p);
		var _li_p_text=document.createTextNode(_ulproduct[i]);
		_li_p.appendChild(_li_p_text);
	
	}
	
	//list-right
	var _right_id=document.getElementById("listdown-right-id");
	for (var j=0;j<_ulproduct.length;j++) {
		var _div_right=document.createElement("div");
		_div_right.setAttribute("class","right-div");
		_div_right.setAttribute("id","right-id"+j);
		_right_id.appendChild(_div_right);
		
		if(j===0 ||j===2 ||j===5){
			_div_right.innerHTML="<input type='text'/><span>*</span>";
		}
		//二级联动
		if(j===1){
			var _form1=document.createElement("form");
			_form1.setAttribute("name","form1");
			_div_right.appendChild(_form1);
			var _select_sys=document.createElement("select");
			_select_sys.setAttribute("id","sys");
			_select_sys.setAttribute("onchange","changeSelect(this.selectedIndex)");
			var _select_sub=document.createElement("select");
			_select_sub.setAttribute("id","sub");
			_form1.appendChild(_select_sys);
			_form1.appendChild(_select_sub);
			
			var sys = document.getElementById("sys");
			var sub =document.getElementById("sub");
			sys.length = arr_sys.length;
//			alert(sys.length);
			//循环将数组中的数据写入<option>标记中
			for(var k = 0; k < arr_sys.length; k++) {
				sys.options[k].text = arr_sys[k];
				sys.options[k].value = arr_sys[k];
			}
		
			var index = 0;
			sys.selectedIndex = index;
			sub.length = arr_sub[index].length;
		
			//循环将数组中的数据写入<option>标记中
			for(var n = 0; n < arr_sub[index].length; n++) {
				sub.options[n].text = arr_sub[index][n];
				sub.options[n].value = arr_sub[index][n];
			}
		}
		if(j===3){
			var _form2=document.createElement("form");
			_form2.setAttribute("name","form2");
			_div_right.appendChild(_form2);
			var _select_sys_size=document.createElement("select");
			_select_sys_size.setAttribute("id","sys_size");
			_select_sys_size.setAttribute("onchange","_changeSelect(this.selectedIndex)");
			var _span_arr_size=document.createElement("span");
			_span_arr_size.setAttribute("id","span_id");
			_form2.appendChild(_span_arr_size);
			_form2.appendChild(_select_sys_size);
			//将sys_size数组中的数据写入select中
			var _sys_size=document.getElementById("sys_size");
			var _arr_size=document.getElementById("span_id");
			_sys_size.length=sys_size.length;
			for(var s = 0; s< sys_size.length; s++) {
				_sys_size.options[s].text = sys_size[s];
				_sys_size.options[s].value = sys_size[s];
			}
			
			var _index = 0;
			_sys_size.selectedIndex = _index;
			_arr_size.length = arr_sub[_index].length;
		
			//循环将arr_size数组中的数据写入<span>中
			for(var q = 0; q < arr_size.length; q++) {
				_arr_size.text = arr_size[q];
//				alert(_arr_size.text); 
			}
				
		}
		//上传图片
		if(j===4){
			var input_file=document.createElement("input");
			input_file.setAttribute("type","file");
			_div_right.appendChild(input_file);
		}
	    if(j===6){
	    	var input_text=document.createElement("input");
	    	input_text.setAttribute("type","text");
	    	_div_right.appendChild(input_text);
	    }
	    if(j===7||j===8||j===9){
	    	var form3=document.createElement("form");
	    	form3.setAttribute("name","myform3");
	    	form3.setAttribute("onsubmit","return check()");
	    	_div_right.appendChild(form3);
	    	var input_radio1=document.createElement("input");
	    	input_radio1.setAttribute("type","radio");
	    	input_radio1.setAttribute("name","picno");
	    	form3.appendChild(input_radio1);
	    	var radio1=document.createTextNode("是");
	    	form3.appendChild(radio1);
	    	var input_radio2=document.createElement("input");
	    	input_radio2.setAttribute("type","radio");
	    	input_radio2.setAttribute("name","picno");
	    	input_radio2.setAttribute("style","margin-left: 20px;");
	    	form3.appendChild(input_radio2);
	    	var radio2=document.createTextNode("否");
	    	form3.appendChild(radio2);
	    	
	    }
	}	
}

function changeSelect(index) {
	//选择对象
	var sub = document.form1.sub;
	sys.selectedIndex = index;
	sub.length = arr_sub[index].length;
	//循环将数组中的数据写入<option>标记中
	for(var m = 0; m < arr_sub[index].length; m++) {
		sub.options[m].text = arr_sub[index][m];
		sub.options[m].value = arr_sub[index][m];
	}
}
function _changeSelect(_index) {

}

function check(){
	var flag=0
	for(i=0;i<myform3.picno.length;i++)
	if(myform3.picno[i].checked==true){
	flag=1;
	break;
	}
	if(!flag){
	return false;
	}
}
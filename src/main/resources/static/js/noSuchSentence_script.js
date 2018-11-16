$(document).ready(function(){
	//渲染文本
	var str = "";
	var author = "管理员";
	var dash = "——";
	var text = "(抱歉！查无此句)"
	str+=("<div class='sentence'><div class='text text-left'>"+text+"</div><div class='signature text-right'><span class='dash'>"+dash+"</span><span class='author'>"+author+"</span><span class='works'></span></div></div>");

	$("#content").html(str);
	
	//返回按钮
	$("#return").click(function(){
		location.href="index";
	});
});
	
	
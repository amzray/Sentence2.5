$(document).ready(function(){
	//渲染下拉框
	renderSelectForSearch();
	//默认选中
	$("select option:first-child").attr("selected","selected");
	
	//返回按钮
	$("#return").click(function(){
		location.href = "index";
	});
});
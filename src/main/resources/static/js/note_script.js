function renderSpeakerInput(){
	var currVal = $("#type").val();
	var str="[value='"+currVal+"']";
	var speaker = $("#type").children(str).attr("title");
	if(speaker!="无"){
		$("label[for='speaker']").text(speaker+"：");
		$("label[for='speaker']").show();
		$("input[name='speaker']").show();
	}else{
		$("label[for='speaker']").hide();
		$("input[name='speaker']").hide();
	}
}

$(document).ready(function(){
	//检查句子是否为空
	$("#noteform").submit(function(ev){
		if($("#sentence").children(":first").val()==""){
			ev.preventDefault();
			$("#prompt").text("句子不能为空!");
		}
	});
	
	//获取到后台返回到前台的结果，录入成功
	var s = $("#status").text();
	if(s==1){
		$("#prompt").text("提交成功！");
	}
	
	//返回按钮
	$("#return").click(function(){
		location.href = "index";
	});
	
	//渲染语言类型和体裁类型的下拉框
	renderSelect();
	//默认选中
	$("select").children(":first").attr("selected","selected");
	
	renderSpeakerInput();
	
	//根据体裁类型中的字符渲染歌者/人物/角色输入框的标签
	$("#type").change(function(){
		renderSpeakerInput();
	});
	
	
});
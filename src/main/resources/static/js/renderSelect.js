
	
	//渲染语言类型和体裁类型的下拉框
	function renderSelect(){
		var types = JSON.parse($("#typesjson").text());
		var tstr ="";
		for(var i=0; i<types.length; i++){
			tstr += ("<option value='"+types[i].id+"' title='"+types[i].stype+"'>"+ types[i].name +"</option>");
		}
		$("#type").html(tstr);
		//默认选中
		
		var langs = JSON.parse($("#langsjson").text());
		var lstr ="";
		for(var i=0; i<langs.length; i++){
			lstr += ("<option value='"+langs[i].id+"'>"+ langs[i].name+"</option>");
		}
		$("#lang").html(lstr);
		
	}
	
	//渲染语言类型和体裁类型的下拉框
	function renderSelectForSearch(){
		renderSelect();
		var unlimited = ("<option value='0'>(不限)</option>");
		$(unlimited).prependTo("#type");
		$(unlimited).prependTo("#lang");
	}
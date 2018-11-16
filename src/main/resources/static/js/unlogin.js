var seconds =1;
$(document).ready(function(){
	$("#sec").html(seconds);
	setInterval(function(){
		seconds--;
		if(seconds==0){
			window.location.replace("${pageContext.request.contextPath}/login");
		}else{
			$("#sec").html(seconds);
		}
	},1000);
});
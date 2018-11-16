<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>LzL的截句本-登录</title>

<link rel="icon" href="image/favicon.ico"  type="image/x-icon" />
<link rel="shortcut icon" href="image/favicon.ico"  type="image/x-icon" />
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/head.css">


<style>
	#page{margin-top:210px; font-family:Microsoft YaHei;}
	[type=password]{height:30px; width:210px; text-size:16px; background-color:rgba(255,255,255,0.5);}
	button{height:40px; width:100px; margin-top:5px;  background-color:rgba(255,255,255,0.5);}
	#prompt{height:20px; width:100px;}
	#test{display:none;}
</style>
</head>
<body>
	<div class="container">
	  	<div id="head" class="col-4 offset-4 text-center">
	  		<div id="title_frame" class="" >
		    	<div id="title" class="text-center" >
		    		<h1 class="font-weight-bold">梁哲浪的截句本</h1>
		    	</div>
		    	<img src="title_frame.png"/>
		    </div>
		    
		</div>
	    
	   <div id="page" class="col-4 offset-4 text-center"> 
		   <div id="form" class="">
		    	<form id="loginform" action="${pageContext.request.contextPath}/login" method="POST">
		    	<div><input type="password" name="password" id="pwtxt" placeholder="密码"/></div>
		    	<span id="prompt" class="text-center text-muted"></span>
		    	<div><button type="submit" class="btn btn-outline-dark">登录</button></div>
		    	</form>
		    </div>
	    </div>
	    
	    <div id="test">${param.passwordStatus}</div>
	</div>
	
	<script>
	$(document).ready(function(){
		$("#loginform").submit(function(ev){
			if($("#pwtxt").val()==""){
				ev.preventDefault();
				$("#prompt").text("密码不能为空!");
			}
		});
		
		var pws = $("#test").text();
		if(pws==-1){
			$("#prompt").text("密码错误!");
		}
	});
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LzL的截句本-落笔</title>
<link rel="icon" href="image/favicon.ico"  type="image/x-icon" />
<link rel="shortcut icon" href="image/favicon.ico"  type="image/x-icon" />
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<script src="js/url.js"></script>
<script src="js/renderSelect.js?v=2"></script>
<script src="js/note_script.js?v=7"></script>


<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/head.css">
<link rel="stylesheet" href="css/mybutton.css">
<link rel="stylesheet" href="css/form.css?v=3">
<link rel="stylesheet" href="css/borders.css?v=2">


</head>
<body>
<div class="container">
	  	<div id="head" class="row">
	  		<div id="title_frame" class="col-6 offset-3" >
		    	<div id="title" class="text-center" >
		    		<h1 class="font-weight-bold">梁哲浪的截句本</h1>
		    	</div>
		    </div>
		 </div>
	    
	   <div class="row">
	   	 	<div class="col-8 offset-2 text-center myframe">
		    	<form id="noteform" action="${pageContext.request.contextPath}/note" method="POST" accept-charset="utf-8">
					<div class="row">
						<div class="col-4 text-left"><div id="prompt" class=""></div></div>
						<div class="col-8 text-right">
							<span class="col-6 "><label for="lang">语言：</label><select id="lang"  name="languageId"></select></span>
							<span class="col-6"><label for="type">体裁：</label><select id="type" name="typeId"></select></span>
						</div>
					</div>
					<div class="row row1">
						<div id="text" class="col-12"><textarea name="text" placeholder="句子"></textarea></div>
					</div>
					<div class="row row1">
						<div id="author" class="col-6"><label for="author">作者：</label><input class="text1" type="text" name="author"/></div>
						<div id="works" class="col-6" ><label for="works">出处：</label><input class="text1" type="text" name="works"/></div>
					</div>
					<div class="row row1">
						<div id="speaker" class="col-6" ><label for="speaker"></label><input class="text1" type="text" name="speaker" /></div>
						<div id="location" class="col-6" ><label for="location">段落：</label><input class="text1" type="text" name="location"/></div>
					</div>
					<div class="row row1">
						<div id="reflection" class="col-12"><textarea name="reflection" placeholder="心得"></textarea></div>
					</div>
					<div class="row row1">
						<div id="labels" class="col-12"><label for="type">标签：</label><input class="text2" type="text" name="labels" /></div>
					</div>
					<div class="row1 text-center">
						<span class="btn1"><button type="submit" class="btn btn-outline-dark">▶️</button></span>
						<span class="btn2"><button type="reset" class="btn btn-outline-dark">⏪</button></span>
						<span class="btn2"><button id="return" type="button" class="btn btn-outline-dark">👋</button></span>
					</div>
				</form>
	   	 </div>
	   </div>
	    
	    <div id="status" class="text-hide">${status}</div>
	    <div id="langsjson" class="text-hide">${langs}</div>
	    <div id="typesjson" class="text-hide">${types}</div>
	</div>
	
</body>
</html>
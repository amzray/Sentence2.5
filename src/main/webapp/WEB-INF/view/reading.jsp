<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LzL的截句本-阅览</title>
<link rel="icon" href="image/favicon.ico"  type="image/x-icon" />
<link rel="shortcut icon" href="image/favicon.ico"  type="image/x-icon" />
<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<script src="js/url.js"></script>
<script src="js/renderSelect.js?v=6"></script>
<script src="js/reading_script.js?v=4"></script>

<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/head.css">
<link rel="stylesheet" href="css/mybutton.css">
<link rel="stylesheet" href="css/form.css">
<link rel="stylesheet" href="css/content.css">
<link rel="stylesheet" href="css/page.css?v=2">
<link rel="stylesheet" href="css/borders.css">

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
	    
		<div id="page" class="col-8 offset-2 text-center myframe">
		   	<div id="searchmenu" class="downline">
		   		<div class="col-1 offset-11 text-right"><label id="trigger" class="icon">○</label></div>
		   		<form id="searchform"  action="${pageContext.request.contextPath}/reading" method="GET" accept-charset="utf-8">
		   			<input  type="hidden" name="currPage" value="1"/>
		   			<div class="row">
						<div class="col-4 text-left"><div id="prompt" class=""></div></div>
						<div class="col-8 text-right">
							<span class="col-6 "><label for="lang">语言：</label><select id="lang"  name="languageId"></select></span>
							<span class="col-6"><label for="type">体裁：</label><select id="type" name="typeId"></select></span>
						</div>
					</div>
					<div class="row row1">
						<div id="author" class="col-6"><label for="author">作者：</label><input class="text1" type="text" name="author"/></div>
						<div id="works" class="col-6" ><label for="works">出处：</label><input class="text1" type="text" name="works"/></div>
					</div>
					<div class="row row1">
						<span id="text" class="col-12"><label for="text">文本：</label><input class="text2" type="text" name="text"/></span>
		   			</div>
					<div class="row1 text-center">
						<div class="col-4 offset-4"></div>
						<span class="col-6"><button type="submit" class="btn btn-outline-dark">🔎</button></span>
						<span class="col-6"><button type="reset" class="btn btn-outline-dark">⏪</button></span>
					</div>
		   		</form>
		   	</div>
		   	<div id="content"></div>
		</div>
		<div id="options"class="text-center">
			<span id="pagePre"class="btnmove"><button type="button" class="btn btn-outline-dark">◀️</button></span>
	   		<span id="pageNums"></span>
	   		<span id="pageNext"class="btnmove"><button type="button" class="btn btn-outline-dark">▶️</button></span>
   			<span id="top"class=""><button type="button" class="btn btn-outline-dark">🔝</button></span>
   			<span id="return"class=""><button type="button" class="btn btn-outline-dark">👋</button></span>
			
   		</div>
	   	<div id="langsjson" class="text-hide">${langs}</div>
   		<div id="typesjson" class="text-hide">${types}</div>
		<div id="test"></div>
			
		
	</div>
</body>
</html>
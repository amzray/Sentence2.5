<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>LzL的截句本-索引</title>


<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/popper.js/1.12.5/umd/popper.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>

<script src="js/url.js"></script>
<script src="js/index_script.js"></script>
<script src="js/head_html.js"></script>

<link rel="icon" href="image/favicon.ico"  type="image/x-icon" />
<link rel="shortcut icon" href="image/favicon.ico"  type="image/x-icon" />

<link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/4.1.0/css/bootstrap.min.css">
<link rel="stylesheet" href="css/global.css">
<link rel="stylesheet" href="css/head.css">
<link rel="stylesheet" href="css/mybutton.css">
<link rel="stylesheet" href="css/indexc.css?v=5">


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
	    
	   <div id="menu" class="text-center col-6 offset-3">
	   		<div class="row">
	    		<span class="col-3 offset-3"><button id="note" class="btn btn-outline-dark ">✍</button></span>
				<span class="col-3 "><button id="search" class="btn btn-outline-dark ">🔍</button></span>
	    	</div>
	    	<div class="row">
	    		<span class="col-3 offset-3"><button id="reading" class="btn btn-outline-dark">📖</button></span>
				<span class="col-3 "><button id="one" class="btn btn-outline-dark">📃</button></span>
	    	</div>
	    	<div class="row">
	    		<span class="col-3 offset-3"><button id="x" class="btn btn-outline-dark" disabled="disabled">x</button></span>
				<span class="col-3 "><button id="cancel"  class="btn btn-outline-dark" disabled="disabled">👋</button></span>
	    	</div>
	    	
	    </div>
	    
	    <div id="welcome" class="text-center"><h4 class="font-weight-bold"><!-- Hello, the only ${uid}. --> </h4></div>
    
	</div>
	
</body>
</html>
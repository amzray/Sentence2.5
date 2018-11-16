
		//渲染内容
		function renderContent(result){
			var str = "";
			var author;
			var works;
			var dash;
			for(var i = 0; i<result.pageSize; i++){
				author = (result.list[i].author==null)?"":result.list[i].author;
				works = (result.list[i].works==null||result.list[i].works=="")?"":("《"+result.list[i].works+"》");
				dash = (author==""&&works=="")?"":"——";
				str+=("<div id='"+ result.list[i].id +"' class='sentence'><div class='text text-left'><a href='"+getContextPath()+"/one?sid="+result.list[i].id+"'>"+result.list[i].text.replace(/\r\n/g,"<br/>").replace(" ", "&nbsp")+"</a></div><div class='signature text-right'><span class='dash'>"+dash+"</span><span class='author'>"+author+"</span><span class='works'>"+works+"</span></div></div><br/>");
			}
			$("#content").html(str);
		}
		
		
		
		function renderPageSelect(result){
			var str = "";
			//生成首页按钮
			if(result.startPage>1){
				str += ("<span id='p"+1+"' class='btnjump'><button type='button' class='btn btn-outline-dark'>"+1+"</button></span>");
				//生成省略号
				if(result.startPage>2){
					str += ("<span class='etc'>...</span>");
				}
			}
			//生成页码按钮组
			
			for(var i = result.startPage; i<=result.endPage; i++){
				str += ("<span id='p"+i+"' class='btnjump'><button type='button' class='btn btn-outline-dark'>"+i+"</button></span>");
			}
			//
			//生成尾页按钮
			if(result.endPage<result.totalPage){
				//生成省略号
				if(result.endPage<result.totalPage-1){
					str += ("<span class='etc'>...</span>");
				}
				str += ("<span id='p"+result.totalPage+"' class='btnjump'><button type='button' class='btn btn-outline-dark'>"+result.totalPage+"</button></span>");
				
				
			}
			
			$("#pageNums").html(str);
			//禁用并高亮当前页的按钮
			$("#p"+result.currPage).children("button").attr("class", "btn btn-dark");
			$("#p"+result.currPage).children("button").attr("disabled","true");
			//判断是否有上一页/下一页，禁用相应的按钮
			if(result.currPage==1){
				$("#pagePre").children("button").attr("disabled","true");
			}
			if(result.currPage==result.totalPage){
				$("#pageNext").children("button").attr("disabled","true");
			}
		}
		
		//设置按钮的跳转目标
		function setBtnsTarget(result){
			//获取当前URL
			
			//根据跳转到的页面重新设置URL的currPage参数
			//数字
			$(".btnjump").children("button").click(function(){
				var url = location.href;
				location.href = url.replace(/currPage=\d*/, ("currPage="+ $(this).text()));
			});
			//上一页
			$("#pagePre").children("button").click(function(){
				var url = location.href;
				location.href = url.replace(/currPage=\d*/, ("currPage="+(result.currPage-1)));
			});
			//下一页
			$("#pageNext").children("button").click(function(){
				var url = location.href;
				location.href = url.replace(/currPage=\d*/, ("currPage="+(result.currPage+1)));
			});
			
			
		}
		
		//没有查询到结果的处理
		function noRecord(){
			location.href="nss";
		}
		
		
	
		function renderPage(urlstr){
			
			//根据条件添加参数
			if($.getUrlParam("author")!=null){
				urlstr += "&author=" + $.getUrlParam("author");
			}
			if($.getUrlParam("works")!=null){
				urlstr += "&works=" + $.getUrlParam("works");
			}
			if($.getUrlParam("text")!=null){
				urlstr += "&text=" + $.getUrlParam("text");
			}
			if($.getUrlParam("languageId")!=null){
				urlstr += "&languageId=" + $.getUrlParam("languageId");
			}
			if($.getUrlParam("typeId")!=null){
				urlstr += "&typeId=" + $.getUrlParam("typeId");
			}
			//异步请求并渲染
			$.ajax({url:urlstr,
	  			cache:false,
	  			success:function(result){
	  				//查询到结果
	  				if(result.totalRecord!=0){
	  					//渲染内容
	  					renderContent(result);
	  					//渲染页码选单
						renderPageSelect(result);
	  					//设置按钮的跳转链接
	  					setBtnsTarget(result);
	  				}else{//没有查询到结果
	  					noRecord();
	  				}
	  				
		  		},error:function(){
		  		}
		  	});
		}
		
		$(document).ready(function(){
			//隐藏查询菜单
			$("#searchform").hide();
			//渲染下拉框
			renderSelectForSearch();
			//默认选中
			$("select option:first-child").attr("selected","selected");
			
			//查询表单打开/关闭动画
			$("#trigger").click(function(){
				$("#searchform").slideToggle("middle");
			});
			//返回扉页按钮
			$("#return").children("button").click(function(){
				location.href =  "index";
			});
			//返回顶部按钮
			$("#top").children("button").click(function(){
				$(window).scrollTop(0);
			});
			
			
			var str1 = getContextPath()+"/rp?currPage="+$.getUrlParam("currPage");
			//异步获取内容页面
		  	renderPage(str1);
			
			
		  
		});
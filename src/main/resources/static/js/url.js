		//定义获取URL中项目路径的方法
		function getContextPath() {
		      var contextPath = document.location.pathname;
		      var index = contextPath.substr(1).indexOf("/");
		      contextPath = contextPath.substr(0, index + 1);
		      delete index;
		      return contextPath;
		}
		//定义一个获取URL中请求参数的方法
		(function ($) {
		  $.getUrlParam = function (name) {
		   var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
		   var r = window.location.search.substr(1).match(reg);
		   if (r != null) return unescape(r[2]); return null;
		  }
		 })(jQuery);
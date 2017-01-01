$(function() {
	
	var sessionId = $.urlParam('sessionId');
	if(!sessionId){
		if(history.state){
			if(history.state.sessionId.length > 30){
				sessionId = history.state.sessionId;
			}
		}
	}
	
	if(sessionId){
		/*单页面应用可用,多页面无效？
		if($.urlParamExists("sessionId",document.referrer)){
			document.referrer = $.changeURLArg(document.referrer,"sessionId",data.result);
		}else{
			document.referrer = document.referrer+"?sessionId=" + sessionId;
		}*/
		/*hide login button*/
		$("#loginTitle").addClass("hidden");
		
		$("#logoutTitle").click(function(){
			$.logout();
		});
		
		$(".a-clean").click(function(){
			var tempHref = $(this).attr("href");
			$(this).attr("href",tempHref+"?sessionId="+sessionId);
		});
	}else{
		/*hide logout button*/
		$("#logoutTitle").addClass("hidden");
		
	};

});
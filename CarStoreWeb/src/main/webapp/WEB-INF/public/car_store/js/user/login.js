$(function() {
	
	$("#userLoginForm").submit(function(event) {
		event.preventDefault();
		
		var param = {
			name : $("#inputEmail3").val(),
			password : $("#inputPassword3").val()
		};
		
		var userRegisterOption = {
				type : 'POST',
				url : '/CarStoreWeb/user/action/login',
				data : {
					ajaxData:JSON.stringify(param)
				},
				success : function(data) {
					if (data) {
						if(data.success){
							/*push session id to browser history states*/
							if(history.state){
								if(history.state.sessionId){
									var stateObj = { sessionId: data.result };
									history.replaceState(stateObj, "", "");
								}else{
									var stateObj = { sessionId: data.result };
									history.pushState(stateObj, "", "");
								}
							}
							/*add session id to url params*/
							if($.urlParamExists("sessionId",document.referrer)){
								$(location).attr('href',$.changeURLArg(document.referrer,"sessionId",data.result));
							}else{
	                            $(location).attr('href',document.referrer+"?sessionId=" + data.result);
							}
                            /*history.go(-1);*/
						}else{
							if(data.result){
								alert("登陆失败 " + data.result);
							}else{
								alert("用户不存在！");
							}
						}
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
				},
				timeout : function(data) {
				}
			};
		// initialize the page
		$.ajax(userRegisterOption);
		
	});

});
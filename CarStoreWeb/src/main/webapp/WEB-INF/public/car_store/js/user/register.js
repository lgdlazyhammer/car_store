$(function() {
	
	$("#inputEmail3").blur(function(){
		
		var param = {
			name : $("#inputEmail3").val()
		};
		
		var checkUserExistsOption = {
				type : 'POST',
				url : '/CarStoreWeb/user/action/checkUserExists',
				data : {
					ajaxData:JSON.stringify(param)
				},
				success : function(data) {
					if (data) {
						if(data.success){
							if($("#userExistInfo").hasClass("hidden")){
								$("#userExistInfo").removeClass("hidden");
							}
						}else{
							$("#userExistInfo").addClass("hidden");
						}
					}
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
				},
				timeout : function(data) {
				}
			};
		// initialize the page
		$.ajax(checkUserExistsOption);
	});
	
	$("#inputEmail3").blur();
	
	
	$("#userRegisterForm").submit(function(event) {
		event.preventDefault();
		
		var param = {
			name : $("#inputEmail3").val(),
			password : $("#inputPassword3").val()
		};
		
		var userRegisterOption = {
				type : 'POST',
				url : '/CarStoreWeb/user/action/register',
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
							/*$.cookie('userId', data.result);*/
							$(location).attr('href','/CarStoreWeb/car/register?sessionId=' + data.result);
						}else{
							alert(data.result);
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
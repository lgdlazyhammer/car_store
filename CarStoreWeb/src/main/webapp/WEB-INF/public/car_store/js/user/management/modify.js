$(function() {
	
	$("#userManagementModifyForm").submit(function(event) {
		event.preventDefault();
		
		var param = {
			id : $("#userManagemenetModifyUserId").val(),
			roleId : $("#managementUserType").val()
		};
		
		var sessionId = $.urlParam('sessionId');
		if(!sessionId){
			if(history.state){
				if(history.state.sessionId.length > 30){
					sessionId = history.state.sessionId;
				}
			}
		}
		
		if(sessionId){

			var userSearchOption = {
					type : 'POST',
					url : '/CarStoreWeb/user/action/management/modify?sessionId=' + sessionId,
					data : {
						ajaxData:JSON.stringify(param)
					},
					success : function(data) {
						if (data) {
							if(data.success){
								/*push session id to browser history states*/
								$("#userRoleModifyResult").removeClass("hidden");
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
			$.ajax(userSearchOption);
		}else{
			alert("user did not login.");
		}
		
	});
	
});
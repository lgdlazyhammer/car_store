$(function() {
	
	$("#userCarModifyForm").submit(function(event) {
		event.preventDefault();
		
		var sessionId = $.urlParam('sessionId');
		if(!sessionId){
			if(history.state){
				if(history.state.sessionId.length > 30){
					sessionId = history.state.sessionId;
				}
			}
		}
		
		if(sessionId){
			
			var param = {
				id : $("#userCarId").val(),
				carTypeId : $("#userCarType").val(),
				description : $("#userCarDescription").val()
			};

			var userSearchOption = {
					type : 'POST',
					url : '/CarStoreWeb/car/action/modify?sessionId=' + sessionId,
					data : {
						ajaxData:JSON.stringify(param)
					},
					success : function(data) {
						if (data) {
							if(data.success){
								/*push session id to browser history states*/
								$("#userCarModifyResult").removeClass("hidden");
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
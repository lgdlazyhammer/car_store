$(function() {
	
	$("#userSearchForm").submit(function(event) {
		event.preventDefault();
		
		var param = {
			name : $("#inputEmail3").val()
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
					url : '/CarStoreWeb/user/action/management/search?sessionId=' + sessionId,
					data : {
						ajaxData:JSON.stringify(param)
					},
					success : function(data) {
						if (data) {
							if(data.success){
								/*push session id to browser history states*/
								$("#displayUsers").removeClass("hidden");
								Transparency.render(document.getElementById('displayUsers'), data.result);
								$(".management-modify-user").click(function(){
									var userId = $(this).children("span").eq(0).text();
									$("#userManagementModifyForm").children().eq(0).val(userId);
									$("#userManagementModifyForm").children().eq(1).val(sessionId);
									$("#userManagementModifyForm").submit();
								});
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
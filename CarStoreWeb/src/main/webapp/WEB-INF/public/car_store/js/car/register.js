$(function() {
	
	var userId = $.urlParam('sessionId');

	$("#carRegisterForm").submit(function(event) {
		event.preventDefault();
		
		var param = {
			userId : userId,
			carTypeId : $("#carRegisterType").val(),
			description : $("#inputDescription").val()
		};
		
		var userRegisterOption = {
				type : 'POST',
				url : '/CarStoreWeb/car/action/register?sessionId='+userId,
				data : {
					ajaxData:JSON.stringify(param)
				},
				success : function(data) {
					if (data) {
						if(data.success){
							/*$(location).attr('href','/CarStoreWeb/'+"?sessionId=" + userId);*/
							location.reload();
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
$(function() 
{
	$("#scheduleModifyForm").submit(function(event) 
	{
		event.preventDefault();
		
		var sessionId = $.urlParam('sessionId');
		
		if(sessionId)
		{
			var param = {
				id : $("#scheduleId").val(),
				timeStart : $("#scheduleStartTime").val()?$("#scheduleStartTime").val()+":00":"",
				timeEnd : $("#scheduleEndTime").val()?$("#scheduleEndTime").val()+":00":""
				};
				
			var userRegisterOption = {
					type : 'POST',
					url : '/CarStoreWeb/schedule/action/management/modify?sessionId='+sessionId,
					data : {
						ajaxData:JSON.stringify(param)
					},
					success : function(data) {
						if (data) {
							if(data.success){
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
		}else{
			alert("user did not login.");
		}
			
	});

});
$(function() 
{
	$(".schedule-search-item").click(function(){
		
		var sessionId = $.urlParam('sessionId');
		
		if(sessionId)
		{
			var param = {
					id : $(this).attr("title")
				};
				
			var scheduleCalendarOption = {
					type : 'POST',
					url : '/CarStoreWeb/schedule/action/delete?sessionId='+sessionId,
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
				$.ajax(scheduleCalendarOption);
		}else{
			alert("user did not login.");
		}
	});
	
});